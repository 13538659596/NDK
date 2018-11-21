package com.example.jnitest;

import java.util.Random;
import java.util.UUID;

import android.util.Log;



public class Jclass {
	
	private String key = "student";
	
	private static int count = 9;
	public static native String getStringFromC();
	public native int getIntFromC();
	
	 //��������,������,����
    public native void passArrayMethod(int[] arr);

    //����ָ����������
    public native int[] createArrayMethod(int len);
    
    public static native String accessFile(); 
    
    public  native String accessFile2(); 
    
    public  native void accessMethod(); 
    public  native void accessStaticMethod(); 
    
    public native void sort(int[] arry);
    
    public native void setCount();
    
    public native void deleteLocalValue();
	
    //jniȫ�ֱ����Ĵ������ͷ�
    public native void createGloablValue();
    
    public native String getGloablValue();
    
    public native String deleteGloablValue();
    
    //jni�쳣����
    public native void exception();
    
    //�ļ����
    public native void fileMerge();
    
    /**
     * �ļ��ϲ�
     * @param path    ��Ҫ��ֵ��ļ�·��
     * @param count	     �ļ���Ҫ��ֳɶ��ٷ�
     * @param patten  �������ļ��Ĺ���
     */
    public native void fileSplit(String path, int count, String patten);
    
	
	public String getKey() {
		return key;
	}
	
	public static int getCount() {
		return count;
	}
	
	public int getRandomInt(int max){
		Log.e("----->", "�����������");
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


