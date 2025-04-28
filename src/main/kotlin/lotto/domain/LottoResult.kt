package lotto.domain

import lotto.Lotto

class LottoResult(
    val ticket: Lotto,
    val prizeRank: PrizeRank,
    val matchedNumbers: List<Int>,
    val bonusNumber: Boolean
) {
    fun totalPrizeMoney() = prizeRank.prize

    override fun toString(): String {
        return "Ticket ${ticket.getNumbers()} -> Match: ${matchedNumbers.size} (${if (bonusNumber) "+ Bonus" else ""}), Prize: ${prizeRank.prize} KRW"
    }
}