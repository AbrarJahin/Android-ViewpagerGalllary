package com.app_gallery.viewpagergalllary;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter
{
    // Declare Variables
    private Context                     context;
    private ArrayList<Model_Country>    data_list_to_show;
    private LayoutInflater              inflater;

    public ViewPagerAdapter(Context context, ArrayList<Model_Country> data_list)
    {
        this.context = context;
        this.data_list_to_show= (ArrayList<Model_Country>) data_list.clone();           //storing value list to this class from activity class
    }

    @Override
    public int getCount()
    {
        return data_list_to_show.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object)
    {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)        //each item view creation from data
    {
        //Log.e(data_list_to_show.get(position).get_country(), position+" "+data_list_to_show.get(position).get_population());     //Debugging
        // Declare Variables
        TextView    tv_rank;
        TextView    tv_country_name;
        TextView    tv_population;
        ImageView   iv_flag;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.viewpager_item, container,false);

        // Locate the items in viewpager_item.xml
        tv_rank = (TextView) itemView.findViewById(R.id.rank);
        tv_country_name = (TextView) itemView.findViewById(R.id.country);
        tv_population = (TextView) itemView.findViewById(R.id.population);
        iv_flag = (ImageView) itemView.findViewById(R.id.flag);

        // Capture position and set to the values of the views
        tv_rank.setText(String.valueOf(data_list_to_show.get(position).get_rank()));            //setting int to text value - so convertion needed
        tv_country_name.setText(    data_list_to_show.get(position).get_country());
        tv_population.setText(      data_list_to_show.get(position).get_population());
        iv_flag.setImageResource(   data_list_to_show.get(position).get_flag());

        // Add viewpager_item.xml to ViewPager
        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}