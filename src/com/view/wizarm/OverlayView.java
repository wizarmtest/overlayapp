package com.view.wizarm;


import com.view.wizarm.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.View;


import com.core.MainOverlayService;
import com.core.MainOverlayView;

public class OverlayView extends MainOverlayView  implements OnClickListener {

	Button watch_button,xbmc_button,scalevideo_button;
	public static SettingActivity instance;

	private final static String tag = MainOverlayView.class.getSimpleName();
	
	public OverlayView(MainOverlayService service) {
		super(service, R.layout.overlay, 1);
	}

	public int getGravity() {
		return Gravity.TOP + Gravity.RIGHT;
	}
	
	@Override
	protected void onInflateView() {
		
		/* Full screen watch video */
		watch_button = (Button) findViewById(R.id.watch_button);
		watch_button.setVisibility(View.VISIBLE);
		watch_button.setOnClickListener(this);

		
		
	//	xbmc_button = (Button) findViewById(R.id.xbmc_button);
		scalevideo_button = (Button) findViewById(R.id.scalevideo_button);
		//xbmc_button.setVisibility(View.VISIBLE);
		scalevideo_button.setVisibility(View.VISIBLE);

		//xbmc_button.setOnClickListener(this);
		scalevideo_button.setOnClickListener(this);
		
		Drawable balpha = scalevideo_button.getBackground();
		balpha.setAlpha(255);
		scalevideo_button.setBackgroundDrawable(balpha);
		
		//Drawable talpha = info.getBackground();
		//talpha.setAlpha(255);
		//info.setBackgroundDrawable(talpha);
		
	}

	@Override
	protected void refreshViews() {


	Log.d(tag, "_FDK_ RefreshView");
	}

	@Override
	protected void onTouchEvent_Up(MotionEvent event) {
	//	info.setText("UP\nPOINTERS: " + event.getPointerCount());

	Log.d(tag, "_FDK_ onTouchEventUP");
	}

	@Override
	protected void onTouchEvent_Move(MotionEvent event) {


	Log.d(tag, "_FDK_ onTouchEvent_Move");
	//	info.setText("MOVE\nPOINTERS: " + event.getPointerCount());
	}

	@Override
	protected void onTouchEvent_Press(MotionEvent event) {

	Log.d(tag, "_FDK_ onTouchEvent_Press");
	//	info.setText("DOWN\nPOINTERS: " + event.getPointerCount());
	}

	@Override
	public boolean onTouchEvent_LongPress() {
//		info.setText("LONG\nPRESS");

	Log.d(tag, "_FDK_ onTouchEvent_LongPress");
		return true;
	}


	public void onClick(View view) {
		//Intent intent = new Intent();
		//intent.setClassName("com.android.settings", "com.android.settings");
		//Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.settings");
		
   		 switch (view.getId()) {
    			case R.id.watch_button:
     			 Log.d(tag, "onClick: starting srvice *******************************8'");
//     			 xbmc_button.setVisibility(View.GONE); make total view.GONE
     			 super.setVisibility(View.GONE);
     			 super.launchSettings();

     			//instance = new SettingActivity();
     			//instance.launchSettings();
    
     			
     	//		startActivity(intent);
    		//	startActivity(new Intent(Settings.ACTION_SETTINGS));
     			 
     			 
    			 break;
		    	case R.id.scalevideo_button:

		    	
     			 Log.d(tag, "onClick: stopping srvice");
   			 break;
			    }
	  }


	
	
}
