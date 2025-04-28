package lotto.view

import lotto.service.InputValidator
import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        while (true) {
            try {
                OutputView.promptPurchaseAmount()
                return readAndValidatePurchaseAmount()
            } catch (e: IllegalArgumentException) {
                OutputView.printError("${e.message}")
            }
        }
    }

    fun readWinningNumbers(): List<Int> {
        while (true) {
            try {
                OutputView.promptWinningNumbers()
                return readAndValidateWinningNumbers()
            } catch (e: IllegalArgumentException) {
                OutputView.printError("${e.message}")
            }
        }
    }

    fun readBonusNumber(): Int {
        while (true) {
            try {
                OutputView.promptBonusNumber()
                return readAndValidateBonusNumber()
            } catch (e: IllegalArgumentException) {
                OutputView.printError("${e.message}")
            }
        }
    }

    private fun readAndValidatePurchaseAmount(): Int {
        val input = Console.readLine()
        InputValidator.validatePurchaseAmount(input)
        return input.toInt()
    }

    private fun readAndValidateWinningNumbers(): List<Int> {
        val input = Console.readLine()
        InputValidator.validateWinningNumbers(input)
        return input.split(",").map { it.trim().toInt() }
    }

    private fun readAndValidateBonusNumber(): Int {
        val input = Console.readLine()
        InputValidator.validateBonusNumber(input)
        return input.toInt()
    }
}