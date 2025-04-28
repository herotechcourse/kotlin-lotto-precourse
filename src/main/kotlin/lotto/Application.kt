package lotto

import WinningNumberValidator
import lotto.view.InputView
import lotto.utils.StringToNumber
import lotto.utils.StringToList
import lotto.validator.BudgetValidator
import lotto.view.OutputView
import lotto.services.GenerateTickets

fun main() {
    val application = Application()
    application.run()
}

class Application {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottery = GenerateTickets()

    fun run() {
        val budget = readBudget()
        val ticketCount = calculateTicketCount(budget)
        val tickets = issueTickets(ticketCount)

        outputView.purchasedTicket(ticketCount)
        outputView.ticketNumber(tickets)

        val (winningNumber, bonus) = readWinningNumbers()
    }

    private fun readBudget(): Int {
        val budgetInput = inputView.getBudget()
        val budgetOrNull = StringToNumber(budgetInput)
        return BudgetValidator().run(budgetOrNull)
    }

    private fun calculateTicketCount(budget: Int): Int {
        return lottery.getLotteryCount(budget)
    }

    private fun issueTickets(ticketCount: Int): List<List<Int>> {
        return lottery.run(ticketCount)
    }

    private fun readWinningNumbers(): Pair<Set<Int>, Int>{
        val winningValidator = WinningNumberValidator()

        val winningNumbersInput = inputView.getWinnings()
        val bonusInput = inputView.getBonusNumber()

        val winningNumberList = StringToList(winningNumbersInput)
        val bonusNumber = StringToNumber(bonusInput)

        val winningNumbers = winningValidator.run(winningNumberList)
        val bonus = winningValidator.getBonus(bonusNumber)

        return Pair(winningNumbers, bonus)
    }

}