package lotto.controller

import lotto.Lotto
import lotto.constants.Constants
import lotto.model.LottoIssuer
import lotto.model.LottoResult
import lotto.model.LottoStorage
import lotto.model.WinningLotto
import lotto.validator.InputValidator
import lotto.view.InputView
import lotto.view.OutputView

class LottoProgram {
    fun run() {
        val purchaseAmount = readValidPurchaseAmount()
        val lottoStorage = issueLottery(purchaseAmount)
        val winningLotto = readWinningLotto()

        val lottoResult = LottoResult(lottoStorage, winningLotto)
        printStatistics(lottoResult, purchaseAmount)
    }
}

fun validatePurchaseAmount(input: String) {
    InputValidator.notEmpty(input)
    InputValidator.isNumeric(input)

    val purchaseAmount = input.toInt()
    InputValidator.withinRange(purchaseAmount)
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

fun issueLottery(purchaseAmount: Int): LottoStorage {
    val lottoCount = purchaseAmount / Constants.LOTTO_PURCHASE_UNIT
    OutputView.newline()
    OutputView.purchaseCount(lottoCount)

    val lottery = LottoIssuer.execute(lottoCount)
    val lottoStorage = LottoStorage(lottery)

    OutputView.purchaseLottery(lottoStorage.getAll())
    OutputView.newline()
    return lottoStorage
}

fun printStatistics(result: LottoResult, purchaseAmount: Int) {
    OutputView.newline()
    OutputView.message("Winning Statistics\n---")
    OutputView.lottoStatistics(result)
    OutputView.profitRate(result.calculateProfitRate(purchaseAmount))
}