package lotto

import lotto.view.InputView
import lotto.utils.StringToNumber
import lotto.validator.BudgetValidator
import lotto.view.OutputView
import lotto.services.Lottery

fun main() {
    val application = Application()
    application.run()
}

class Application {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottery = Lottery()

    fun run() {
        val budget = readBudget()
        val ticketCount = calculateTicketCount(budget)
        val tickets = issueTickets(ticketCount)

        outputView.purchasedTicket(ticketCount)
        outputView.ticketNumber(tickets)
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

}