LOCAL_PATH := $(call my-dir)


include $(CLEAR_VARS)
LOCAL_MODULE := fmod
LOCAL_SRC_FILES := libfmod.so
#LOCAL_EXPORT_C_INCLUDES := ffmpeg-build/$(TARGET_ARCH_ABI)/include
#LOCAL_ARM_NEON:=true
include $(PREBUILT_SHARED_LIBRARY)


include $(CLEAR_VARS)
LOCAL_MODULE := fmodL
LOCAL_SRC_FILES := libfmodL.so
#LOCAL_EXPORT_C_INCLUDES := ffmpeg-build/$(TARGET_ARCH_ABI)/include
#LOCAL_ARM_NEON:=true
include $(PREBUILT_SHARED_LIBRARY)


include $(CLEAR_VARS)
LOCAL_MODULE    := voice
#LOCAL_SRC_FILES := my_sound.cpp
LOCAL_SRC_FILES := dsp_custom.cpp common.cpp common_platform.cpp
LOCAL_LDLIBS := -llog 

LOCAL_SHARED_LIBRARIES:= fmod fmodL
include $(BUILD_SHARED_LIBRARY)
