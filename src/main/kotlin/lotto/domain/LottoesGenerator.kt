package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object LottoesGenerator {

    private const val TICKET_PRICE = 1000

    fun generate(amount: Int): Lottoes {
        val count = amount / TICKET_PRICE
        val tickets = List(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            Lotto(numbers)
        }
        return Lottoes(tickets)
    }
}