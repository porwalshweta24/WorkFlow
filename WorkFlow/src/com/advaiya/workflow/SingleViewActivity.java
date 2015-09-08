package com.advaiya.workflow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class SingleViewActivity extends Activity {
	   @Override
	   public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.imagepopup);
	      
	      // Get intent data
	      Intent i = getIntent();
	      
	      // Selected image id
	      int position = i.getExtras().getInt("id");
	      ImageAdapter imageAdapter = new ImageAdapter(getApplicationContext());
	      
	      ImageView imageView = (ImageView) findViewById(R.id.imgpopup);
	      imageView.setImageResource(imageAdapter.mThumbIds[position]);
	   }
	}