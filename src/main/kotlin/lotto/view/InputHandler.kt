package lotto.view

import lotto.Lotto
import lotto.constants.Constants
import lotto.constants.Messages
import lotto.model.WinningLotto
import lotto.validator.ValidationBundle

object InputHandler {
    private fun <T> readWithValidation(
        promptMessage: String,
        validation: (String) -> Unit,
        transform: (String) -> T
    ): T {
        while (true) {
            try {
                val input = InputView.promptAndReadLine(promptMessage)
                validation(input)
                return transform(input)
            } catch (e: IllegalArgumentException) {
                OutputView.error(e.message)
            }
        }
    }

    fun readValidPurchaseAmount(): Int {
        return readWithValidation(
            Messages.Prompt.PURCHASE_AMOUNT,
            { ValidationBundle.purchaseAmount(it) },
            { it.toInt() }
        )
    }

    private fun readValidLotto(): Lotto {
        return readWithValidation(
            Messages.Prompt.WINNING_NUMBERS,
            { ValidationBundle.winningNumbers(it) },
            { input ->
                val numbers = input.split(Constants.SEPARATOR).map { it.trim().toInt() }
                Lotto(numbers)
            }
        )
    }

    private fun readValidBonusNumber(mainLotto: Lotto): WinningLotto {
        return readWithValidation(
            Messages.Prompt.BONUS_NUMBER,
            { ValidationBundle.bonusNumber(it) },
            { input -> WinningLotto(mainLotto, input.toInt()) }
        )
    }

    fun readWinningLotto(): WinningLotto {
        val winningLotto = readValidLotto()
        OutputView.newline()
        val finalWinningLotto = readValidBonusNumber(winningLotto)
        return finalWinningLotto
    }
}