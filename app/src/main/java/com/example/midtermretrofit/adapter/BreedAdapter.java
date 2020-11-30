package com.example.midtermretrofit.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.midtermretrofit.holder.breedHolder;
import com.example.midtermretrofit.R;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import com.example.midtermretrofit.models.breeds;



public class BreedAdapter extends RecyclerView.Adapter<breedHolder> {

    List<breeds> list = Collections.emptyList();
    Context context;

    public BreedAdapter(List<breeds> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public breedHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyled_breeds, parent, false);

        return new breedHolder(view);
    }



    @Override
    public void onBindViewHolder(breedHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    public void insert(int position, breeds data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    public void remove(breeds data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

}

