package com.ciaranc.countryclicker.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import com.ciaranc.countryclicker.R
import com.ciaranc.countryclicker.databinding.CountryDetailFragmentBinding

class CountryDetailFragment : Fragment() {

    companion object {
        fun newInstance() = CountryDetailFragment()
    }


    private lateinit var viewModel: CountryDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val application = requireNotNull(activity).application
        val binding = CountryDetailFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        //TODO; set up bindings
        val country = CountryDetailFragmentArgs.fromBundle(arguments!!).selectedCountry
        val viewModelFactory = DetailViewModelFactory(country, application)
        binding.viewModel = country
        return binding.root
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(CountryDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }*/

}
