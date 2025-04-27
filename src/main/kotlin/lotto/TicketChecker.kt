package lotto

data class TicketResults(
    var matchCount: Int = 0,
    var hasBonus: Boolean,
    var prize: Prize = Prize.NO_PRIZE,
)

class TicketChecker() {

    fun getPrize(hasBonusNumber: Boolean, matchedNumbersQuantity: Int): Prize {
        val prize = when (matchedNumbersQuantity) {
            3 -> Prize.FIFTH
            4 -> Prize.FOURTH
            5 -> if (hasBonusNumber) Prize.SECOND else Prize.THIRD
            6 -> Prize.FIRST
            else -> Prize.NO_PRIZE
        }

        return prize
    }

    fun checkTicket(lotto: Lotto, winningNumbers: List<Int>, bonusNumber: Int): TicketResults {
        val matchedNumbersQuantity = lotto.numbers.count { it in winningNumbers }
        val hasBonusNumber = bonusNumber in lotto.numbers

        val resultPrize = getPrize(hasBonusNumber, matchedNumbersQuantity)
        val oneTicketResult = TicketResults(matchedNumbersQuantity, hasBonusNumber, resultPrize)

        return oneTicketResult
    }

    fun calculateTicketsResults(
        lottoList: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): List<TicketResults> {
        val allResults = lottoList.map { lotto -> checkTicket(lotto, winningNumbers, bonusNumber) }
        val winningResults: List<TicketResults> =
            allResults.filter { it.prize != Prize.NO_PRIZE }.sortedByDescending { it.prize }

        return winningResults
    }
}