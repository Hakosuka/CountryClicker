package com.ciaranc.countryclicker.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ciaranc.countryclicker.network.CountriesApiService
import com.ciaranc.countryclicker.network.CountryApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountriesViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init {
        getListOfCountries()
    }

    private fun getListOfCountries(){
        //TODO: Call the CountriesAPI to enqueue the Retrofit request and implement callbacks
        CountryApi.retrofitService.getCountries().enqueue(object: Callback<String>{
            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "Press F to pay respects. Either that or curse at your phone because of " + t.message
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                _response.value = response.body()
            }
        })
        _response.value = "FEED ME"
    }
}
