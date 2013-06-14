package com.view.wizarm;



import android.app.Activity;
import android.os.Bundle;

public class OverlayHideActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		OverlayService.stop();
			
		finish();
		
	}
    
}
