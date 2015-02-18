package com.laura.multimedia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;

public class CrearTabsSwipe extends ActionBarActivity implements ActionBar.TabListener, OnPageChangeListener {

	private ViewPager mViewPager;;
	
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);
		
		PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(adapter);
        
        mViewPager.setOnPageChangeListener(this);
        
        ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle("Multimedia");
		//actionBar.setSubtitle("Crear tabs swipe");
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		Tab tab = actionBar.newTab().setText(R.string.audio1).setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab().setText(R.string.audio2).setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab().setText(R.string.video).setTabListener(this);
		actionBar.addTab(tab);
		
		tab = actionBar.newTab().setText(R.string.imagenes).setTabListener(this);
		actionBar.addTab(tab);
		
	}
	
	
	
	
	
	
	
	public class PagerAdapter extends FragmentPagerAdapter {

		public PagerAdapter(FragmentManager fm) {
			super(fm);
		}

		public Fragment getItem(int arg0) {
			switch (arg0) {
	            case 0:
	                return new Fragment_Audio_soundP();
	            case 1:
	                return new Fragment_audio_mediaPlayer();
	            case 2:
	                return new Fragment_video();
	            case 3:
	                return new Fragment_imagenes();
	            default:
	            	return null;
			}
		}

		public int getCount() {
			return 4;//cantidad de pesta�as
		}

    }






	/** INTERFACE ONPAGECHANGELISTENER **/
	
	public void onPageSelected(int arg0) {
		getSupportActionBar().setSelectedNavigationItem(arg0);
	}
	
	public void onPageScrollStateChanged(int arg0) {
		
	}
	
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		
	}
	
	
	
	
	
	/** INTERFACE ACTIONBAR.TABLISTENER **/
	
	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
		mViewPager.setCurrentItem(arg0.getPosition());
	}
	
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		
	}
	
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		
	}
	
	
	
	
	
}