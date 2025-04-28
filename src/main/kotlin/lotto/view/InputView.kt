package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        while (true) {
            try {
                OutputView.promptPurchaseAmount()
                val input = Console.readLine()
                InputValidator.validatePurchaseAmount(input)
                return input.toInt()
            } catch (e: IllegalArgumentException) {
                OutputView.printError("${e.message}")
            }
        }
    }

    fun readWinningNumbers(): List<Int> {
        while (true) {
            try {
                OutputView.promptWinningNumbers()
                val input = Console.readLine()
                InputValidator.validateWinningNumbers(input)
                return input.split(",")
                    .map { it.trim().toInt() }
            } catch (e: IllegalArgumentException) {
                OutputView.printError("${e.message}")
            }
        }
    }

    fun readBonusNumber(): Int {
        while (true) {
            try {
                OutputView.promptBonusNumber()
                val input = Console.readLine()
                InputValidator.validateBonusNumber(input)
                return input.toInt()
            } catch (e: IllegalArgumentException) {
                OutputView.printError("${e.message}")
            }
        }
    }
}