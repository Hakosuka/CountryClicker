package com.ciaranc.countryclicker.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TranslatedName(
    val translations: List<String?>): Parcelable {}