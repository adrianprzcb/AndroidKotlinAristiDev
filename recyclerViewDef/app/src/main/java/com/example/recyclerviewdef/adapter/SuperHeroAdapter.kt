package com.example.recyclerviewdef.adapter

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdef.R
import com.example.recyclerviewdef.SuperHero
import com.example.recyclerviewdef.SuperHeroProvider.Companion.superHeroList

class SuperHeroAdapter(private val supeheroList: List<SuperHero>, private val onClickListener:(SuperHero) -> Unit ): RecyclerView.Adapter<SuperHeroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val item = superHeroList[position]
        holder.render(item,onClickListener )
    }

    override fun getItemCount(): Int = supeheroList.size
}