package com.ciaranc.countryclicker.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(
    val name: String,
    val capital: String,
    val altSpellings: String,
    val relevance: String,
    val region: String,
    val subregion: String,
    @Json(name="translations") val translatedName: String,
    val population: Int,
    @Json(name="latlng") val location: String,
    val demonym: String,
    val area: Int,
    val gini: Double,
    val timezones: String,
    val callingCodes: String,
    @Json(name="topLevelDomain") val countryDomain: String,
    val alpha2Code: String,
    val alpha3Code: String,
    val currencies: String,
    val languages: String): Parcelable {}