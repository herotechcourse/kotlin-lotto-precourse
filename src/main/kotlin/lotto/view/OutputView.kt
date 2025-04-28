package lotto.view

import lotto.Lotto
import lotto.WinningNumbers
import lotto.util.WinningStatistics
import java.util.Locale

class OutputView (private val lottoTickets: List<Lotto>, private val winningNumbers: WinningNumbers) {

    fun printStatistics() {

        val mapPrizeNumber = WinningStatistics.getMapPrize(lottoTickets, winningNumbers)
        val moneyPrizeEach = WinningStatistics.getMoneyEach(mapPrizeNumber)
        val moneyTotal = WinningStatistics.getTotalMoney(mapPrizeNumber)
        println("Winning Statistics\n" +
                "---")
        for ((prize, number) in moneyPrizeEach) {
            println("$prize – $number tickets")
        }
        val returnRate = WinningStatistics.getReturnRate(moneyTotal, lottoTickets.size)
        println("Total return rate is ${returnRate}.")
    }

}