package lotto

import java.util.Locale

class OutputView (private val tickets: List<Lotto>, private val winningNumbers: WinningNumbers) {

    fun printOutput(){
        printLottoTickets()
        printStatistics()

    }
    private fun printStatistics() {

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

    private fun printLottoTickets() {
        println("You have purchased $numberTickets tickets.")
        for (ticket in tickets) {
        println(ticket.getTicket())
        }
    }

}