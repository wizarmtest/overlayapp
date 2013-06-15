package com.view.wizarm;


import com.core.MainOverlayView;


import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class SettingActivity extends Service {

	
	private final static String tag = SettingActivity.class.getSimpleName();
	public void launchSettings() {
    	Context Context=this;    	
    	ActivityManager am = (ActivityManager)Context.getSystemService(Context.ACTIVITY_SERVICE);
    	
		Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.settings");
		startActivity(LaunchIntent);
    }

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
    
}
