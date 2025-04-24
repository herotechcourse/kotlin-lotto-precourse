package lotto

import lotto.view.InputView

fun main() {
    val userInput = obtainUserInput()
    println(userInput.purchaseAmount)
    println(userInput.winningNumbers)
    println(userInput.bonusNumber)
}

fun obtainUserInput(): UserInput {
    val userInput = UserInput()
    InputView.promptPurchaseAmount(userInput)
    InputView.promptWinningNumbers(userInput)
    InputView.promptBonusNumber(userInput)
    return userInput
}

