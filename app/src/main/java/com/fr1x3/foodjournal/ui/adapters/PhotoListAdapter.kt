package com.fr1x3.foodjournal.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.fr1x3.foodjournal.databinding.FragmentPhotoListItemBinding
import com.fr1x3.foodjournal.models.Food

class PhotoListAdapter: RecyclerView.Adapter<PhotoListAdapter.photoListViewHolder>() {

    inner class photoListViewHolder(val itemBinding: FragmentPhotoListItemBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(foodItem: Food) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): photoListViewHolder {
        val binding = FragmentPhotoListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return photoListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: photoListViewHolder, position: Int) {
        val foodItem = differ.currentList[position]
        holder.bind(foodItem)
    }

    override fun getItemCount(): Int = differ.currentList.size

    val differCallback = object: DiffUtil.ItemCallback<Food>(){
        override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean =
            oldItem == newItem

    }

    val differ = AsyncListDiffer(this, differCallback)
}