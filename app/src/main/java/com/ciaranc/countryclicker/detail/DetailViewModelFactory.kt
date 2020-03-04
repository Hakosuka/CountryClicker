package com.ciaranc.countryclicker.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ciaranc.countryclicker.network.Country
import java.lang.IllegalArgumentException

class DetailViewModelFactory(private val countryData: Country,
    private val application: Application ) : ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CountryDetailViewModel::class.java)){
            return CountryDetailViewModel(countryData, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}