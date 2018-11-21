
#ifndef _LOG_H
#define _LOG_H

#include <android/log.h>
#include <stdlib.h>
#define LOG_TAG "Test_Jni"

//用于打印debug级别的log信息
//__VA_ARGS__ 可变参数
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)

//用于打印info级别的log信息
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

//用于打印error级别的log信息
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)

#endif //_LOG_H
