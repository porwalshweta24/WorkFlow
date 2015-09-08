package com.advaiya.workflow;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.viewpagerindicator.CirclePageIndicator;

public class SampleCirclesDefault extends BaseSampleActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_circles);

        ArrayList<String> list=new ArrayList<String>();
		 
		 list.add("Closed Story");
		 list.add("Bugs/Impediments/");
		 list.add("Log Hours");
		 list.add("Closed Story");
		 list.add("Bugs/Impediments/");
		 list.add("Log Hours");
		 list.add("Bugs/Impediments/");
		 list.add("Log Hours");
        mAdapter = new TestFragmentAdapter(getSupportFragmentManager(),list);

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        mIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
    }
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {

		try{
			MenuInflater inflater = getMenuInflater();
			inflater.inflate(R.menu.main, menu);
		}
		catch(Exception e)
		{
		}
		return super.onCreateOptionsMenu(menu);
		//return true;
	}
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
		case R.id.share:
			Intent sharingIntent = new Intent(Intent.ACTION_SEND);
			sharingIntent.setType("text/html");
			sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml("https://play.google.com/store/apps/details?id=com.advaiya.scrumtool&hl=en"));
			startActivity(Intent.createChooser(sharingIntent,"Share using"));
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
		//return false;
	}
    
}
