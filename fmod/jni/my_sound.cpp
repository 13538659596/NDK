#include "com_example_fmod_FmodUtils.h"
#include "common.h"
#include "inc/fmod.hpp"
#include "inc/log.h"
#include "inc/fmod_errors.h"
#include <unistd.h>
#include <jni.h>

/*
 * Class:     com_example_fmod_FmodUtils
 * Method:    playsound
 * Signature: (Ljava/lang/String;I)V
 */
using namespace FMOD;
JNIEXPORT void JNICALL Java_com_example_fmod_FmodUtils_playsound(JNIEnv * env,
		jobject jobj, jstring jstr, jint mode) {

	const char *path = env->GetStringUTFChars(jstr, NULL);
	LOGE("path: %s\n", path);
	System *system;
	Sound *sound;
	Channel *channel = 0;
	FMOD_RESULT result;
	bool playing = true;
	DSP *dsp = 0;
	float frequency = 0;

	System_Create(&system);
	system->init(32, FMOD_INIT_NORMAL, NULL);
	system->createSound(path, FMOD_DEFAULT, 0, &sound);

	switch (mode) {
	case MODE_NORMAL:
		system->playSound(sound, 0, false, &channel);

		break;
	case MODE_LUOLI:
		system->createDSPByType(FMOD_DSP_TYPE_PITCHSHIFT, &dsp);
		//设置音调的参数
		dsp->setParameterFloat(FMOD_DSP_PITCHSHIFT_PITCH, 2.5);

		system->playSound(sound, 0, false, &channel);
		//添加到channel
		channel->addDSP(0, dsp);
		break;
	case MODE_JINGSONG:
		//惊悚
		system->createDSPByType(FMOD_DSP_TYPE_TREMOLO, &dsp);
		dsp->setParameterFloat(FMOD_DSP_TREMOLO_SKEW, 0.5);
		system->playSound(sound, 0, false, &channel);
		channel->addDSP(0, dsp);

		break;
	case MODE_DASHU:
		//大叔
		system->createDSPByType(FMOD_DSP_TYPE_PITCHSHIFT, &dsp);
		dsp->setParameterFloat(FMOD_DSP_PITCHSHIFT_PITCH, 0.8);

		system->playSound(sound, 0, false, &channel);
		//添加到channel
		channel->addDSP(0, dsp);
		break;
	case MODE_GAOGUAI:
		//搞怪
		//提高说话的速度
		system->playSound(sound, 0, false, &channel);
		channel->getFrequency(&frequency);
		frequency = frequency * 1.6;
		channel->setFrequency(frequency);
		break;
	case MODE_KONGLING:
		//空灵
		system->createDSPByType(FMOD_DSP_TYPE_ECHO, &dsp);
		dsp->setParameterFloat(FMOD_DSP_ECHO_DELAY, 300);
		dsp->setParameterFloat(FMOD_DSP_ECHO_FEEDBACK, 20);
		system->playSound(sound, 0, false, &channel);
		channel->addDSP(0, dsp);
		break;
	}

	system->update();

	while (playing) {
		channel->isPlaying(&playing);
		usleep(1000 * 1000);
	}

	env->ReleaseStringUTFChars(jstr, path);

	sound->release();
	system->close();
	system->release();

}
