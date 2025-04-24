package lotto.controller

import lotto.model.LottoIssuer
import lotto.model.LottoStorage
import lotto.validator.InputValidator
import lotto.view.InputView
import lotto.view.OutputView

private const val MIN_PURCHASE_RANGE = 1000
private const val MAX_PURCHASE_RANGE = 100000

class LottoProgram {
    fun run() {
        val purchaseAmountInput: String = InputView.promptAndReadLine("Please enter the purchase amount.")
        validatePurchaseAmount(purchaseAmountInput)

        println("")
        val purchaseAmount = purchaseAmountInput.toInt()
        val lottoCount = purchaseAmount / 1000

        println("You have purchased $lottoCount tickets.")
        val lottery = LottoIssuer.execute(lottoCount)
        val lottoStorage = LottoStorage(lottery)

        OutputView.printLottery(lottoStorage.getAll())
        println("")


        val winningNumbersInput: String = InputView.promptAndReadLine("Please enter last week's winning numbers.")
        validateWinningNumbers(winningNumbersInput)
    }
}

fun validatePurchaseAmount(input: String) {
    InputValidator.notEmpty(input)
    InputValidator.isNumeric(input)

    val purchaseAmount = input.toInt()
    InputValidator.withinRange(purchaseAmount, MIN_PURCHASE_RANGE, MAX_PURCHASE_RANGE)
    InputValidator.isMultipleOfThousand(purchaseAmount)
}

fun validateWinningNumbers(input: String) {
    InputValidator.notEmpty(input)
    val numbers = input.split(",").map { it.trim() }
    InputValidator.allAreNumbers(numbers)
    InputValidator.numberCountIsSix(numbers)
    InputValidator.allNumbersInRange(numbers)
    InputValidator.noDuplicateNumbers(numbers)
}