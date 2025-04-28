package lotto.domain

import lotto.Lotto
import lotto.WinningNumbers
import java.util.*


object WinningStatistics {

    // Create map between prizes and the number of prizes
    fun getMapPrize(tickets: List<Lotto>, winningNumbers: WinningNumbers): MutableMap<Lotto.Prize, Int> {

        val mapPrizeNumber = Lotto.Prize.entries.associateWith { 0 }.toMutableMap()
        for (ticket in tickets) {
            val prize = ticket.checkPrize(winningNumbers)
            mapPrizeNumber[prize] = (mapPrizeNumber[prize] ?: 0) + 1
        }

        return mapPrizeNumber
    }

    // Return map between string for each prize and the number of prizes
    fun getMoneyEach(mapPrizeNumber: MutableMap<Lotto.Prize, Int>): Map<String, Int> {

        val moneyPrizeALl = mutableMapOf<String, Int>()
        for ((prize, number) in mapPrizeNumber) {
            if (prize != Lotto.Prize.NOPRIZE) {
                moneyPrizeALl[prize.namePrize] = number
            }
        }

        return  moneyPrizeALl
    }

    // Return total money from prize map
    fun getTotalMoney(mapPrizeNumber: MutableMap<Lotto.Prize, Int>): Long {

        var totalMoney: Long = 0
        for ((prize, number) in mapPrizeNumber) totalMoney += prize.valuePrize.toLong() * number

        return totalMoney
    }
    // Calculate return rate
    fun getReturnRate(moneyTotal: Long, numberTickets: Long): String {

        val returnRate = moneyTotal.toDouble()/(numberTickets.toLong() * Lotto.PRICE_TICKET)
        val formattedRate = String.format(Locale.US,"%.1f%%", returnRate * 100)

        return formattedRate
    }
}
