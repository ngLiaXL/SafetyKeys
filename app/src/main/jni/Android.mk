LOCAL_PATH:=$(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE := SafetyKeys
LOCAL_SRC_FILES := SafetyKeys.cpp
LOCAL_LDLIBS := -llog
include $(BUILD_SHARED_LIBRARY)