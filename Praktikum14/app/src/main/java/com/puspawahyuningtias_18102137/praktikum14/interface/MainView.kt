package com.puspawahyuningtias_18102137.praktikum14.`interface`

import com.puspawahyuningtias_18102137.praktikum14.model.Login
import com.puspawahyuningtias_18102137.praktikum14.model.Quote

interface MainView {
    fun showMessage(messsage : String)
    fun resultQuote(data: ArrayList<Quote>)
    fun resultLogin(data: Login)
}