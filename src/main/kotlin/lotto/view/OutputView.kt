package lotto.view

import lotto.Lotto
import lotto.WinningNumbers
import lotto.domain.WinningStatistics

class OutputView (private val lottoTickets: List<Lotto>, private val winningNumbers: WinningNumbers) {

    // Function give statistics about the numbers of each prize based on list of tickets
    fun printStatistics() {

        // Get map of prizes and numbers of prizes, total money from prizes
        val mapPrizeNumber = WinningStatistics.getMapPrize(lottoTickets, winningNumbers)
        val moneyPrizeEach = WinningStatistics.getMoneyEach(mapPrizeNumber)
        val moneyTotal = WinningStatistics.getTotalMoney(mapPrizeNumber)

        // Display the statistics
        println("Winning Statistics\n" +
                "---")
        for ((prize, number) in moneyPrizeEach) {
            println("$prize – $number tickets")
        }

        val returnRate = WinningStatistics.getReturnRate(moneyTotal, lottoTickets.size)
        println("Total return rate is ${returnRate}.")
    }
}