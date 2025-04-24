package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import kotlin.random.Random

class LottoMachine {
    fun generateLottoTickets(purchaseAmount: Int): List<Lotto> {
        val money = Money(purchaseAmount)
        val ticketCount = money.countTickets()

        /* Return a list of Lotto tickets with unique random numbers
        * Pick 6 unique random numbers between 1 and 45, then sort them in ascending order
        */
        return List(ticketCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE).sorted()
            Lotto(numbers)
        }
    }

    companion object {
        private val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val LOTTO_SIZE = 6

    }
}