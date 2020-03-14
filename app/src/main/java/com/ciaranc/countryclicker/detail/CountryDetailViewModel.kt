package com.ciaranc.countryclicker.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.ciaranc.countryclicker.network.Country

class CountryDetailViewModel(countryData: Country,
                             app: Application) : AndroidViewModel(app) {
    // TODO: Implement the ViewModel
    private val _selectedCountry = MutableLiveData<Country>()
    val selectedCountry: LiveData<Country>
        get() = _selectedCountry

    init {
        _selectedCountry.value = countryData
    }


}
