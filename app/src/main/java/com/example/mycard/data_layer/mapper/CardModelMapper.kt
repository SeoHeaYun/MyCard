package com.example.mycard.data_layer.mapper

import com.example.mycard.data_layer.entity.CardEntity
import com.example.mycard.ui_layer.model.CardModel
import com.example.mycard.ui_layer.presentation.CardViewModel


//추후 DTO, DAO, Entity등 domain layer, presentation layer에 필요한 model만 data class에서 mapping해서 쓸 용도
fun List<CardEntity>.asCardModel(): List<CardModel> {
    return map {
        CardModel(
            it.cardName,
            it.cardNumber,
            it.cardExpiration,
            it.cardMoney,
            it.viewType
        )
    }
}
