package com.example.mycard.data_layer.repository

import com.example.mycard.data_layer.DataSource
import com.example.mycard.data_layer.mapper.asCardModel

//model로 mapping하는 위치는 자율
//repository -> dataSource의 의존성 회피
//의존을 없애면 datasource변경(network->database) 시 repository에 영향 xx

//interface인 repository를 구현함으로써 dataSource의 data를 가져옴
class SearchRepositoryImpl(private val dataSource : DataSource) : SearchRepository{
    override fun getCardList() = dataSource.getDataList().asCardModel()
}