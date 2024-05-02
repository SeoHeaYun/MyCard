package com.example.mycard.data_layer

import com.example.mycard.data_layer.entity.CardEntity
import com.example.mycard.data_layer.local_database.dataList

// Local Database 생성하는 싱글톤 객체
object DataSource {
    fun getDataList(): List<CardEntity> {
        return dataList()
    }
}




// companion object를 활용한 싱글톤 구현

//class SingletonData { //Singleton 생성
//    companion object {
//        private var INSTANCE: SingletonData? = null
//        fun getSingleTon(): SingletonData {
//            return synchronized(SingletonData::class) {
//                val newInstance = INSTANCE ?: SingletonData()
//                newInstance// return 값
//            }
//        }
//    }
//
//    fun getCardList() = dataList()
//}
//
