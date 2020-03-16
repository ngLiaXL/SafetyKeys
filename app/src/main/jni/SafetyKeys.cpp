#include <jni.h>
#include <com_ngliaxl_safetykeys_SafetyKeys.h>

extern "C" {
/*
 * Class:     com_ngliaxl_safetykeys_SafetyKeys
 * Method:    nativeAccessKey
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_ngliaxl_safetykeys_SafetyKeys_nativeAccessKey
  (JNIEnv * env, jobject obj){
 jclass des_class = env->FindClass("com/ngliaxl/safetykeys/DES");
    if (env->ExceptionCheck()) {
        env->ExceptionClear();
      return NULL;
    }

    jmethodID decrypt_id = env->GetStaticMethodID(des_class, "decrypt", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;");
    if (env->ExceptionCheck()) {
        env->ExceptionClear();
      return NULL;
    }
    jstring access_key = env->NewStringUTF("urBJqAZ7vwf3KZT8UY7zTeDlQMT4hQRR");
    jstring des_key = env->NewStringUTF("nullnull");

    jstring decrypt_key = (jstring) env->CallStaticObjectMethod(des_class, decrypt_id, access_key,des_key);
    if (env->ExceptionCheck()) {
        env->ExceptionClear();
      return NULL;
    }
    return decrypt_key;

  }

}

