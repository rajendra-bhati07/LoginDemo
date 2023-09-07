package com.it.logindemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.it.logindemo.databinding.ItemListRecyclerBinding
import com.it.logindemo.data.viewmodel.ItemsViewModel

class RecyclerDataAdapter(
    var list: List<ItemsViewModel>,
) : RecyclerView.Adapter<RecyclerDataAdapter.ViewHolder>() {
    // create an inner class with name ViewHolder
    // It takes a view argument, in which pass the generated class of list_item_recycler.xml
    // ie list_item_recycler and in the RecyclerView.ViewHolder(binding.root) pass it like this
    inner class ViewHolder(val binding: ItemListRecyclerBinding) : RecyclerView.ViewHolder(binding.root)

    // inside the onCreateViewHolder inflate the view of SingleItemBinding
    // and return new ViewHolder object containing this layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }
    // bind the items with each item of the List

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(list[position]){
                binding.ivImage.setImageResource(image)
                binding.tvTitle.text = this.title
                binding.tvDesc.text = this.description
            }
        }
    }
    // return the size of list
    override fun getItemCount(): Int {
        return list.size
    }
}