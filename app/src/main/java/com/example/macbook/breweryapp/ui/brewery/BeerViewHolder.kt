package com.example.macbook.breweryapp.ui.brewery

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.macbook.breweryapp.R
import com.example.macbook.breweryapp.model.Beer

class BeerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.beer_item, parent, false)) {

    fun bind(beer: Beer) {

    }

}