package com.example.thirdsunnyweather.ui.place

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.thirdsunnyweather.R
import com.example.thirdsunnyweather.logic.model.Place

class PlaceAdapter(val fragment: Fragment, private val placeList: List<Place>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val newItem = 0;
    private val commonItem = 1;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View
        return if (viewType == newItem) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.new_item, parent, false)

            NewItemHolder(view)
        } else {
            view = LayoutInflater.from(parent.context).inflate(R.layout.common_item, parent, false)
            CommonItemHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is NewItemHolder) {
            holder.placeAddress.text = placeList[position].address
            holder.placeName.text = placeList[position].name
            holder.newItem.text = "This is a new item"
        } else {
            val commonItemHolder = holder as CommonItemHolder
            commonItemHolder.placeAddress.text = placeList[position].address
            commonItemHolder.placeName.text = placeList[position].name
        }
    }

    override fun getItemCount(): Int {
        return placeList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) {
            newItem;
        } else
            commonItem
    }
}

class NewItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val placeName: TextView = itemView.findViewById(R.id.placeName)
    val placeAddress: TextView = itemView.findViewById(R.id.placeAddress)
    val newItem: TextView = itemView.findViewById(R.id.newItem)
}

class CommonItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val placeName: TextView = itemView.findViewById(R.id.placeName)
    val placeAddress: TextView = itemView.findViewById(R.id.placeAddress)
}