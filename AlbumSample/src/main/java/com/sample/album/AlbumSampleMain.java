package com.sample.album;

import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sample.album.common.ItemsGridView;
import com.sample.album.common.ItemsList;


public class AlbumSampleMain extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_sample_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
    	Configuration config;
        FragmentManager fragmentManager;
        Fragment fragmentToReplace;
        
        fragmentManager = getFragmentManager();
        config = getResources().getConfiguration();
        
        //If there is at least 820dp available display the table version (gridview). If not display listview.
        //In a tablet if space available is less than 820dp (portrait for example), the ListView will be displayed.
        if(config.screenWidthDp >= 820)
        {
        	fragmentToReplace = ItemsGridView.newInstance(position);
        } else 
        {
        	fragmentToReplace = ItemsList.newInstance(position);
        }
        
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragmentToReplace)
                .commit();
    }
}
