package com.example.midtermretrofit.holder;


import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.midtermretrofit.R;

public class breedHolder extends RecyclerView.ViewHolder {


    public TextView name;

    public breedHolder(View itemView) {
        super(itemView);

        name = (TextView) itemView.findViewById(R.id.txtName);
    }
}

