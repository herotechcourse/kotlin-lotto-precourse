package lotto.util

import lotto.Lotto
import lotto.WinningNumbers
import java.util.*


object WinningStatistics {

    fun getMapPrize(tickets: List<Lotto>, winningNumbers: WinningNumbers): MutableMap<Lotto.Prize, Int> {
        val mapPrizeNumber = Lotto.Prize.entries.associateWith { 0 }.toMutableMap()
        for (ticket in tickets) {
            val prize = ticket.checkPrize(winningNumbers)
            mapPrizeNumber[prize] = (mapPrizeNumber[prize] ?: 0) + 1
        }
        return mapPrizeNumber
    }

    fun getMoneyEach(mapPrizeNumber: MutableMap<Lotto.Prize, Int>): Map<String, Int> {
        val moneyPrizeALl = mutableMapOf<String, Int>()
        for ((prize, number) in mapPrizeNumber) {
            if (prize != Lotto.Prize.NOPRIZE) {
                moneyPrizeALl[prize.namePrize] = number
            }
        }
        return  moneyPrizeALl
    }

    fun getTotalMoney(mapPrizeNumber: MutableMap<Lotto.Prize, Int>): Long {
        var totalMoney: Long = 0
        for ((prize, number) in mapPrizeNumber) totalMoney += prize.valuePrize.toLong() * number
        return totalMoney
    }

    fun getReturnRate(moneyTotal: Long, numberTickets: Int): String {
        val returnRate = moneyTotal.toDouble()/(numberTickets * Lotto.PRICE_TICKET)
        val formattedRate = String.format(Locale.US,"%.1f%%", returnRate * 100)
        return formattedRate
    }
}
