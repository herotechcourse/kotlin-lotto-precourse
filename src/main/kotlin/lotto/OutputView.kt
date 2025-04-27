package lotto

import java.util.Locale

class OutputView (val tickets: List<Lotto>, val winningNumbers: WinningNumbers) {

    fun printOutput() {

        val winningStatistics = WinningStatistics(tickets, winningNumbers)
        winningStatistics.getMapPrize()
        val moneyPrizeEach = winningStatistics.getMoneyEach()
        val moneyTotal = winningStatistics.getTotalMoney()
        println("Winning Statistics\n" +
                "---")
        for ((prize, number) in moneyPrizeEach) {
            println("${prize} – $number tickets")
        }
        val returnRate: Double =  moneyTotal.toDouble()/(tickets.size * 1000)
        val formattedRate = String.format(Locale.US,"%.1f%%", returnRate * 100)
        println("Total return rate is ${formattedRate}.")
    }

}