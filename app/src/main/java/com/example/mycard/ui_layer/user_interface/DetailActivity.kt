package com.example.mycard.ui_layer.user_interface

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mycard.databinding.ActivityDetailBinding
import com.example.mycard.ui_layer.model.CardModel
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initVeiw()

    }

    fun initVeiw () {
        val intent : Intent = getIntent()
        val item = intent.getParcelableExtra<CardModel>("Bundle")

        val cardName = item?.cardName
        val cardNumber = item?.cardNumber
        val cardExpriration = item?.cardExpiration
        val cardMoney = item?.cardMoney

        // 숫자에 소수점 추가
        val decimal = DecimalFormat("0,000.00") // cf. ###
        val num = decimal.format(cardMoney)

        binding.tvName.text = cardName
        binding.tvCard.text = cardNumber
        binding.tvExpiration.text = cardExpriration
        binding.tvMoney.text = num
    }
}