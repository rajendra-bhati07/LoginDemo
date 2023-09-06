package com.it.logindemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.it.logindemo.databinding.ItemListBinding
import com.it.logindemo.viewmodel.ItemsViewModel

class ShowDataAdapter(
    var list: List<ItemsViewModel>,
) : RecyclerView.Adapter<ShowDataAdapter.ViewHolder>() {

    // create an inner class with name ViewHolder
    // It takes a view argument, in which pass the generated class of single_item.xml
    // ie SingleItemBinding and in the RecyclerView.ViewHolder(binding.root) pass it like this
    inner class ViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    // inside the onCreateViewHolder inflate the view of SingleItemBinding
    // and return new ViewHolder object containing this layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    // bind the items with each item
    // of the list languageList
    // which than will be
    // shown in recycler view
    // to keep it simple we are
    // not setting any image data to view
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