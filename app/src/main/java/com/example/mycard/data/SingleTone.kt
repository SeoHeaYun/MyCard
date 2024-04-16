package com.example.mycard.data

class SingletonData { //Singleton 생성
    companion object {
        private var INSTANCE: SingletonData? = null
        fun getDataSource(): SingletonData {
            return synchronized(SingletonData::class) {
                val newInstance = INSTANCE ?: SingletonData()
                newInstance// return 값
            }
        }
    }

    fun getCardList(): List<CardData> {
        return dataList()
    }

}