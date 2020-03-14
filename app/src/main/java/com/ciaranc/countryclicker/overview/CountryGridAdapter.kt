package com.ciaranc.countryclicker.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ciaranc.countryclicker.databinding.GridItemBinding
import com.ciaranc.countryclicker.network.Country

class CountryGridAdapter(val onClickListener: OnClickListener) :
    ListAdapter<Country, CountryGridAdapter.CountryViewHolder>(DiffCallback){
    class CountryViewHolder(private var binding: GridItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            binding.country = country
            /*  Causes Country update to execute immediately, saving the
            RecyclerView from carrying out additional calculations when
            rendering the list. */
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Country>(){
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.name == newItem.name
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryGridAdapter.CountryViewHolder {
        return CountryViewHolder(GridItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CountryGridAdapter.CountryViewHolder, position: Int) {
        val country = getItem(position)
        holder.bind(country)
        holder.itemView.setOnClickListener { onClickListener.onClick(country) }
    }
    class OnClickListener(val clickListener: (country: Country) -> Unit){
        fun onClick(country: Country) = clickListener(country)
    }
}