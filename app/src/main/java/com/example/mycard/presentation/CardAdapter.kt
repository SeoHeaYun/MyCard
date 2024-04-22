package com.example.mycard.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycard.R
import com.example.mycard.data.CardData
import com.example.mycard.data.CardData.Companion.VIEW_TYPE1
import com.example.mycard.data.CardData.Companion.VIEW_TYPE2
import com.example.mycard.data.CardData.Companion.VIEW_TYPE3
import com.example.mycard.databinding.ItemType1Binding
import com.example.mycard.databinding.ItemType2Binding
import com.example.mycard.databinding.ItemType3Binding
import java.lang.RuntimeException
import java.text.DecimalFormat

var cardList = listOf<CardData>() // iner class로 안만들어서 전역 변수로 뺌
class CardAdapter( private val onClick: (CardData) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {  // 멀티뷰 홀더이므로 ViewHolder로 지정.


    // 뷰홀더1
    class CardViewHolder1(private var binding: ItemType1Binding, val onClick: (CardData) -> Unit)  // 직렬화 문제 발생 가능성 / inner class 내부에 outer class 정보를 보관, 참조를 해제하지 못하면 메모리 누수 발생가능성
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
    class CardViewHolder2(private var binding: ItemType2Binding, val onClick: (CardData) -> Unit)
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
     class CardViewHolder3(private var binding: ItemType3Binding, val onClick: (CardData) -> Unit)
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
        return cardList[position].viewType // positon을 when으로 빼지않고, 각 position의 type값을 받아와서 확장성있게 사용하기.
    }

    /* cf.
    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> VIEW_TYPE1
            1 -> VIEW_TYPE2
            2 -> VIEW_TYPE3
            else -> throw Exception()
        }
    }
     */


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            VIEW_TYPE1 -> {
                val binding = LayoutInflater.from(parent.context).inflate(R.layout.item_type1, parent, false)
                return CardViewHolder1(ItemType1Binding.bind(binding), onClick)
            }
            VIEW_TYPE2 -> {
                val binding = LayoutInflater.from(parent.context).inflate(R.layout.item_type2, parent, false)
                return CardViewHolder2(ItemType2Binding.bind(binding), onClick)
            }
            VIEW_TYPE3 -> {
                val binding = LayoutInflater.from(parent.context).inflate(R.layout.item_type3, parent, false)
                return CardViewHolder3(ItemType3Binding.bind(binding), onClick)
            }
            else -> throw RuntimeException("알 수 없는 뷰타입 에러")
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val obj = cardList[position]
        when(obj.viewType) {
            VIEW_TYPE1 -> (holder as CardViewHolder1).bind1(obj)
            VIEW_TYPE2 -> (holder as CardViewHolder2).bind2(obj)
            VIEW_TYPE3 -> (holder as CardViewHolder3).bind3(obj)

        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }
}





