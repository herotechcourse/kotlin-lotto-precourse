package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoMachine {
    fun generateLottoTickets(purchaseAmount: Int): List<Lotto> {
        val money = Money(purchaseAmount)
        val ticketCount = money.countTickets()

        /* Return a list of Lotto tickets with unique random numbers
        * Pick 6 unique random numbers between 1 and 45, then sort them in ascending order
        */
        return List(ticketCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(
                Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.REQUIRED_SIZE
            ).sorted()
            Lotto(numbers)
        }
    }
}