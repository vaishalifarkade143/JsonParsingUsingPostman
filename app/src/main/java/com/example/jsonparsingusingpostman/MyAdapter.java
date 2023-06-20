package com.example.jsonparsingusingpostman;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    int[] arr_img;
    ArrayList<String> arrNames;

    //2...
    Context context;

    int lastPosition= -1;

    public MyAdapter(int[] arr_img, ArrayList<String> arrNames)
    {
        this.arr_img = arr_img;
        this.arrNames = arrNames;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

          context = parent.getContext();
          LayoutInflater layoutInflater = LayoutInflater.from(context);
          View view= layoutInflater.inflate(R.layout.single_item,parent,false);
          return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
//        holder.img.setImageResource(arr_img[position]);//position is index position
//        holder.names.setText(arr_names[position]);
//
//        //5...call bcz yaha se data bind hota hai
//        // rViewAnimation(holder.itemView);
//        rViewAnimation(holder.itemView,position);

        holder.

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
