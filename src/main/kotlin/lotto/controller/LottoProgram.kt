package lotto.controller

import lotto.Lotto
import lotto.model.*
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

        val winningLotto = readWinningLotto()
        println("Winning Statistics\n---")
        val lottoResult = LottoResult(lottoStorage, winningLotto)

        println("3 Matches (5,000 KRW) – ${lottoResult.getCount(LottoRank.FIFTH)} tickets")
        println("4 Matches (50,000 KRW) – ${lottoResult.getCount(LottoRank.FOURTH)} tickets")
        println("5 Matches (1,500,000 KRW) – ${lottoResult.getCount(LottoRank.THIRD)} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${lottoResult.getCount(LottoRank.SECOND)} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${lottoResult.getCount(LottoRank.FIRST)} tickets")
        println("Total return rate is ${lottoResult.calculateProfitRate(purchaseAmount)}%")
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
    val finalWinningLotto = readValidBonusNumber(winningLotto)
    return finalWinningLotto
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