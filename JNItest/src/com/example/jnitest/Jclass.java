package com.example.jnitest;

import java.util.Random;
import java.util.UUID;

import android.util.Log;



public class Jclass {
	
	private String key = "student";
	
	private static int count = 9;
	public static native String getStringFromC();
	public native int getIntFromC();
	
	 //传递数组,操作后,返回
    public native void passArrayMethod(int[] arr);

    //创建指定长度数组
    public native int[] createArrayMethod(int len);
    
    public static native String accessFile(); 
    
    public  native String accessFile2(); 
    
    public  native void accessMethod(); 
    public  native void accessStaticMethod(); 
    
    public native void sort(int[] arry);
    
    public native void setCount();
    
    public native void deleteLocalValue();
	
    //jni全局变量的创建与释放
    public native void createGloablValue();
    
    public native String getGloablValue();
    
    public native String deleteGloablValue();
    
    //jni异常处理
    public native void exception();
    
    //文件拆分
    public native void fileMerge();
    
    /**
     * 文件合并
     * @param path    需要拆分的文件路径
     * @param count	     文件需要拆分成多少份
     * @param patten  生成子文件的规则
     */
    public native void fileSplit(String path, int count, String patten);
    
	
	public String getKey() {
		return key;
	}
	
	public static int getCount() {
		return count;
	}
	
	public int getRandomInt(int max){
		Log.e("----->", "产生了随机数");
		return new Random().nextInt(max);
	}
	
	public static String getUUID(){
		String uuid = UUID.randomUUID().toString();
		Log.e("Test_Jni", "java     " + uuid);
		return uuid;
	}
	
	
	
	
	static {
		 System.loadLibrary("test");
	}
}


