package lotto

fun main() {
    val outputView = OutputView()
    val inputView = InputView(outputView)
    val validator = InputValidator()

    val amount = inputView.validateWithReprompt(
        readAction = InputView::readPurchaseAmount,
        validation = validator::validatePurchaseAmount,
        outputView = outputView
    )
    outputView.ticketCount(amount / 1000)

    val winningNumbers = inputView.validateWithReprompt(
        readAction = InputView::readWinningNumbers,
        validation = validator::validateWinningNumbers,
        outputView = outputView
    )

    val bonusNumber = inputView.validateWithReprompt(
        readAction = InputView::readBonusNumber,
        validation = { input -> validator.validateBonusNumber(input, winningNumbers) },
        outputView = outputView
    )
}