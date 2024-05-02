package com.example.mycard.data_layer.entity

import com.example.mycard.ui_layer.user_interface.MultiViewEnum

// Entity: 실제 Database의 테이블과 매칭되는 클래스 (Database 구조)
data class CardEntity(
    val cardName: String,
    val cardNumber: String,
    val cardExpiration: String,
    val cardMoney: Double,
    val viewType: MultiViewEnum
)
