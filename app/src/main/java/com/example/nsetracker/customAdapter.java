package com.example.nsetracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class customAdapter extends RecyclerView.Adapter<customAdapter.ViewHolder> {


    Context context;
    ArrayList<Model> list;

    customAdapter(Context context,ArrayList<Model> list)
    {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.itemlistdesign,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.priceTxtView.setText(list.get(position).getPrices());
        holder.nameTxtView.setText(list.get(position).getNames());
        holder.priceChngTxtView.setText(list.get(position).getPricechange());
        holder.changeTxtView.setText("("+list.get(position).getPerchange()+")");
        if(Integer.parseInt(list.get(position).getPrevclose()) <= Integer.parseInt(list.get(position).getPrices()))
        {
            holder.imgView.setImageResource(R.drawable.growarrow);
        }
        else
            holder.imgView.setImageResource(R.drawable.decarrow);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv=v.findViewById(R.id.nameTxtView);
                Log.d("hello1","So high");
                String str=tv.getText().toString();
                Intent i=new Intent(context, chartActivity.class);
                i.putExtra("name",str);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        TextView nameTxtView,priceTxtView,priceChngTxtView,changeTxtView;
        ImageView imgView;

        LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            layout=itemView.findViewById(R.id.itemlistdesign);
            nameTxtView=itemView.findViewById(R.id.nameTxtView);
            priceTxtView=itemView.findViewById(R.id.priceTxtView);
            priceChngTxtView=itemView.findViewById(R.id.priceChange);
            changeTxtView=itemView.findViewById(R.id.perChange);
            imgView= itemView.findViewById(R.id.img_arrow);

        }

    }
}
