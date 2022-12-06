package com.ruslanchikbananchik.rmma.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.contentcapture.ContentCaptureContext
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ruslanchikbananchik.rmma.R
import com.ruslanchikbananchik.rmma.model.Fact
import kotlinx.android.synthetic.main.item_layout.view.*

class FactAdapter(private val context: Context,
                  private val factList: MutableList<Fact>):
    RecyclerView.Adapter<FactAdapter.FactViewHolder>() {

    class FactViewHolder(factView: View): RecyclerView.ViewHolder(factView) {
        val fact: TextView = factView.fact
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout, parent, false)
        return FactViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return factList.size
    }

    override fun onBindViewHolder(holder: FactViewHolder, position: Int) {
        holder.fact.text = factList[position].fact
    }

}