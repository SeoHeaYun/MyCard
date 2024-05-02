package com.example.mycard.ui_layer.model

import android.os.Parcelable
import com.example.mycard.ui_layer.user_interface.MultiViewEnum
import kotlinx.android.parcel.Parcelize

//bundle로 보내기 위하여 parcelize 추가
@Parcelize
class CardModel (
    val cardName : String,
    val cardNumber: String,
    val cardExpiration: String,
    val cardMoney: Double,
    val cardViewType: MultiViewEnum
) : Parcelable /* {
    companion object {
        const val VIEW_TYPE1 = 0
        const val VIEW_TYPE2 = 1
        const val VIEW_TYPE3 = 2
    }
} */