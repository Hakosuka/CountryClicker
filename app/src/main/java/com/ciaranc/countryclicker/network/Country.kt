package com.ciaranc.countryclicker.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * This is a data class, its fields correspond to those from the API.
 * Some entities from the API have null values, so that's why some fields here are
 * nullable.
 */
@Parcelize
data class Country(
    val name: String,
    val capital: String,
    val altSpellings: List<String>,
    val relevance: String?,
    val region: String,
    val subregion: String,
    //This is a Map because its values follow a formula of "language":"translation"
    val translations: Map<String, String>,
    val population: Int,
    @Json(name="latlng") val location: List<Double>,
    val demonym: String,
    val area: Double?,
    val gini: Double?,
    val timezones: List<String?>,
    val callingCodes: List<String>,
    val topLevelDomain: List<String>,
    val alpha2Code: String,
    val alpha3Code: String,
    val currencies: List<String>,
    val languages: List<String>): Parcelable {}