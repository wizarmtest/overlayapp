package com.view.wizarm;


import com.core.MainOverlayView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


public class SettingActivity extends Activity {
	
	private final static String tag = SettingActivity.class.getSimpleName();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(tag, " Setting activity onCreate *******************************8'");
	//	Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.settings");
//		startActivity(LaunchIntent);
		finish();
	}
    
}
