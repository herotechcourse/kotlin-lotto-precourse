package lotto.controller

import lotto.Lotto
import lotto.constants.Constants
import lotto.constants.Messages
import lotto.model.LottoIssuer
import lotto.model.LottoResult
import lotto.model.LottoStorage
import lotto.model.WinningLotto
import lotto.validator.ValidationBundle
import lotto.view.InputView
import lotto.view.OutputView

class LottoProgram {
    fun run() {
        val purchaseAmount = readValidPurchaseAmount()
        val lottoStorage = issueLottery(purchaseAmount)
        val winningLotto = readWinningLotto()

        val lottoResult = LottoResult(lottoStorage, winningLotto)
        OutputView.winningStatistics(lottoResult, purchaseAmount)
    }
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
            val input = InputView.promptAndReadLine(Messages.Prompt.PURCHASE_AMOUNT)
            ValidationBundle.purchaseAmount(input)
            return input.toInt()
        } catch (e: IllegalArgumentException) {
            OutputView.error(e.message)
        }
    }
}

fun readValidLotto(): Lotto {
    while (true) {
        try {
            val input = InputView.promptAndReadLine(Messages.Prompt.WINNING_NUMBERS)
            ValidationBundle.winningNumbers(input)
            val numbers = input.split(Constants.SEPARATOR).map { it.trim().toInt() }
            return Lotto(numbers)
        } catch (e: IllegalArgumentException) {
            OutputView.error(e.message)
        }
    }
}

fun readValidBonusNumber(mainLotto: Lotto): WinningLotto {
    while (true) {
        try {
            val input = InputView.promptAndReadLine(Messages.Prompt.BONUS_NUMBER)
            ValidationBundle.bonusNumber(input)
            val bonusNumber = input.toInt()
            return WinningLotto(mainLotto, bonusNumber)
        } catch (e: IllegalArgumentException) {
            OutputView.error(e.message)
        }
    }
}

fun issueLottery(purchaseAmount: Int): LottoStorage {
    val lottoCount = purchaseAmount / Constants.LOTTO_PURCHASE_UNIT
    OutputView.purchaseCount(lottoCount)

    val lottery = LottoIssuer.execute(lottoCount)
    val lottoStorage = LottoStorage(lottery)

    OutputView.purchaseLottery(lottoStorage.getAll())
    return lottoStorage
}