package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

object LottoMachine {
    private const val LOTTO_PRICE = 1000
    private const val MIN_NUMBER = 1
    private const val MAX_NUMBER = 45
    private const val NUMBERS_COUNT = 6

    fun generateTickets(amount: Int): List<Lotto> {
        validateAmount(amount)
        val ticketCount = amount / LOTTO_PRICE
        return List(ticketCount) { generateTicket() }
    }

    fun calculateResults(
            tickets: List<Lotto>,
            winningNumbers: Lotto,
            bonusNumber: Int
    ): LottoResult {
        val prizeCounts = mutableMapOf<Prize, Int>().withDefault { 0 }

        tickets.forEach { ticket ->
            val matchCount = ticket.matchCount(winningNumbers)
            val hasBonus = winningNumbers.contains(bonusNumber)

            Prize.determinePrize(matchCount, hasBonus)?.let { prize ->
                prizeCounts[prize] = prizeCounts.getValue(prize) + 1
            }
        }

        return LottoResult(prizeCounts)
    }

    private fun generateTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_COUNT)
        return Lotto(numbers)
    }

    private fun validateAmount(amount: Int) {
        require(amount >= LOTTO_PRICE) { "Purchase amount must be at least ${LOTTO_PRICE}." }
        require(amount % LOTTO_PRICE == 0) {
            "Purchase amount must be divisible by ${LOTTO_PRICE}."
        }
    }
}
