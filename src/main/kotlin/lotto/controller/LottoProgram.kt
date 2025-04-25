package lotto.controller

import lotto.Lotto
import lotto.model.LottoIssuer
import lotto.model.LottoResult
import lotto.model.LottoStorage
import lotto.model.WinningLotto
import lotto.validator.InputValidator
import lotto.view.InputView
import lotto.view.OutputView

private const val MIN_PURCHASE_RANGE = 1000
private const val MAX_PURCHASE_RANGE = 100000

class LottoProgram {
    fun run() {
        val purchaseAmount = readValidPurchaseAmount()
        val lottoCount = purchaseAmount / 1000
        OutputView.newline()

        OutputView.purchaseCount(lottoCount)
        val lottery = LottoIssuer.execute(lottoCount)
        val lottoStorage = LottoStorage(lottery)
        OutputView.purchaseLottery(lottoStorage.getAll())

        OutputView.newline()

        val winningLotto = readWinningLotto()
        OutputView.newline()

        val lottoResult = LottoResult(lottoStorage, winningLotto)
        OutputView.message("Winning Statistics\n---")
        OutputView.lottoStatistics(lottoResult)
        OutputView.profitRate(lottoResult.calculateProfitRate(purchaseAmount))
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
}

fun validateBonusNumber(input: String) {
    InputValidator.notEmpty(input)
    InputValidator.isNumeric(input)
}

fun readWinningLotto(): WinningLotto {
    val winningLotto = readValidLotto()
    OutputView.newline()
    val finalWinningLotto = readValidBonusNumber(winningLotto)
    return finalWinningLotto
}

fun readValidPurchaseAmount(): Int {
    while (true) {
        try {
            val input = InputView.promptAndReadLine("Please enter the purchase amount.")
            validatePurchaseAmount(input)
            return input.toInt()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun readValidLotto(): Lotto {
    while (true) {
        try {
            val input = InputView.promptAndReadLine("Please enter last week's winning numbers.")
            validateWinningNumbers(input)
            val numbers = input.split(",").map { it.trim().toInt() }
            return Lotto(numbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun readValidBonusNumber(mainLotto: Lotto): WinningLotto {
    while (true) {
        try {
            val input = InputView.promptAndReadLine("Please enter the bonus number.")
            validateBonusNumber(input)
            val bonusNumber = input.toInt()
            return WinningLotto(mainLotto, bonusNumber)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}