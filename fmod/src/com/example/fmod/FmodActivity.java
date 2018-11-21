package com.example.fmod;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class FmodActivity extends Activity implements OnClickListener{

	private String path = "file:///android_asset/a.mp3";
	private FmodUtils fmod;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		org.fmod.FMOD.init(this);
		fmod = new FmodUtils();
		findViewById(R.id.button1).setOnClickListener(this);
		findViewById(R.id.button2).setOnClickListener(this);
		findViewById(R.id.button3).setOnClickListener(this);
		
		findViewById(R.id.button4).setOnClickListener(this);
		findViewById(R.id.button5).setOnClickListener(this);
		findViewById(R.id.button6).setOnClickListener(this);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		org.fmod.FMOD.close();
	}
	
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.button1:
			fmod.playsound(path, FmodUtils.MODE_NORMAL);
			break;

		case R.id.button2:
			fmod.playsound(path, FmodUtils.MODE_LUOLI);
			break;
		case R.id.button3:
			fmod.playsound(path, FmodUtils.MODE_DASHU);
			break;
		case R.id.button4:
			fmod.playsound(path, FmodUtils.MODE_JINGSONG);
			break;
		case R.id.button5:
			fmod.playsound(path, FmodUtils.MODE_GAOGUAI);
			break;
		case R.id.button6:
			fmod.playsound(path, FmodUtils.MODE_KONGLING);
			break;
		}
	}
}
