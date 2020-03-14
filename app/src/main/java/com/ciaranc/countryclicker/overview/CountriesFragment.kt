package com.ciaranc.countryclicker.overview

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.ciaranc.countryclicker.R
import com.ciaranc.countryclicker.databinding.CountriesFragmentBinding

class CountriesFragment : Fragment() {

    companion object {
        fun newInstance() = CountriesFragment()
    }

    private val viewModel: CountriesViewModel by lazy {
        ViewModelProvider(this).get(CountriesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding = CountriesFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.countriesGrid.adapter = CountryGridAdapter(CountryGridAdapter.OnClickListener {
            viewModel.displayCountryDetails(it)
        })
        viewModel.navToSelectedCountry.observe(this, Observer {
            if(null != it){
                this.findNavController().navigate(CountriesFragmentDirections
                    .actionShowClickedCountry(it))
                viewModel.displayCountryDetailsComplete()
            }
        })
        setHasOptionsMenu(true)
        return binding.root
    }

}
