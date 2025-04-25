package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoGenerator {

    private const val TICKET_PRICE = 1000

    private fun countFromAmount(amount: Int): Int {
        require(amount % TICKET_PRICE == 0) {
            "[ERROR] Purchase amount must be divisible by 1,000."
        }
        return amount / TICKET_PRICE
    }

    fun generate(amount: Int): List<Lotto> {
        return List(countFromAmount(amount)) {
            val randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            Lotto(randomNumbers)
        }
    }
}