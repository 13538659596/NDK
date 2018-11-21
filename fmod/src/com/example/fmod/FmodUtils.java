package com.example.fmod;

public class FmodUtils {
	//音效的类型
	public static final int MODE_NORMAL = 0;
	public static final int MODE_LUOLI = 1;
	public static final int MODE_DASHU = 2;
	public static final int MODE_JINGSONG = 3;
	public static final int MODE_GAOGUAI = 4;
	public static final int MODE_KONGLING = 5;
	
	
	public native void playsound(String filePath, int sound_mode);
	
	static {
	
    		System.loadLibrary("fmodL");
			System.loadLibrary("fmod");
			System.loadLibrary("voice");
	}
}
