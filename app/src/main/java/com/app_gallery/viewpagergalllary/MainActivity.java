package com.app_gallery.viewpagergalllary;


import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import java.util.ArrayList;

public class MainActivity extends Activity
{
    // Declare Variables
    ArrayList <Model_Country> data_to_show = new ArrayList<Model_Country>();
    ViewPager viewPager;
    PagerAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Get the view from viewpager_main.xml
        setContentView(R.layout.activity_main);

        Store_Data();          //getting and storing the data

        // Locate the ViewPager in viewpager_main.xml
        viewPager = (ViewPager) findViewById(R.id.pager);
        // Pass results to ViewPagerAdapter Class
        adapter = new ViewPagerAdapter(MainActivity.this, data_to_show);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);
    }

    private void Store_Data()                   //Stroing data in data to show list of used Model
    {
        ////////////////////////////////////////////////////// storing 10 random data- this should come from any database
        String[] rank;
        String[] country;
        String[] population;
        int[] flag;
                // Generate sample data
        rank = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

        country = new String[] { "China", "India", "United States",
                "Indonesia", "Brazil", "Pakistan", "Nigeria", "Bangladesh",
                "Russia", "Japan" };

        population = new String[] { "1,354,040,000", "1,210,193,422",
                "315,761,000", "237,641,326", "193,946,886", "182,912,000",
                "170,901,000", "152,518,015", "143,369,806", "127,360,000" };

        flag = new int[] { R.drawable.china, R.drawable.india,
                R.drawable.unitedstates, R.drawable.indonesia,
                R.drawable.brazil, R.drawable.pakistan, R.drawable.nigeria,
                R.drawable.bangladesh, R.drawable.russia, R.drawable.japan };
        //////////////////////////////////////////////////////

        //ArrayList<Model_Country>    temp_data = new ArrayList<Model_Country>();

        for (int i=0;i<10;i++)      //randomly store 10 data
        {
            Model_Country       temp_single_data = new Model_Country();         //creating temp storage for each value

            //Getting those values
            temp_single_data.set_rank(rank[i]);
            temp_single_data.set_country(country[i]);
            temp_single_data.set_population(population[i]);
            temp_single_data.set_flag(flag[i]);

            data_to_show.add(temp_single_data);                                    //Storing the data in temp array list
        }
        //data_to_show= (ArrayList<Model_Country>)temp_data.clone();
    }
}