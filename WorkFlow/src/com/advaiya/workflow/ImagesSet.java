package com.advaiya.workflow;

import java.util.Timer;
import java.util.TimerTask;


import android.R.color;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

public class ImagesSet extends  Fragment{
	int position;	Timer timer;
	int page =0;
	public ImagesSet(int position) {
		// TODO Auto-generated constructor stub
		this.position=position;
	}

	ImageView switcherView ;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.activity_main, container, false);

		try{
			view.setBackgroundColor(getResources().getColor(color.white)); 

			switcherView = (ImageView) view.findViewById(R.id.img);
			Button b=(Button)view.findViewById(R.id.display_RGB);
			//			switcherView.setImageDrawable(switcherView.getDrawable());
			View decorView = getActivity().getWindow().getDecorView();
			decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
			pageSwitcher(1);//timer for scrolling


			switcherView.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					Intent i = new Intent(getActivity(), WebViewActivity.class);
					i.putExtra("id", position);
					startActivity(i);

					/*LayoutInflater inflater = (LayoutInflater) getActivity().
							getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					View popupView = inflater.inflate(R.layout.imagepopup, null);
					popupView.setBackgroundColor(Color.TRANSPARENT);
					final PopupWindow popupWindow = new PopupWindow(
							popupView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
					popupWindow.setFocusable(true);

					ImageView btnDismiss = (ImageView)popupView.findViewById(R.id.imgpopup);
					btnDismiss.setImageDrawable(switcherView.getDrawable());
					popupWindow.showAtLocation(btnDismiss,Gravity.CENTER, 0, 0);
					btnDismiss.setOnClickListener(new View.OnClickListener() {
						public void onClick(View v) {
							popupWindow.dismiss();

						}});
					 Intent i = new Intent(getActivity(), SingleViewActivity.class);
			            i.putExtra("id", position);
			            startActivity(i);*/
				}
			});

			// Hide the status bar.

		}catch(Exception  e){}
		return view;
	}

	public void pageSwitcher(int seconds) {
		try{
			timer = new Timer(); // At this line a new Thread will be created
			timer.scheduleAtFixedRate(new RemindTask(), 0, seconds * 1000); // delay
		}catch(Exception e){}
		// in// milliseconds
	}

	public class RemindTask extends TimerTask {
		@Override
		public void run() {
			while( (getActivity() != null))
			{try {
				Thread.sleep(1000);
				getActivity().runOnUiThread(new Runnable() {

					@Override
					public void run() {
						if (page > 10) {
							page=1;
							timer.cancel();
						} 
						else
						{
							switch(position)
							{
							case 0:		  switcherView.setImageResource(R.drawable.pic1 );
							//		view.setBackgroundColor(getResources().getColor(color.white)); 

							break;
							case 1:		  switcherView.setImageResource(R.drawable.pic2);
							//		view.setBackgroundColor(getResources().getColor(color.black)); 

							break;			
							case 2:		  switcherView.setImageResource(R.drawable.pic3);
							//		view.setBackgroundColor(getResources().getColor(color.darkgray)); 

							break;	
							case 3:		  switcherView.setImageResource(R.drawable.pic4 );
							//		view.setBackgroundColor(getResources().getColor(color.gray)); 

							break;
							case 4:		  switcherView.setImageResource(R.drawable.cloud);
							//		view.setBackgroundColor(getResources().getColor(color.red)); 

							break;
							case 5:		  switcherView.setImageResource(R.drawable.deliverable);
							//		view.setBackgroundColor(getResources().getColor(color.ablue)); 

							break;
							case 6:		  switcherView.setImageResource(R.drawable.scrum);
							//		view.setBackgroundColor(getResources().getColor(color.childs)); 

							break;
							default:  	  switcherView.setImageResource(R.drawable.group);
							//		view.setBackgroundColor(getResources().getColor(color.darkslate)); 

							break;
							}
						}
						page++;

					}
				});
			}catch (InterruptedException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();

			}

			}
		}
	}
}

