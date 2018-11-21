
#ifndef _LOG_H
#define _LOG_H

#include <android/log.h>
#include <stdlib.h>
#define LOG_TAG "Test_Jni"

//���ڴ�ӡdebug�����log��Ϣ
//__VA_ARGS__ �ɱ����
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)

//���ڴ�ӡinfo�����log��Ϣ
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

//���ڴ�ӡerror�����log��Ϣ
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)

#endif //_LOG_H
