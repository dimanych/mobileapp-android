package com.dimanych.cleanbaseapplication.presentation.main.submain.images

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dimanych.cleanbaseapplication.R
import com.dimanych.cleanbaseapplication.data.main.model.ImageData
import com.dimanych.cleanbaseapplication.util.extensions.load
import kotlinx.android.synthetic.main.item_images_select.view.*

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    private val imagesList = mutableListOf<ImageData>()
    private var lastCheckedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_images_select, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = imagesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindImageData(imagesList[position])
        holder.itemView.rbSelected.isChecked = position == lastCheckedPosition
    }

    fun setItems(imagesList: List<ImageData>) {
        this.imagesList.clear()
        this.imagesList.addAll(imagesList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindImageData(imageData: ImageData) {
            itemView.ivSelected.load(imageData.imgSource)
            val clickListener = {
                lastCheckedPosition = adapterPosition
                notifyDataSetChanged()
            }

            itemView.rbSelected.setOnClickListener { clickListener.invoke() }
            itemView.setOnClickListener { clickListener.invoke() }
        }

    }

}