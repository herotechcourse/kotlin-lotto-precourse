package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object LottoMachine {
    private const val LOTTO_PRICE = 1000
    private const val MIN_NUMBER = 1
    private const val MAX_NUMBER = 45
    private const val NUMBERS_COUNT = 6

    fun generateTickets(amount: Int): List<Lotto> {
        validateAmount(amount)
        return List(amount / LOTTO_PRICE) { generateTicket() }
    }

    fun calculateResults(
        tickets: List<Lotto>,
        winningNumbers: Lotto,
        bonusNumber: Int
    ): LottoResult {
        val prizeCounts = tickets.groupingBy {
            val matchCount = it.matchCount(winningNumbers)
            val hasBonus = it.contains(bonusNumber)
            Prize.determinePrize(matchCount, hasBonus)
        }.eachCount().filterKeys { it != null }.mapKeys { it.key!! }

        return LottoResult(prizeCounts)
    }

    private fun generateTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_COUNT)
        return Lotto(numbers)
    }

    private fun validateAmount(amount: Int) {
        require(amount >= LOTTO_PRICE) { "Purchase amount must be at least $LOTTO_PRICE." }
        require(amount % LOTTO_PRICE == 0) {
            "Purchase amount must be divisible by $LOTTO_PRICE."
        }
    }
}
