package lotto

fun main() {
    val outputView = OutputView()
    val inputView = InputView(outputView)
    val validator = InputValidator()

    try {
        val amountInput = inputView.readPurchaseAmount()
        val amount = validator.validatePurchaseAmount(amountInput)
        outputView.ticketCount(amount / 1000)

        val winningNumbersInput = inputView.readWinningNumbers()
        val winningNumbers = validator.validateWinningNumbers(winningNumbersInput)

        val bonusNumberInput = inputView.readBonusNumber()
        val bonusNumber = validator.validateBonusNumber(bonusNumberInput, winningNumbers)

    } catch (e: IllegalArgumentException) {
        outputView.error(e.message ?: "An error occurred")
    }
}