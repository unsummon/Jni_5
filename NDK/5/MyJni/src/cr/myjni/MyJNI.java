package cr.myjni;

import android.R.integer;
import android.content.Context;
import android.widget.Toast;

public class MyJNI
{
	private Context mContext;
	
	static
	{
		System.loadLibrary("MyJni"); //加载动态库
	}
	
	MyJNI(Context context)
	{
		mContext = context;
	}
	
	public void ShowMsg(String strMsg)
	{
		Toast.makeText(mContext, strMsg, Toast.LENGTH_LONG).show();
	}
	
	public native int GetNumber();  //声明一个本地方法
	public static native int GetNumber2();
	public  native String GetNumber3(String str);

	private int m_nData = 0;
}
