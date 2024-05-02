package com.example.mycard.data_layer.repository

import com.example.mycard.ui_layer.model.CardModel
import com.example.mycard.ui_layer.presentation.CardViewModel

interface SearchRepository {
    fun getCardList() : List<CardModel>
}