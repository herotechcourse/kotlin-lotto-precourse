package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    private val ticketPrice = 1_000

    fun buyLottos(amount: Int): List<Lotto> {
        require(amount >= ticketPrice) { "[ERROR] Purchase amount must be at least 1,000 KRW." }
        require(amount % ticketPrice == 0) { "[ERROR] Purchase amount must be divisible by 1,000." }

        val ticketCount = amount / ticketPrice
        return List(ticketCount) { generateLotto() }
    }

    private fun generateLotto(): Lotto {
        return Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
    }
}