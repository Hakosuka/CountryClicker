package com.ciaranc.countryclicker.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ciaranc.countryclicker.network.CountriesApiService
import com.ciaranc.countryclicker.network.Country
import com.ciaranc.countryclicker.network.CountryApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountriesViewModel : ViewModel() {
    private val TAG = "CountriesViewModel"
    // TODO: Implement the ViewModel
    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init {
        getListOfCountries()
    }

    private fun getListOfCountries(){
        //TODO: Call the CountriesAPI to enqueue the Retrofit request and implement callbacks
        CountryApi.retrofitService.getCountries().enqueue(object: Callback<List<Country>>{
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                _response.value = "${response.body()?.size} countries retrieved."
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                Log.d(TAG, t.message)
                _response.value = "Mission failed, we'll get 'em next time. " + t.message
            }
        })
    }
}
