package com.example.mycard.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mycard.R
import com.example.mycard.data.CardData
import com.example.mycard.databinding.ActivityDetailBinding
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent : Intent = getIntent()
        val item = intent.getParcelableExtra<CardData>("Bundle")

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
