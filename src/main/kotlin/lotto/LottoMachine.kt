package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {

    fun generateTckets(amount: Int): List<Lotto>{
        require(amount % 1000 == 0) { "[ERROR] Amount must be divisible by 1000." }
        val ticketCount = amount / 1000
        return List(ticketCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            Lotto(numbers)
        }
    }
}
