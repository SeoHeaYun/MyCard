package com.example.mycard.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mycard.data.SingletonData

class CardViewModel(val singleTon: SingletonData) : ViewModel() {
    val cardLiveData = singleTon.getCardList() // 싱글톤 생성을 VM으로 뺐음
}

//viewModel 생성
// Factory 호출시 CardViewModel 인스턴스 생성하여 반환
// 종속성 주입(DI): CardViewModel이 직접 객체 생성X Factory를 통해 외부에서 주입받음 O -> 모듈화: 직접다른 객체를 생성하거나 초기화할 필요가 없어, 코드의 독립화(SingletonData가 어떻게 생성되고 관리되는지, 데이터를 직접 찾고 생성하는 복잡한 코드에 대해 신경 쓰지 않고 오직 자신의 역할에만 집중할 수 O)+ 유지보수성: CardViewModel이 다른 종속성을 필요로 하거나 수정이 필요할 때, factory에서 이를 관리함 + 재사용성
class CardViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CardViewModel::class.java)) {
            return CardViewModel(singleTon = SingletonData.getSingleTon()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}

