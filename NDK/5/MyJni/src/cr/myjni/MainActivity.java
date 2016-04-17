package cr.myjni;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Runtime.getRuntime().exec("su");
        MyJNI jni = new MyJNI(this);
        jni.ShowMsg("hellO");
        String Number = jni.GetNumber3("hello");
        TextView textView = (TextView)findViewById(R.id.textView1);
        textView.setText("nNumber:" + Number);
        
       
        try
		{
            //����ʱ����ʶ��
            //java���� MyJNI Show hello
            Class<?> cls;
            //cls = MyJNI.class;
            cls = Class.forName("cr.myjni.MyJNI");
            
            //new����
			//Object obj = cls.newInstance(); //Ĭ�Ϲ���
            //Constructor<?> Constructor = cls.getConstructor(Context.class); //��ȡ���й��캯��
            Constructor<?> Constructor = cls.getDeclaredConstructor(Context.class); //��ȡ���еĹ��캯��
            Object obj = Constructor.newInstance(this); //����������
			
			//��ȡ��Ա
            Method MethodShowMsg = cls.getMethod("ShowMsg", String.class);
			
			//����
			MethodShowMsg.invoke(obj, "hello");
			
			//��ȡ���ݳ�Ա
			//Field m_nData = cls.getField("m_nData");
			Field m_nData = cls.getDeclaredField("m_nData");
			m_nData.setAccessible(true); //�޸ķ���Ȩ��
			m_nData.set(obj, 100);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
    }
}
