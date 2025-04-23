package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoMachine {
    companion object {
        private const val TICKET_PRICE = 1000
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val LOTTO_SIZE = 6
    }

    fun buyLottos(amount: Int): List<Lotto> {
        validateAmount(amount)
        val ticketCount = calculateTicketCount(amount)
        return generateLottos(ticketCount)
    }

    private fun validateAmount(amount: Int) {
        require(amount >= TICKET_PRICE) { "[ERROR] Purchase amount must be at least $TICKET_PRICE KRW." }
        require(amount % TICKET_PRICE == 0) { "[ERROR] Purchase amount must be divisible by $TICKET_PRICE KRW." }
    }

    private fun calculateTicketCount(amount: Int): Int {
        return amount / TICKET_PRICE
    }

    private fun generateLottos(count: Int): List<Lotto> {
        return List(count) { createLotto() }
    }

    private fun createLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE)
        return Lotto(numbers.sorted())
    }
}