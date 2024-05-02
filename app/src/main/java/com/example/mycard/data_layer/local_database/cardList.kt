package com.example.mycard.data_layer.local_database
import com.example.mycard.data_layer.entity.CardEntity
import com.example.mycard.ui_layer.user_interface.MultiViewEnum


// Data Layer- Network or Local DataBase

fun dataList():List<CardEntity> {
    return listOf(
        CardEntity(
            cardName = "Kakao Card",
            cardNumber = "5841  1648  3154  1654",
            cardExpiration = "28 / 12",
            cardMoney = 845618.62,
            MultiViewEnum.BLUE
        ),
        CardEntity(
            cardName = "Woori Card",
            cardNumber = "1688  1645  0868  7823",
            cardExpiration = "27 / 7",
            cardMoney = 683745.13,
            MultiViewEnum.LIGHTBLUE
        ),
        CardEntity(
            cardName = "Haeyun Card",
            cardNumber = "5412  1810  3354  9712",
            cardExpiration = "24 / 1",
            cardMoney = 756692.47,
            MultiViewEnum.ORANGE
        ),
        CardEntity(
            cardName = "Shinhan Card",
            cardNumber = "6842  3122  7899  5132",
            cardExpiration = "30 / 11",
            cardMoney = 332697.54,
            MultiViewEnum.BLUE
        ),
        CardEntity(
            cardName = "Sparta Card",
            cardNumber = "9848  0247  7825  7896",
            cardExpiration = "24 / 7",
            cardMoney = 798235.54,
            MultiViewEnum.LIGHTBLUE
        ),
        CardEntity(
            cardName = "Happy Card",
            cardNumber = "9637  1608  3312  7820",
            cardExpiration = "27 / 6",
            cardMoney = 267747.58,
            MultiViewEnum.ORANGE

        ), CardEntity(
            cardName = "Kakao Card",
            cardNumber = "5841  1648  3154  1654",
            cardExpiration = "28 / 12",
            cardMoney = 845618.62,
            MultiViewEnum.BLUE

        ),
        CardEntity(
            cardName = "Woori Card",
            cardNumber = "1688  1645  0868  7823",
            cardExpiration = "27 / 7",
            cardMoney = 683745.13,
            MultiViewEnum.LIGHTBLUE
        ),
        CardEntity(
            cardName = "Haeyun Card",
            cardNumber = "5412  1810  3354  9712",
            cardExpiration = "24 / 1",
            cardMoney = 756692.47,
            MultiViewEnum.ORANGE
        ),
        CardEntity(
            cardName = "Shinhan Card",
            cardNumber = "6842  3122  7899  5132",
            cardExpiration = "30 / 11",
            cardMoney = 332697.54,
            MultiViewEnum.BLUE
        ),
        CardEntity(
            cardName = "Sparta Card",
            cardNumber = "9848  0247  7825  7896",
            cardExpiration = "24 / 7",
            cardMoney = 798235.54,
            MultiViewEnum.LIGHTBLUE
        ),
        CardEntity(
            cardName = "Happy Card",
            cardNumber = "9637  1608  3312  7820",
            cardExpiration = "27 / 6",
            cardMoney = 267747.58,
            MultiViewEnum.ORANGE

        )

    )

}