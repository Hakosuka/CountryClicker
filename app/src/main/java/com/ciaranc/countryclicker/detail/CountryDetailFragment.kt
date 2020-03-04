package com.ciaranc.countryclicker.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.ciaranc.countryclicker.R

class CountryDetailFragment : Fragment() {

    companion object {
        fun newInstance() = CountryDetailFragment()
    }

    private lateinit var viewModel: CountryDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val application = requireNotNull(activity).application
        //TODO; set up bindings
        return inflater.inflate(R.layout.country_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CountryDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
