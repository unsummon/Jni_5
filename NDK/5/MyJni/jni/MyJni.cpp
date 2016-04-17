#include "MyJNI.h"
#include <stdio.h>
#include <android/log.h>

/*
 * Class:     cr_myjni_MyJNI
 * Method:    GetNumber
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_cr_myjni_MyJNI_GetNumber
  (JNIEnv *env, jobject obj)
{
	return 1;
}


/*
 * Class:     cr_myjni_MyJNI
 * Method:    GetNumber2
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_cr_myjni_MyJNI_GetNumber2
  (JNIEnv *env, jclass cls)
{
	return 2;
}

/*
 * Class:     cr_myjni_MyJNI
 * Method:    GetNumber3
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_cr_myjni_MyJNI_GetNumber3
  (JNIEnv *env, jobject obj, jstring str)
{
	int nLength = env->GetStringUTFLength(str);
	jboolean IsCopy = false;
	const char *psz = env->GetStringUTFChars(str, &IsCopy);

	//jclass cls = env->FindClass("Lcr/myjni/MyJNI;");

	jclass cls = env->GetObjectClass(obj);
	__android_log_print(ANDROID_LOG_DEBUG, "jni", "FindClass");

	jmethodID ShowMsg = env->GetMethodID(cls, "ShowMsg", "(Ljava/lang/String;)V");
	__android_log_print(ANDROID_LOG_DEBUG, "jni", "GetMethodID");


	env->CallVoidMethod(obj, ShowMsg, "JNI");
	__android_log_print(ANDROID_LOG_DEBUG, "jni", "CallVoidMethod");


	return env->NewStringUTF("123");
}
