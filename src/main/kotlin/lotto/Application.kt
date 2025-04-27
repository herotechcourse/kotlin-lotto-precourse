package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val inputView: LottoInputView = InputView()
    val outputView: LottoOutputView = OutputView()

    val purchaseService = PurchaseService(inputView, outputView)

    // Step 1: Ticket Purchase
    var tickets: List<Lotto> // Changed to var
    while (true) {
        try {
            val ticketCount = purchaseService.getTicketCount()
            tickets = List(ticketCount) {
                Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
            }
            outputView.printTickets(tickets)
            break
        } catch (e: IllegalArgumentException) {
            outputView.showError(e.message ?: "An error occurred.")
        }
    }

    // Step 2: Winning Numbers Input
    val winningNumberInput = WinningNumberInput(inputView)
    var winningNumbers: List<Int> // Changed to var
    while (true) {
        try {
            winningNumbers = winningNumberInput.getWinningNumbers()
            break
        } catch (e: IllegalArgumentException) {
            outputView.showError(e.message ?: "An error occurred.")
        }
    }

    var bonusNumber: Int // Changed to var
    while (true) {
        try {
            bonusNumber = winningNumberInput.getBonusNumber(winningNumbers)
            break
        } catch (e: IllegalArgumentException) {
            outputView.showError(e.message ?: "An error occurred.")
        }
    }

    // Step 3: Result Evaluation
    val evaluator = ResultEvaluator(winningNumbers.toSet(), bonusNumber)
    val result = evaluator.evaluate(tickets)

    // Step 4: Display Results
    result.displayStatistics(purchaseService.getPurchaseAmount())
}