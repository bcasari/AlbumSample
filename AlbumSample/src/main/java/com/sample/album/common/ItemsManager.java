package com.sample.album.common;

import java.util.ArrayList;
import java.util.List;

import com.sample.album.common.enums.ItemType;

public final class ItemsManager 
{		
	/*
	 * Returns the dummy items depending on type required
	 */
	public static List<Item> getItems(ItemType listItemType)
	{
        ArrayList<Item> items;			
        String mainHeaderTitle;
        
        items = new ArrayList<Item>();	        
        mainHeaderTitle = listItemType.toString() + " ";        
        
        // Generate a list of 1000 dummy items

        for (int i = 0; i < 1000; i++){
            Item item = new Item();
            item.setMainHeader(mainHeaderTitle + i);
            item.setSecondaryHeader("Gender " + i);
            item.setImageUrl("http://www.brunocasari.net/Frontend/Images/Developer.jpg");//Dummy image
            items.add(item);
        }
        
        return items;
	}
}
