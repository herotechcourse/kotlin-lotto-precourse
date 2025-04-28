package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object LottoMachine {
    fun createTickets(amount: Int): List<Lotto> {
        val count = amount / 1000

        return List(count) { generateTicket() }
    }

    private fun generateTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)

        return Lotto(numbers)
    }

    fun calculateResult(tickets: List<Lotto>, winningNumbers: List<Int>, bonus: Int): LottoResult {
        return LottoResult.of(tickets, winningNumbers, bonus)
    }
}