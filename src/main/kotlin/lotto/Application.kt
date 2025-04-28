package lotto

import lotto.view.InputView
import lotto.utils.StringToNumber
import lotto.validator.BudgetValidator

fun main() {
    val inputView = InputView()
    val budgetInput = inputView.GetBudget()
    val budget = StringToNumber(budgetInput)

    BudgetValidator().run(budget)
}
