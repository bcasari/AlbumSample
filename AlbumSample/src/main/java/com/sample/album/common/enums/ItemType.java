package com.sample.album.common.enums;

//The item type enum
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