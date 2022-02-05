package com.example.ahnaf.myapplication2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ahnaf on 1/22/2019.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

      ArrayList<Houseiteam>houseiteams=new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       View V= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return  new ViewHolder(V);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       Houseiteam temp=houseiteams.get(position);

    }

    @Override
    public int getItemCount() {
        return houseiteams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name,phone,housename,houseno,floor,bedroom,washroom,rent;

        public ViewHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.nametext);
            phone= (TextView) itemView.findViewById(R.id.phonetext);
            housename= (TextView) itemView.findViewById(R.id.housetext);
            houseno= (TextView) itemView.findViewById(R.id.housenotext);
            floor= (TextView) itemView.findViewById(R.id.floortext);
            bedroom= (TextView) itemView.findViewById(R.id.bedtext);
            washroom= (TextView) itemView.findViewById(R.id.washtext);
            rent= (TextView) itemView.findViewById(R.id.renttext);
        }
    }

}
