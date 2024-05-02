package com.example.mycard.ui_layer.user_interface

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycard.databinding.ActivityMainBinding
import com.example.mycard.ui_layer.model.CardModel
import com.example.mycard.ui_layer.presentation.CardViewModel
import com.example.mycard.ui_layer.presentation.CardViewModelFactory
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    // 뷰모델 생성
    private val cardViewModel by viewModels<CardViewModel> { // by viewModels로 Provider 대신함. (by: cardViewModel 생성을 viewModel함수에 객체 생성 위임 즉, cardViewModel이 초기화될 때, viewModel()함수가 실행된다. 47번째 라인에서 볼 수 있듯, 사용하면서 동시에 factory실행됨.)
        CardViewModelFactory()
    }

    private lateinit var cardList: List<CardModel>

    private val cardAdapter: CardAdapter by lazy {
        CardAdapter { item ->
            adapterOnClick(item)
        }
    }

    private fun adapterOnClick(card: CardModel) {
        val intent = Intent(this, DetailActivity()::class.java)
        // 선택한 항목에 따라 다른 데이터 디테일 페이지에 뿌리기
        val bundle =
            Bundle()     // parcelize 경우, putExtra 에서 bundle 지원이 안되서, 따로 번들 형성한 후, 값 보내줘야 함! + 보낼 떄는 객체 자체를 통째로 보내고(bundle) 받을 때, 받을 때거기서 뽑아서 쓰면 됨.
        bundle.putParcelable("Bundle", card)
        intent.putExtras(bundle)
        Log.d("card", card.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViewModel()
        initData()
    }

    private fun initData() {
        cardViewModel.getCardModel()
    }

    private fun initViewModel() {
        cardViewModel.getCardModel.observe(this@MainActivity) {
            cardList = it

            initView()
        }
    }


    private fun initView() {
        cardAdapter.cardList = cardList  // 뷰모델과 연결된 리스트를 어뎁터 리스트와 연결
        with(binding.recyclerView) { // 리싸이클러뷰 어댑터 연결
            this.adapter = cardAdapter   // this는 생략가능
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }

        // Decimal Format
        val decimal = DecimalFormat("0,000.00")
        val num = 285856.20
        val formatNumber = decimal.format(num)
        binding.yourMoney.text = formatNumber.toString()


    }

}
