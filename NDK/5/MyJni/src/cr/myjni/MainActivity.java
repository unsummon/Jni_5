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
            //运行时类型识别
            //java反射 MyJNI Show hello
            Class<?> cls;
            //cls = MyJNI.class;
            cls = Class.forName("cr.myjni.MyJNI");
            
            //new对象
			//Object obj = cls.newInstance(); //默认构造
            //Constructor<?> Constructor = cls.getConstructor(Context.class); //获取公有构造函数
            Constructor<?> Constructor = cls.getDeclaredConstructor(Context.class); //获取所有的构造函数
            Object obj = Constructor.newInstance(this); //带参数构造
			
			//获取成员
            Method MethodShowMsg = cls.getMethod("ShowMsg", String.class);
			
			//调用
			MethodShowMsg.invoke(obj, "hello");
			
			//获取数据成员
			//Field m_nData = cls.getField("m_nData");
			Field m_nData = cls.getDeclaredField("m_nData");
			m_nData.setAccessible(true); //修改访问权限
			m_nData.set(obj, 100);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
    }
}
