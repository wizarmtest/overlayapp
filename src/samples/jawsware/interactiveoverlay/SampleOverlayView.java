package samples.jawsware.interactiveoverlay;

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
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.View;


import com.jawsware.core.share.OverlayService;
import com.jawsware.core.share.OverlayView;

public class SampleOverlayView extends OverlayView implements OnClickListener {

	Button xbmc_button,video_button;
	private TextView info;
	private final static String tag = OverlayView.class.getSimpleName();
	
	public SampleOverlayView(OverlayService service) {
		super(service, R.layout.overlay, 1);
	}

	public int getGravity() {
		return Gravity.TOP + Gravity.RIGHT;
	}
	
	@Override
	protected void onInflateView() {
		info = (TextView) this.findViewById(R.id.fullscreen_content);
		xbmc_button = (Button) findViewById(R.id.xbmc_button);
		video_button = (Button) findViewById(R.id.video_button);
		
		xbmc_button.setVisibility(View.VISIBLE);
		video_button.setVisibility(View.VISIBLE);

		xbmc_button.setOnClickListener(this);
		video_button.setOnClickListener(this);
	}

	@Override
	protected void refreshViews() {
	//	info.setText("WAITING\nWAITING");

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
   		 switch (view.getId()) {
    			case R.id.xbmc_button:
     			 Log.d(tag, "onClick: starting srvice");
    			 break;
		    	case R.id.video_button:
     			 Log.d(tag, "onClick: stopping srvice");
   			 break;
			    }
	  }
	
	
}
