package com.example.mycard

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycard.data.CardData
import com.example.mycard.data.SingletonData
import com.example.mycard.databinding.ActivityMainBinding
import com.example.mycard.presentation.CardAdapter
import com.example.mycard.presentation.DetailActivity
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val cardAdapter: CardAdapter by lazy {
        CardAdapter { item ->     // 클릭 이벤트가 발생한 리사이클러뷰 아이템이 넘겨준다 -> 생성자 호출하여 adapter 초기화. ItemData 타입의 파라미터로만 콜백 초기화가능
            adapterOnClick(item)
        }
    }

    private fun adapterOnClick(card: CardData) {
        val intent = Intent(this, DetailActivity()::class.java)
        // 선택한 항목에 따라 다른 데이터 디테일 페이지에 뿌리기
        val bundle = Bundle()     // parcelize 경우, putExtra 에서 bundle 지원이 안되서, 따로 번들 형성한 후, 값 보내줘야 함! + 보낼 떄는 객체 자체를 통째로 보내고(bundle) 받을 때, 받을 때거기서 뽑아서 쓰면 됨.
        bundle.putParcelable("Bundle", card)
        intent.putExtras(bundle)
        Log.d("card", card.toString())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        // SingletionData 인스턴스 얻기
        val singletonData = SingletonData.getDataSource()
        cardAdapter.cardList = singletonData.getCardList()  // 아이템 목록 가져와서 사용하기

        // 리싸이클러뷰와 어뎁터 연결
        with(binding.recyclerView) { // binding.recyclerView가 null이 아님이 보장될 것!
            this.adapter = cardAdapter   // this는 생략가능
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Decimal Format
        val decimal = DecimalFormat("0,000.00")
        val num = 285856.20
        val formatNumber = decimal.format(num)
        binding.yourMoney.text = formatNumber.toString()




    }
}