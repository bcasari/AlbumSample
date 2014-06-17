package com.sample.album.common;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ItemsList extends ListFragment {

	//The item type
	public enum ItemType {
		Album,
		Song,
		Artist;

	    public static ItemType toItemType(int position)
	    {
	    	ItemType itemType;
	    	
	    	switch(position)
	    	{
		    	case 0:
		    		itemType = ItemType.Album;
		    		break;
		    	case 1:
		    		itemType = ItemType.Song;
		    		break;
		    	case 2:
		    	default:
		    		itemType = ItemType.Artist;
		    		break;
	    	}
	    	
	    	return itemType;
	    }

	};
	
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
        String mainHeaderTitle;
        
        listItemType = getListItemType();
        mainHeaderTitle = listItemType.toString() + " ";        
        
        // Generate a list of 1000 dummy items
        ArrayList<Item> dummies = new ArrayList<Item>();
        for (int i = 0; i < 1000; i++){
            Item item = new Item();
            item.setMainHeader(mainHeaderTitle + i);
            item.setSecondaryHeader("Gender " + i);
            item.setImageUrl("http://www.brunocasari.net/Frontend/Images/Developer.jpg");
            dummies.add(item);
        }

        ItemsAdapter adapter = new ItemsAdapter(dummies, getActivity());
        setListAdapter(adapter);
    }
}
