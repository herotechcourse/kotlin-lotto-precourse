package lotto

import lotto.view.InputView
import lotto.utils.StringToNumber
import lotto.validator.BudgetValidator
import lotto.view.OutputView
import lotto.services.Lottery

fun main() {
    val inputView = InputView()


    val budgetInput = inputView.GetBudget()
    val budgetorNull = StringToNumber(budgetInput)
    val budget = BudgetValidator().run(budgetorNull)
    val ticketCount = Lottery().getLotteryCount(budget)

    val outputView = OutputView()
    outputView.purchasedTicket(ticketCount)

    val tickets = Lottery().run(ticketCount)
    outputView.ticketNumber(tickets)
}
