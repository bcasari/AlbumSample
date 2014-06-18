package com.sample.album.common;

import java.util.List;

import com.sample.album.common.enums.ItemType;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.sample.album.R;

public class ItemsGridView extends Fragment 
{
	private final static String TYPE_BUNDLE_KEY = "ItemType";
	private ItemsAdapter adapter;
	
	public static ItemsGridView newInstance(int position)
	{
		ItemsGridView itemsGridView = new ItemsGridView();
		
		//Set ItemType as argument 
		Bundle bundle = new Bundle();
		bundle.putSerializable(TYPE_BUNDLE_KEY, ItemType.toItemType(position));
		itemsGridView.setArguments(bundle);
		
		return itemsGridView;
	}
	
	/*
	 * Returns the item type the current list is displaying.
	 */
	private ItemType getListItemType()
	{
		Bundle bundleArguments;
		
		bundleArguments = getArguments();
		
		if(bundleArguments != null)
		{
			return (ItemType) bundleArguments.getSerializable(TYPE_BUNDLE_KEY);
		} else 
		{
			return ItemType.Album;//Default value
		}
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ItemType listItemType;
        List<Item> items;        
       
        listItemType = getListItemType();
        items = ItemsManager.getItems(listItemType);
       
        //Create adapter on onCreate()
        adapter = new ItemsAdapter(items, getActivity());
    }
	
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
       //Inflate Grid view
	   View v =  inflater.inflate(R.layout.fragment_main_grid_view, container, false);
       GridView lv = (GridView) v.findViewById(R.id.gridView);
       lv.setAdapter(adapter);
       return v;
    }
}
