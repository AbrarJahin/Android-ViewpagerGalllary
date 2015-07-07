package com.app_gallery.viewpagergalllary;


public class Model_Country
{
    private int     rank;
    private String  country;
    private String  population;
    private int     flag;

    public int   get_rank()
    {
        return rank;
    }

    public String   get_country()
    {
        return country;
    }

    public String   get_population()
    {
        return population;
    }

    public int      get_flag()
    {
        return flag;
    }

    public void set_rank(int to_save)
    {
        rank=to_save;
    }

    public void set_country(String to_save)
    {
        country=to_save;
    }

    public void set_population(String to_save)
    {
        population=to_save;
    }

    public void set_flag(int to_save)
    {
        flag=to_save;
    }
}
