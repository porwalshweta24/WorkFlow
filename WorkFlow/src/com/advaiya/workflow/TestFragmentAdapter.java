package com.advaiya.workflow;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.viewpagerindicator.IconPagerAdapter;

class TestFragmentAdapter extends FragmentPagerAdapter   {
    

    ArrayList<String>pagetitleArrayList;

    public TestFragmentAdapter(FragmentManager fm, ArrayList<String>pagetitle) {
		// TODO Auto-generated constructor stub
		super(fm);
		 pagetitleArrayList = pagetitle;
		
	}

    @Override
    public Fragment getItem(int position) {
    	switch (position) {
		case 0:
			return new ImagesSet(position);
		
		
		default:
			return new ImagesSet(position);
			
		}
    }

    @Override
    public int getCount() {
		return pagetitleArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
    	return 	 pagetitleArrayList.get(position);
    }
	

  

}