package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class TicketIssuer {
    private fun createRandomNumbers(count: Int = Lotto.NUMBER_COUNT): List<Int> {
        return Randoms.pickUniqueNumbersInRange(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER, count)
    }

    fun issue(count: Int): List<Lotto> {
        require(count > 0) { "Ticket count must be greater than 0." }

        val tickets: MutableList<Lotto> = mutableListOf()

        repeat(count) {
            val lottoNumbers = createRandomNumbers()
            tickets.add(Lotto.from(lottoNumbers))
        }

        return tickets
    }
}
