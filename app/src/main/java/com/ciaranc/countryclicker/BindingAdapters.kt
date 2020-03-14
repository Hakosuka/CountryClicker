package com.ciaranc.countryclicker

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ciaranc.countryclicker.network.Country
import com.ciaranc.countryclicker.overview.CountryGridAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Country>?) {
    val adapter = recyclerView.adapter as CountryGridAdapter
    adapter.submitList(data)
}