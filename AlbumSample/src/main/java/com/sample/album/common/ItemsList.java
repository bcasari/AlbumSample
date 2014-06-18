package com.sample.album.common;

import android.app.ListFragment;
import android.os.Bundle;
import com.sample.album.common.ItemsManager;
import com.sample.album.common.enums.ItemType;

import java.util.List;

public class ItemsList extends ListFragment {	
	
	private final static String TYPE_BUNDLE_KEY = "ItemType";
	
	public static ItemsList newInstance(int position)
	{
		ItemsList itemsList = new ItemsList();
		
		//Set ItemType as argument 
		Bundle bundle = new Bundle();
		bundle.putSerializable(TYPE_BUNDLE_KEY, ItemType.toItemType(position));
		itemsList.setArguments(bundle);
		
		return itemsList;
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
			return ItemType.Album;
		}
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ItemType listItemType;
        List<Item> items;
        
        listItemType = getListItemType();
        items = ItemsManager.getItems(listItemType);
        
        ItemsAdapter adapter = new ItemsAdapter(items, getActivity());
        setListAdapter(adapter);
    }
}
