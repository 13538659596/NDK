package com.example.jnitest;

import java.io.File;

import android.os.Bundle;
import android.os.Environment;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView text;
	private int[] array = {1, 9, 2, 5, 10 , 3};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (TextView) findViewById(R.id.text);
		
		
		text.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				geti();
			}
			
			public void geti() {
				
			}
		});
		
		
		//text.setText(Jclass.getStringFromC());
		final Jclass j = new Jclass();
		text.setText(j.getIntFromC() + "");
		//new Jclass().getIntFromC();
		
		int[] arr = {1, 3,5,7,9};
		
		j.passArrayMethod(arr);
		
		final int[] arry = j.createArrayMethod(5);
		ValueAnimator animator = ValueAnimator.ofInt(0, 4);
		
		animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				// TODO Auto-generated method stub
				  Integer value = (Integer) animation.getAnimatedValue();
				  //Log.e("------->", "value " + value);
				  text.setText(arry[value] + "");
				  if(value == 4) {
					  text.setText(j.accessFile2());
						Log.e("----->", j.getKey());
				  }
			}
		});
		
		animator.setDuration(5000);
		animator.start();
		
		j.setCount();
		
		Log.e("----->", Jclass.getCount() + "  count");
		
		j.accessMethod();
		
		j.accessStaticMethod();
		printArray("排序前", array);
		j.sort(array);
		
		printArray("排序后", array);
		
		j.deleteLocalValue();
		
		Log.e("", "====================================");
		
		j.createGloablValue();
		Log.e("------>", j.getGloablValue());
		
		//j.deleteGloablValue();
		Log.e("-------->", "释放全局变量后");
		Log.e("", "====================================");
		//Log.e("------>", j.getGloablValue());
		

		try {
			j.exception();
		} catch (Throwable a) {
			// TODO Auto-generated catch block
			Log.e("-------->", "捕获到异常 " + a.getMessage());
			
			
		}
		
		
		
		File sdcardPath =  Environment.getExternalStorageDirectory();
		
		String filePath = sdcardPath.getAbsolutePath() + File.separator + "log.txt";
		String filePatten = sdcardPath.getAbsolutePath() + File.separator + "log_%d.txt";
		
		
		try {
			j.fileSplit(filePath, 10, filePatten);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.e("------->", "文件读写异常  " + e.getMessage());
		}
	}
	
	
	private void printArray(String tag, int[] arry) {
		for(int i = 0; i < arry.length; i++) {
			Log.e("------>", tag + "  == " + arry[i] + "");
		}
	}
	
	

}
