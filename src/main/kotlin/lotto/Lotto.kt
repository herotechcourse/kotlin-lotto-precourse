package lotto

import lotto.LottoPrize.*

class Lotto(private val numbers: List<Int>) : LottoValidator {

    init {
        validateNumbers(numbers)
    }

    fun simulate(issuedTickets: List<List<Int>>, bonusNumber: Int) {
        issuedTickets.forEach {
            updateTicketCount(it, bonusNumber)
        }
    }

    fun getProfitRate(purchaseAmount: Int): Double {
        val totalPrizeAmount = LottoPrize.getTotalPrizeAmount().toDouble()
        return (totalPrizeAmount / purchaseAmount) * PERCENTAGE
    }

    private fun updateTicketCount(issuedTicket: List<Int>, bonusNumber: Int) {
        val matchCount = getMatchCount(issuedTicket)
        val hasBonus = hasBonus(issuedTicket, bonusNumber)
        when {
            matchCount == SIX_MATCHES.value -> SIX_MATCHES.updateTicketCount()
            matchCount == FIVE_MATCHES_BONUS.value && hasBonus -> FIVE_MATCHES_BONUS.updateTicketCount()
            matchCount == FIVE_MATCHES.value -> FIVE_MATCHES.updateTicketCount()
            matchCount == FOUR_MATCHES.value -> FOUR_MATCHES.updateTicketCount()
            matchCount == THREE_MATCHES.value -> THREE_MATCHES.updateTicketCount()
        }
    }

    private fun getMatchCount(issuedTicket: List<Int>) = numbers.count { it in issuedTicket }

    private fun hasBonus(issuedTicket: List<Int>, bonusNumber: Int) = bonusNumber in issuedTicket

    companion object {
        private const val PERCENTAGE = 100
    }
}
