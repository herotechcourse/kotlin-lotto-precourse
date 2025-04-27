package lotto

import java.util.Locale

class OutputView (private val lottoTickets: List<Lotto>, private val winningNumbers: WinningNumbers) {

    fun printOutput(){
        printLottoTickets()
        printStatistics()

    }
    private fun printStatistics() {

        val mapPrizeNumber = WinningStatistics.getMapPrize(lottoTickets,winningNumbers)
        val moneyPrizeEach = WinningStatistics.getMoneyEach(mapPrizeNumber)
        val moneyTotal = WinningStatistics.getTotalMoney(mapPrizeNumber)
        println("Winning Statistics\n" +
                "---")
        for ((prize, number) in moneyPrizeEach) {
            println("${prize} – $number tickets")
        }
        val returnRate: Double =  moneyTotal.toDouble()/(lottoTickets.size * 1000)
        val formattedRate = String.format(Locale.US,"%.1f%%", returnRate * 100)
        println("Total return rate is ${formattedRate}.")
    }

    private fun printLottoTickets() {
        println("You have purchased ${lottoTickets.size} tickets.")
        for (ticket in lottoTickets) {
        println(ticket.getTicket())
        }
    }

}