package com.view.wizarm;


import java.lang.reflect.Method;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class OverlayShowActivity extends Activity {

	
	
private BroadcastReceiver myReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
   //     Toast.makeText(getApplicationContext(), "received", Toast.LENGTH_SHORT);
    }
};

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Intent intent = new Intent();
		//intent.setClassName("com.android.settings", "com.android.settings");
		// disable keyguard .
		//getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
		
		

		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);  
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		
    //    Object service  = getSystemService("statusbar");
      //  Class<?> statusbarManager = Class.forName("android.app.StatusBarManager");
       // Method collapse = statusbarManager.getMethod("collapse");
       // collapse.setAccessible(true);
       // collapse.invoke(service);
        
	    View main_layout =findViewById(android.R.id.content).getRootView();
	    main_layout.setSystemUiVisibility(View.STATUS_BAR_HIDDEN);
   //     View v = findViewById(R.id.view_id);
    //    v.setSystemUiVisibility(View.STATUS_BAR_HIDDEN);
	//	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LOW_PROFILE);

		startService(new Intent(this, OverlayService.class));
			
	//	finish();


// For Broadcast receive activity

		IntentFilter intentFilter = new IntentFilter("view.wizarm.android.mybroadcast");
		registerReceiver( myReceiver , intentFilter);


}




//		startActivity(intent);
		

	

/*	
	   private BroadcastReceiver myReceiver = new BroadcastReceiver() {

		    public void onReceive(Context context, Intent intent) {
		        // TODO Auto-generated method stub
		         Bundle extras = intent.getExtras();
		       if (extras != null){  
		       {
		                rec_data = extras.getString("send_data");
		        Log.d("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOiiiiiiiiiiiiReceived Msg : ",rec_data);
		        }
		    }
		}
*/
	
    public void launchSettings() {
    	
		Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.settings");
		startActivityForResult(LaunchIntent, 100);

    }

	public void onActivityResult(int requestCode, int resultCode, Intent data) {     
		  super.onActivityResult(requestCode, resultCode, data); 
		  switch(requestCode) { 
		    case (100) : { 
	     		Log.w("HELLOO", "onClick: Exit Suncess*******************************");
		      if (resultCode == Activity.RESULT_OK) { 

		      } 
		      break; 
		    } 
		  } 
		}
	

    
}
