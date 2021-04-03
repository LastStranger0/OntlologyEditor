package com.mtg.grakoviiredactor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView

class EntityAdapter(var list: MutableList<Entity>):RecyclerView.Adapter<EntityAdapter.EntityHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.entity, parent, false)
        return EntityHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: EntityHolder, position: Int) {
        var text = list[position].name
        text = text.padStart(list[position].lvl, ' ')
        holder.name.text = text
    }

    override fun getItemCount(): Int {
        return list.size
    }
    class EntityHolder(view: View): RecyclerView.ViewHolder(view){
        var name: MaterialTextView = view.findViewById(R.id.entityName)
    }
}