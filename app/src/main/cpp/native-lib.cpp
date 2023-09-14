#include <jni.h>

#include <sys/resource.h>

#include <string>
#include <fstream>

#include <process/process.hpp>

extern "C" JNIEXPORT jlong JNICALL
Java_org_ttldtor_processexample_MainActivity_getKernelProcessorTime(
        JNIEnv *env,
        jobject /* this */) {
    return ttldtor::process::Process::getKernelProcessorTime().count();
}

extern "C" JNIEXPORT jlong JNICALL
Java_org_ttldtor_processexample_MainActivity_getUserProcessorTime(
        JNIEnv *env,
        jobject /* this */) {
    return ttldtor::process::Process::getUserProcessorTime().count();
}
extern "C" JNIEXPORT jlong JNICALL
Java_org_ttldtor_processexample_MainActivity_getTotalProcessorTime(
        JNIEnv *env,
        jobject /* this */) {
    return ttldtor::process::Process::getTotalProcessorTime().count();
}
extern "C" JNIEXPORT jlong JNICALL
Java_org_ttldtor_processexample_MainActivity_getWorkingSetSize(
        JNIEnv *env,
        jobject /* this */) {
    return static_cast<jlong>(ttldtor::process::Process::getWorkingSetSize());
}
extern "C" JNIEXPORT jlong JNICALL
Java_org_ttldtor_processexample_MainActivity_getPrivateMemorySize(
        JNIEnv *env,
        jobject /* this */) {
    return static_cast<jlong>(ttldtor::process::Process::getPrivateMemorySize());
}