package lotto.domain

import lotto.Lotto

class LottoResult(
    val ticket: Lotto,
    val prizeRank: PrizeRank,
    val matchedNumbers: List<Int>,
    val bonusNumber: Boolean
) {
    /**
     * Represents the result of matching a lottery ticket against winning numbers.
     * Contains information about the ticket, its prize rank, matched numbers, and bonus match status.
     */
    fun totalPrizeMoney(): Int = prizeRank.prize

    override fun toString(): String {
        val bonusText = if (bonusNumber && prizeRank != PrizeRank.NONE) "+ Bonus" else ""
        return "Ticket $ticket -> Match: ${matchedNumbers.size} $bonusText, Prize: ${prizeRank.prize} KRW"
    }
}