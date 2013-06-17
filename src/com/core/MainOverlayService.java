package com.core;


import android.util.Log;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class MainOverlayService extends Service {

	protected boolean foreground = false;
	protected boolean cancelNotification = false;
	protected int id = 0;
	
	protected Notification foregroundNotification(int notificationId) {
		return null;
	}

	public void moveToForeground(int id, boolean cancelNotification) {
		moveToForeground(id, foregroundNotification(id), cancelNotification);
	}

	public void moveToForeground(int id, Notification notification, boolean cancelNotification) {
		if (! this.foreground && notification != null) {
			this.foreground = true;
			this.id = id;
			this.cancelNotification = cancelNotification;
					
			super.startForeground(id, notification);
		} else if (this.id != id && id > 0 && notification != null) {
			this.id = id;
			((NotificationManager) getSystemService(NOTIFICATION_SERVICE)).notify(id, notification);
		}
	}
	

	public void moveToBackground(int id, boolean cancelNotification) {
		foreground = false;
		id = 0;
		super.stopForeground(cancelNotification);
	}
	
	public void moveToBackground(int id) {
		moveToBackground(id, cancelNotification);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return START_STICKY;
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	
	public void launchSettings() {
		Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.settings");
		startActivity(LaunchIntent);
        }


	public void launchBrowser() {
		Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.browser");
		startActivity(LaunchIntent);
        }

}
