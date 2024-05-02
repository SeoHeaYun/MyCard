package com.example.mycard.ui_layer.user_interface

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycard.databinding.ItemType1Binding
import com.example.mycard.databinding.ItemType2Binding
import com.example.mycard.databinding.ItemType3Binding
import com.example.mycard.databinding.ItemUnknownBinding
import com.example.mycard.ui_layer.model.CardModel
import java.lang.RuntimeException
import java.text.DecimalFormat

class CardAdapter( private val onClick: (CardModel) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {  // 멀티뷰 홀더이므로 ViewHolder로 지정.

    var cardList = listOf<CardModel>() // iner class로 안만들어서 전역 변수로 뺌


    // 뷰홀더1
    inner class CardViewHolder1(private var binding: ItemType1Binding, val onClick: (CardModel) -> Unit)  // 직렬화 문제 발생 가능성 / inner class 내부에 outer class 정보를 보관, 참조를 해제하지 못하면 메모리 누수 발생가능성
        : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onClick(cardList[position])
            }
        }
        fun bind1(card: CardModel) {
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
    inner class CardViewHolder2(private var binding: ItemType2Binding, val onClick: (CardModel) -> Unit)
        : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onClick(cardList[position])
            }
        }

        fun bind2(card: CardModel) {
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
    inner class CardViewHolder3(private var binding: ItemType3Binding, val onClick: (CardModel) -> Unit)
        : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onClick(cardList[position])
            }
        }
        fun bind3(card: CardModel) {
            // 숫자에 소수점 추가하기
            val decimal = DecimalFormat("#,###")
            val num = decimal.format(card.cardMoney)
            binding.cardName.text = card.cardName
            binding.cardExpiration.text = card.cardExpiration
            binding.cardNumber.text = card.cardNumber
            binding.cardMoney.text = num.toString()

        }
    }


    //TODO
    //Enum외의 data가 왔을 때(server or android 개발자) 대응
    class UnknownViewHolder(
        binding: ItemUnknownBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind() = Unit
    }

    //아이템의 위치(position)에 따라 어떤 뷰 타입을 가져야하는지 결정
    //position 즉 아이템의 위치에 접근하여 아이템의 뷰타입 결정
    override fun getItemViewType(position: Int): Int {
        return cardList[position].cardViewType.viewType // positon을 when으로 빼지않고, 각 position의 type값을 받아와서 확장성있게 사용하기.
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
        //enum ordinal값 사용 보단 enum의 entries(enum의 list를 뽑아서 return)를 뽑아서 사용
        //sealed class
        val MultiViewType = MultiViewEnum.entries.find { it.viewType == viewType } // entries 속성은 해당 열거형의 모든 열거 상수들을 포함하는 Set 컬렉션을 반환
        return when(MultiViewType) {
            MultiViewEnum.BLUE -> {
                val binding =
                    ItemType1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                 CardViewHolder1(binding, onClick)
            }
            MultiViewEnum.LIGHTBLUE -> {
                val binding =
                    ItemType2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                CardViewHolder2(binding, onClick)
            }
            MultiViewEnum.ORANGE -> {
                val binding =
                    ItemType3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                CardViewHolder3(binding, onClick)
            }
            else -> throw RuntimeException("알 수 없는 뷰타입 에러") //  확장성 있게 사용하려면, throw 던지는 것보다. default type을 만들어 두는 것이 좋음
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val obj = cardList[position]
        when(obj.cardViewType) {
            MultiViewEnum.BLUE -> (holder as CardViewHolder1).bind1(obj)
            MultiViewEnum.LIGHTBLUE -> (holder as CardViewHolder2).bind2(obj)
            MultiViewEnum.ORANGE -> (holder as CardViewHolder3).bind3(obj)
            MultiViewEnum.UNKNOWN -> TODO()
        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }
}




