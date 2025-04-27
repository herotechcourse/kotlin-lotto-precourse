package lotto

import lotto.utils.getValidatedInput
import lotto.domain.InputValidator
import lotto.messages.PromptMessages
import lotto.view.InputView
import lotto.view.OutputView

fun main() {

    val inputView = InputView()
    val validator = InputValidator()

    val purchaseAmount = getValidatedInput(
        prompt = PromptMessages.PURCHASE_AMOUNT.message,
        readInput = { inputView.readOneLine(it) },
        validate = { validator.validatePurchaseInput(it) }
    )

    val lottoMachine = LottoMachine(purchaseAmount)
    val outputView = OutputView(lottoMachine)

    outputView.printTicketCount()
    outputView.printLottoNumbers()

    val winningNumbers = getValidatedInput(
        prompt = PromptMessages.WINNING_NUMBERS.message,
        readInput = { inputView.readOneLine(it) },
        validate = { validator.validateWinningNumbers(it) }
    )

    val bonusNumber = getValidatedInput(
        prompt = PromptMessages.BONUS_NUMBER.message,
        readInput = { inputView.readOneLine(it) },
        validate = { validator.validateBonusNumber(it, winningNumbers) }
    )

    outputView.printWinningStatistics(winningNumbers, bonusNumber)
    outputView.printReturnRate()
}
