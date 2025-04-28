package lotto.util

import lotto.support.TICKET_PRICE
import lotto.domain.PrizeResult
import lotto.Lotto

fun calculateAndFormatReturnRate(prize: PrizeResult, tickets: List<Lotto>): String {
    val returnRate = calcReturnRate(prize.totalPrize, tickets.size * TICKET_PRICE)
    return roundRateToString(returnRate)
}
