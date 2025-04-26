package lotto

fun main() {
    val outputView = OutputView()
    val inputView = InputView(outputView)
    val validator = InputValidator()
    val lottoMachine = LottoMachine()
    val evaluator = LottoEvaluator()

    val amount = inputView.validateWithReprompt(
        readAction = InputView::readPurchaseAmount,
        validation = validator::validatePurchaseAmount,
        outputView = outputView
    )

    val count = amount / 1000
    val generation = lottoMachine.generateTickets(count)

    outputView.ticketAmount(count)
    outputView.tickets(generation)

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

    val results = evaluator.compareTickets(generation, winningNumbers, bonusNumber)

    outputView.displayWinningStats(results)

}