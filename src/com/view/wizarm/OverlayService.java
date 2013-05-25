package com.view.wizarm;

/*
Copyright 2011 jawsware international

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

import com.view.wizarm.R;

import com.core.MainOverlayService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;

public class OverlayService extends MainOverlayService {

	public static OverlayService instance;

	private OverlayView overlayView;

	@Override
	public void onCreate() {
		super.onCreate();
		
		instance = this;
		
		overlayView = new OverlayView(this);
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

}
