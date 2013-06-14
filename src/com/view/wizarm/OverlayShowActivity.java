package com.view.wizarm;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class OverlayShowActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Intent intent = new Intent();
		//intent.setClassName("com.android.settings", "com.android.settings");
		
		super.onCreate(savedInstanceState);
		
		startService(new Intent(this, OverlayService.class));
			
		finish();


//		startActivity(intent);
		
	}
    public void launchSettings() {
    	
		Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.settings");
		startActivity(LaunchIntent);

    }

	

    
}
