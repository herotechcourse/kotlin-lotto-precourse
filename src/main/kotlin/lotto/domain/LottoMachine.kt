package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoMachine {
  fun issu(count:Int): List<Lotto> {
    val lottoList = mutableListOf<Lotto>()

    for(i in 1..count){
      val numbers = Randoms.pickUniqueNumbersInRange(1,45,6).sorted()
      val lotto = Lotto(numbers) //
      lottoList.add(lotto)
    }
    return lottoList;
  }
}