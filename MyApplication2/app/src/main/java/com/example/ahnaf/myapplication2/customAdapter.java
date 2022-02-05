package com.example.ahnaf.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ahnaf on 1/22/2019.
 */
public class customAdapter extends BaseAdapter {

    ArrayList<Houseiteam> houseiteams=new ArrayList<>();
    Context ct;
    private  static LayoutInflater inflater = null ;
    //constructr
    public customAdapter(knapsackoutput knapsackout,ArrayList<Houseiteam> houseItems){
        houseiteams=houseItems;
        ct=knapsackout ;
        inflater =(LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return houseiteams.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public  class Myholder{
        TextView id2,phone2,area2,roadno2,housename2,houseno2,floor2,flat2,bedroom2,washroom2,rent2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Myholder myh = new Myholder();
        View myview;

        myview = inflater.inflate(R.layout.custom_layout,null);


        myh.id2 = (TextView) myview.findViewById(R.id.ownerid1);
        myh.area2 = (TextView)  myview.findViewById(R.id.atext);
        myh.phone2 = (TextView)  myview.findViewById(R.id.ptext);
        myh.roadno2 = (TextView)  myview.findViewById(R.id.roadid1);
        myh.housename2 = (TextView)  myview.findViewById(R.id.hntext);
        myh.houseno2 = (TextView)  myview.findViewById(R.id.hnotext);
        myh.floor2 = (TextView)  myview.findViewById(R.id.ftext);
        myh.flat2 = (TextView)  myview.findViewById(R.id.fnotext);
        myh.bedroom2 = (TextView)  myview.findViewById(R.id.btext);
        myh.washroom2 = (TextView)  myview.findViewById(R.id.wtext);
        myh.rent2 = (TextView)  myview.findViewById(R.id.rtext);


        myh.id2.setText(houseiteams.get(position).getId());
        myh.phone2.setText(houseiteams.get(position).getPhone()) ;
        myh.area2.setText(houseiteams.get(position).getArea()) ;
        myh.roadno2.setText(houseiteams.get(position).getRoadno());
        myh.housename2.setText(houseiteams.get(position).getHousename()) ;
        myh.houseno2.setText(houseiteams.get(position).getHouseno()) ;
        myh.floor2.setText(houseiteams.get(position).getFloor()) ;
        myh.flat2.setText(houseiteams.get(position).getFlatno());
        myh.bedroom2.setText(houseiteams.get(position).getBedroom()) ;
        myh.washroom2.setText(houseiteams.get(position).getWashroom()) ;
        myh.rent2.setText(houseiteams.get(position).getRent()) ;

        return myview;
    }
}
