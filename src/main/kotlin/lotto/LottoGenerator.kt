package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {

    fun createLottoTicket():Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        return Lotto(numbers)
    }
}