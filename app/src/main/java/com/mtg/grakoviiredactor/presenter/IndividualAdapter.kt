package com.mtg.grakoviiredactor.presenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.mtg.grakoviiredactor.R
import com.mtg.grakoviiredactor.model.Individual

class IndividualAdapter(var individuals: MutableList<Individual>): RecyclerView.Adapter<IndividualAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var name = view.findViewById<TextView>(R.id.individualsName)
        var classes = view.findViewById<MaterialTextView>(R.id.individualsClass)
        var dataProperty = view.findViewById<AppCompatImageView>(R.id.individualsData)
        var objectProperty = view.findViewById<AppCompatImageView>(R.id.individualsObject)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_individuals, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = individuals[position].name
        holder.classes.text = individuals[position].classes.name
        if (individuals[position].dataProperties.size > 0){
            holder.dataProperty.visibility = View.VISIBLE
        }
        else{
            holder.dataProperty.visibility = View.INVISIBLE
        }
        if (individuals[position].objectProperties.size > 0){
            holder.objectProperty.visibility = View.VISIBLE
        }
        else{
            holder.objectProperty.visibility = View.INVISIBLE
        }
    }

    override fun getItemCount(): Int {
        return individuals.size
    }
}