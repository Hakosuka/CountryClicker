package com.ciaranc.countryclicker.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ciaranc.countryclicker.network.CountriesApiService
import com.ciaranc.countryclicker.network.Country
import com.ciaranc.countryclicker.network.CountryApi
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class CountriesViewModel : ViewModel() {
    private val TAG = "CountriesViewModel"
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    // TODO: Implement the ViewModels
    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>>
        get() = _countries

    private val _navToSelectedCountry = MutableLiveData<Country>()
    val navToSelectedCountry: LiveData<Country>
        get() = _navToSelectedCountry

    init {
        getListOfCountries()
    }

    private fun getListOfCountries(){
        coroutineScope.launch {
            var getCountriesDeferred = CountryApi.retrofitService.getCountries()
            try {
                var listResult = getCountriesDeferred.await()
                _response.value = "${listResult.size} countries returned"
                _countries.value = listResult
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}. Time to go trawl StackOverflow."
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
