package com.projects.covidmvvm.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.projects.covidmvvm.R
import com.projects.covidmvvm.data.models.StatewiseItem
import kotlinx.android.synthetic.main.list_item.view.*

class StateAdapter(var items: ArrayList<StatewiseItem>): RecyclerView.Adapter<StateViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = StateViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
    )

    override fun onBindViewHolder(holder: StateViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    fun setUpdateData(items : ArrayList<StatewiseItem>){
        this.items = items
        notifyDataSetChanged()
    }

}

class StateViewHolder(iemView: View) : RecyclerView.ViewHolder(iemView) {
    fun bind(item: StatewiseItem) = with(itemView) {
        stateTv.text = item.state
        confirmedTv.text = item.confirmed
        deadTV.text = item.deaths
        recoveredtv.text = item.recovered
    }
}
