package com.example.planets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {
    //using custom Layouts --> MyCustomAdapter
    //using custom objects --> extends ArrayAdapter <Planet>
    private ArrayList<Planet> planetsArrayList;
    Context context;

    public MyCustomAdapter( ArrayList<Planet> planetsArrayList, Context context) {
        super(context, R.layout.item_list,planetsArrayList);
        this.planetsArrayList = planetsArrayList;
        this.context = context;
    }
    //Viewholder class-->used to catch the refrence to the views within
    // an item layout , so that they dont need to be repeatedly
    //looked up during scrolling.
    private static class MyViewHolder{
        TextView planetName;
        TextView moonCount;
        ImageView planetImg;
    }
    //getView():-->is used to create and return a view for
    //             specific items in the list.

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //1->Get the planet object for the current position
        Planet planet=getItem(position);
        //2-> Inflate layout
        MyViewHolder myViewHolder;
        final View result;
        if(convertView==null){
            myViewHolder=new MyViewHolder();
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(
                    R.layout.item_list,
                    parent,false
            );
            //Finding the views
            myViewHolder.planetName=(TextView) convertView.findViewById(R.id.planet_name);
            myViewHolder.moonCount=(TextView) convertView.findViewById(R.id.moon);
            myViewHolder.planetImg=(ImageView) convertView.findViewById(R.id.imageView);
            result =convertView;
            convertView.setTag(myViewHolder);
        }else{
            //the view is recycled
            myViewHolder=(MyViewHolder) convertView.getTag();
            result=convertView;
        }
        //getting the data from model class (Planet)
        myViewHolder.planetName.setText(planet.getPlanetName());
        myViewHolder.moonCount.setText(planet.getMoonCount());
        myViewHolder.planetImg.setImageResource(planet.getPlanetImage());
        return result;
    }
}
