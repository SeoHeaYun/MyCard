package com.example.mycard.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycard.R
import com.example.mycard.data.CardData
import com.example.mycard.databinding.ItemType1Binding
import com.example.mycard.databinding.ItemType2Binding
import com.example.mycard.databinding.ItemType3Binding
import java.lang.RuntimeException
import java.text.DecimalFormat

class CardAdapter( private val onClick: (CardData) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {  // 멀티뷰 홀더이므로 ViewHolder로 지정.

    var cardList = listOf<CardData>()

    // 뷰홀더1
    inner class CardViewHolder1(private var binding: ItemType1Binding, val onClick: (CardData) -> Unit)
        : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onClick(cardList[position])
            }
        }

        fun bind1(card: CardData) {
            // 숫자에 소수점 추가하기
            val decimal = DecimalFormat("#,###")
            val num = decimal.format(card.cardMoney)

            binding.cardName.text = card.cardName
            binding.cardExpiration.text = card.cardExpiration
            binding.cardNumber.text = card.cardNumber
            binding.cardMoney.text = num.toString()

        }
    }

    // 뷰홀더2
    inner class CardViewHolder2(private var binding: ItemType2Binding, val onClick: (CardData) -> Unit)
        : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onClick(cardList[position])
            }
        }

        fun bind2(card: CardData) {
            // 숫자에 소수점 추가하기
            val decimal = DecimalFormat("#,###")
            val num = decimal.format(card.cardMoney)

            binding.cardName.text = card.cardName
            binding.cardExpiration.text = card.cardExpiration
            binding.cardNumber.text = card.cardNumber
            binding.cardMoney.text = num.toString()

        }
    }

    // 뷰홀더3
    inner class CardViewHolder3(private var binding: ItemType3Binding, val onClick: (CardData) -> Unit)
        : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onClick(cardList[position])
            }
        }
        fun bind3(card: CardData) {
            // 숫자에 소수점 추가하기
            val decimal = DecimalFormat("#,###")
            val num = decimal.format(card.cardMoney)

            binding.cardName.text = card.cardName
            binding.cardExpiration.text = card.cardExpiration
            binding.cardNumber.text = card.cardNumber
            binding.cardMoney.text = num.toString()

        }
    }



    override fun getItemViewType(position: Int): Int {
        return cardList[position].viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            CardData.VIEW_TYPE1 -> {
                val binding = LayoutInflater.from(parent.context).inflate(R.layout.item_type1, parent, false)
                return CardViewHolder1(ItemType1Binding.bind(binding), onClick)
            }
            CardData.VIEW_TYPE2 -> {
                val binding = LayoutInflater.from(parent.context).inflate(R.layout.item_type2, parent, false)
                return CardViewHolder2(ItemType2Binding.bind(binding), onClick)
            }
            CardData.VIEW_TYPE3 -> {
                val binding = LayoutInflater.from(parent.context).inflate(R.layout.item_type3, parent, false)
                return CardViewHolder3(ItemType3Binding.bind(binding), onClick)
            }
            else -> throw RuntimeException("알 수 없는 뷰타입 에러")
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val obj = cardList[position]
        when(obj.viewType) {
            CardData.VIEW_TYPE1 -> (holder as CardViewHolder1).bind1(obj)
            CardData.VIEW_TYPE2 -> (holder as CardViewHolder2).bind2(obj)
            CardData.VIEW_TYPE3 -> (holder as CardViewHolder3).bind3(obj)

        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }
}





