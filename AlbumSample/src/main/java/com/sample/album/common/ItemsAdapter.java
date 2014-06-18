package com.sample.album.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fedorvlasov.lazylist.ImageLoader;
import com.sample.album.R;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends BaseAdapter {
    private List<Item> items;
    private Context mContext;
    private LayoutInflater layoutInflater;
    private ImageLoader imageLoader;

    public ItemsAdapter(List<Item> items, Context mContext) {
        this.items = items;
        this.mContext = mContext;
        this.layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.imageLoader=new ImageLoader(mContext.getApplicationContext());
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Item item;
        ViewHolder viewHolder;
    	
        item =  (Item) getItem(i);
        
    	//If Android is not recyclying a previously created View, create a new one
    	if(view == null)
    	{
            view = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
            
            viewHolder = new ViewHolder((TextView)view.findViewById(R.id.main_header), 
        								(TextView) view.findViewById(R.id.secondary_header),
        								(ImageView) view.findViewById(R.id.icon));
            
            view.setTag(viewHolder);
            
    	} else //Previously created view
    	{
    		//Get Viewholder from previously created view
    		viewHolder = (ViewHolder) view.getTag(); 
    	}

    	viewHolder.getMainHeaderTextView().setText(item.getMainHeader());
        viewHolder.getSecondaryHeaderTextView().setText(item.getSecondaryHeader());
        
        imageLoader.DisplayImage(item.getImageUrl(), viewHolder.getIcon());

        return view; 
    }
    
    /*
     * A class that will hold the ListItem Views
     */
    public class ViewHolder
    {
    	private TextView mainHeader;
    	private TextView secondaryHeader;
    	private ImageView icon;
    	
    	public ViewHolder(TextView mainHeader, TextView secondaryHeader, ImageView icon)
    	{
    		this.mainHeader = mainHeader;
    		this.secondaryHeader = secondaryHeader;
    		this.icon = icon;
    	}
    	
    	/*
    	 * Returns the main header text view
    	 */
    	public TextView getMainHeaderTextView()
    	{
    		return mainHeader;
    	}
    	
    	/*
    	 * Returns the secondary header text view
    	 */
    	public TextView getSecondaryHeaderTextView()
    	{
    		return secondaryHeader;
    	}
    	
    	/*
    	 * Returns the icon ImageView
    	 */
    	public ImageView getIcon()
    	{
    		return icon;
    	}
    }
}


