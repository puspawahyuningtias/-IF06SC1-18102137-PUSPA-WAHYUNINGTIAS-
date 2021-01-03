package com.puspawahyuningtias_18102137.praktikum10.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Quote(
    var id: Int = 0,
    var title: String? = null,
    var description: String? = null,
    var category: String? = null,
    var kolom1: String? = null,
    var kolom2: String? = null,
    var date: String? = null
) : Parcelable