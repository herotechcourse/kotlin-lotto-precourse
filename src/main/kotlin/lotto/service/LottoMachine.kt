package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

/**
 * LottoMachine is responsible for generating a list of lotto tickets
 * based on the user’s purchase amount.
 */

class LottoMachine {

    fun generateTickets(amount: Int): List<Lotto>{
        val ticketCount = amount / 1000
        return List(ticketCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            Lotto(numbers)
        }
    }
}
