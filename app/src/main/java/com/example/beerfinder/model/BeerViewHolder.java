package com.example.beerfinder.model;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.beerfinder.R;

public class BeerViewHolder extends RecyclerView.ViewHolder {

    private TextView beerTitle;
    private TextView abv;

    public BeerViewHolder(@NonNull View itemView) {
        super(itemView);


    }


}
