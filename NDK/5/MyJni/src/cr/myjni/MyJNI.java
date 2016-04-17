package cr.myjni;

import android.R.integer;
import android.content.Context;
import android.widget.Toast;

public class MyJNI
{
	private Context mContext;
	
	static
	{
		System.loadLibrary("MyJni"); //���ض�̬��
	}
	
	MyJNI(Context context)
	{
		mContext = context;
	}
	
	public void ShowMsg(String strMsg)
	{
		Toast.makeText(mContext, strMsg, Toast.LENGTH_LONG).show();
	}
	
	public native int GetNumber();  //����һ�����ط���
	public static native int GetNumber2();
	public  native String GetNumber3(String str);

	private int m_nData = 0;
}
