/**
 * output view
 */

package lotto

class OutputView {
    companion object {
        fun printTickets(tickets: LottoTickets) {
            println()
            println("You have purchased ${tickets.numberOfTickets} tickets.")
            tickets.toStrings().map { println(it) }
            println()
        }

        fun printStatistics(tickets: LottoTickets, winningNumbers: List<Int>, bonusNumbers: List<Int>) {
            val prizes = tickets.prizes(winningNumbers, bonusNumbers)

            println()
            println("Winning Statistics")
            println("---")
            prizes.descriptions().map { println(it) }
            println("Total return rate is ${"%.1f".format(prizes.total() / tickets.amount.toDouble() * 100)}%.")
        }
    }
}
