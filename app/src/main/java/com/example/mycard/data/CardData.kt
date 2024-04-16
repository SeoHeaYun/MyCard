package com.example.mycard.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class CardData (
    val cardName : String,
    val cardNumber: String,
    val cardExpiration: String,
    val cardMoney: Double,
    val viewType: Int
) : Parcelable {
    companion object {
        const val VIEW_TYPE1 = 0
        const val VIEW_TYPE2 = 1
        const val VIEW_TYPE3 = 2

    }
}