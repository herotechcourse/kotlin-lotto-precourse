package lotto

import lotto.NumberUtil.formatInt

data class LottoStatistic(private val prize: LottoPrize) {

    var ticketCount: Int = 0
        private set

    fun isMatch(matchCount: Int, hasBonus: Boolean) = prize.isMatch(matchCount, hasBonus)

    fun updateTicketCount() {
        ticketCount += 1
    }

    fun getPrizeAmount() = prize.amount * ticketCount

    override fun toString() =
        "${prize.matches} (${prize.amount.formatInt()} $CODE) – $ticketCount tickets"

    companion object {

        private const val CODE = "KRW"
    }
}
