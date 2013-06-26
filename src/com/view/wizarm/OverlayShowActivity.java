package com.view.wizarm;


import java.lang.reflect.Method;
import java.lang.Object;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class OverlayShowActivity extends Activity {
	
	String rec_data;
	
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // Close the menu
        if (Intent.ACTION_MAIN.equals(intent.getAction())) {
            getWindow().closeAllPanels();
        }
    }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Log.w("com.view.wizarm", "ONCREATE Overlay show activity");

		
		// disable keyguard .
	//	getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
		
	//	KeyguardManager  myKeyGuard = (KeyguardManager)getSystemService(Context.KEYGUARD_SERVICE);
	//	KeyguardLock lock = myKeyGuard.newKeyguardLock(KEYGUARD_SERVICE);
		//lock.disableKeyguard();
		

		
		// Make window full screen
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);  
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);    
	    View main_layout =findViewById(android.R.id.content).getRootView();
	    main_layout.setSystemUiVisibility(View.STATUS_BAR_HIDDEN);
	    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LOW_PROFILE);
   
	    // start overlay service
		startService(new Intent(this, OverlayService.class));
	
		// Register broadcast receiver
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("view.wizarm.android.mybroadcast");
		registerReceiver( myReceiver , intentFilter);
}


	private BroadcastReceiver myReceiver = new BroadcastReceiver() {
	    @Override
	    public void onReceive(Context context, Intent intent) {
	    	int activity_number;
	  //  	Toast.makeText(getApplicationContext(), "%%%%%%%%%%%%received", Toast.LENGTH_SHORT).show();

	    	//Bundle extras = intent.getExtras();

	//	   if (extras != null){  
	    		intent.getAction().equals("view.wizarm.android.mybroadcast");
	    		
	    		activity_number=intent.getIntExtra("activity_number", 0);
	    		
	    		switch (activity_number){
	    		case 100:
	    		launchSettings();
	    		}
		 //   	rec_data = extras.getString("send_data");
		    //    Log.d("com.view.wizarm Received Msg : ",rec_data);
		      //  Log.d("com.view.wizarm Received Msg : ",rec_data);		        
		       // Log.d(" com.view.wizarm Received Msg : ",rec_data);		        
		       // Log.d("com.view.wizarm Received Msg : ",rec_data);		       
		       // Log.d("com.view.wizarm Received Msg : ",rec_data);
		        
		       
		        
		  //      launchSettings();
		  //      }
		  //  }

	    }
	};
	
	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {     
		  super.onActivityResult(requestCode, resultCode, data); 
		  switch(requestCode) { 
		    case (100) : { 
	     		Log.w("com.view.wizarm", "onClick: Exit Suncess*******************************");
		      if (resultCode == Activity.RESULT_OK) { 

		      } 
		      break; 
		    } 
		  } 
		}



    public void launchSettings() {
    	
		Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.settings");
		startActivityForResult(LaunchIntent, 100);

    }

	public void launchBrowser() {
		Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.browser");
		startActivityForResult(LaunchIntent, 101);
        }
	

    
}
