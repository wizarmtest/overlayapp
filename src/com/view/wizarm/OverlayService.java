package com.view.wizarm;


import com.view.wizarm.R;

import com.core.MainOverlayService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

public class OverlayService extends MainOverlayService {

	public static OverlayShowActivity parent;
	public static OverlayShowActivity startActivity;
	public static OverlayService instance;
	
	// Broadcast 
	Intent BroadcastIntent;
	Bundle extras;
	

	private OverlayView overlayView;

	@Override
	public void onCreate() {
		super.onCreate();
		instance=this;
	//	parent=getActivity();
		
		overlayView = new OverlayView(this);
		

		BroadcastIntent = new Intent();
		BroadcastIntent.setAction("view.wizarm.android.mybroadcast");
	//	sendBroadcast(intent);	 

	}

	
	@Override
	public void onDestroy() {
		super.onDestroy();

		if (overlayView != null) {
			overlayView.destory();
		}

	}
	
	static public void stop() {
		if (instance != null) {
			instance.stopSelf();
		}
	}
	
	@Override
	protected Notification foregroundNotification(int notificationId) {
		Notification notification;

		notification = new Notification(R.drawable.ic_launcher, getString(R.string.title_notification), System.currentTimeMillis());

		notification.flags = notification.flags | Notification.FLAG_ONGOING_EVENT | Notification.FLAG_ONLY_ALERT_ONCE;

		notification.setLatestEventInfo(this, getString(R.string.title_notification), getString(R.string.message_notification), notificationIntent());

		return notification;
	}


	private PendingIntent notificationIntent() {
		Intent intent = new Intent(this, OverlayHideActivity.class);

		PendingIntent pending = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

		return pending;
	}

	
	public void launchOverlaySetting() {
		extras.putString("send_data", "Setting");
		BroadcastIntent.putExtras(extras);  
		sendBroadcast(BroadcastIntent);
    	//startActivity(new Intent(this, QuickPrefsActivity.class));
        }
}
