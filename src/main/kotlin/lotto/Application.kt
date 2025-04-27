package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    try {
        println("Please enter the purchase amount.")
        val amount = InputHandler().getPurchaseAmount()

        val ticketCount = amount / 1000
        println("\nYou have purchased $ticketCount tickets.")

        val tickets = LottoMachine().generateTickets(ticketCount)
        tickets.forEach { println(it.getNumbers().joinToString(", ", "[", "]")) }

        println("\nPlease enter the winning numbers (comma-separated):")
        val winningNumbers = InputHandler().getWinningNumbers()

        println("\nPlease enter the bonus number:")
        val bonusNumber = InputHandler().getBonusNumber(winningNumbers)

        val statistics = PrizeCalculator(winningNumbers, bonusNumber).calculateResults(tickets)
        OutputHandler().printStatistics(statistics)
    } catch (e: IllegalArgumentException) {
        println("[ERROR] ${e.message}")
    }
}
