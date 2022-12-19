package com.ruslanchikbananchik.rmma.adapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.content.Context
import android.provider.Settings.System.getString
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ruslanchikbananchik.rmma.R
import com.ruslanchikbananchik.rmma.model.Facts
import kotlinx.android.synthetic.main.item_layout.view.*

class FactAdapter(private val context: Context,
                  private val factList: Facts
): RecyclerView.Adapter<FactAdapter.FactViewHolder>() {

    class FactViewHolder(factView: View): RecyclerView.ViewHolder(factView) {
        val fact: TextView = factView.fact
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout, parent, false)
        return FactViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return factList.facts.size
    }

    override fun onBindViewHolder(holder: FactViewHolder, position: Int) {
        holder.fact.text = context.getString(R.string.catFact_1, position+1, factList.facts[position])
    }

}