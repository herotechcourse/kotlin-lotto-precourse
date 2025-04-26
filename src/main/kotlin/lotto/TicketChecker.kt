package lotto

data class TicketResults(
    var matchCount: Int = 0,
    var hasBonus: Boolean,
    var prize: Prize = Prize.NO_PRIZE,
)

class TicketChecker() {

    fun getPrize(lotto: Lotto, bonusNumber: Int, matchedNumbersQuantity: Int): Prize {
        val hasBonusNumber = bonusNumber in lotto.numbers

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
        val matchedNumbers = lotto.numbers.count { it in winningNumbers }
        val hasBonusNumber = bonusNumber in lotto.numbers

        val resultPrize = getPrize(lotto, bonusNumber, matchedNumbers)
        val oneTicketResult = TicketResults(matchedNumbers, hasBonusNumber, resultPrize)

        return oneTicketResult
    }

    fun checkMultipleTickets(lottoList: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): List<Prize> {
        val prizesList = lottoList.mapNotNull { lotto ->
            checkTicket(lotto, winningNumbers, bonusNumber).prize.takeIf { it != Prize.NO_PRIZE }
        }

        return prizesList
    }
}