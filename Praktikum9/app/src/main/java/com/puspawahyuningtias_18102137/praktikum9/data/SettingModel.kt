package com.puspawahyuningtias_18102137.praktikum9.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SettingModel (
    var name: String? = null,
    var email: String? = null,
    var address: String? = null,
    var age: Int = 0,
    var phoneNumber: String? = null,
    var jk:Boolean = false,
    var isDarkTheme: Boolean = false
): Parcelable
