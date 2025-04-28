package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val inputView: LottoInputView = InputView()
    val outputView: LottoOutputView = OutputView()

    val purchaseService = PurchaseService(inputView, outputView)

    // Step 1: Ticket Purchase
    var tickets: List<Lotto>
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
    var winningNumbers: List<Int>
    while (true) {
        try {
            val input = inputView.getWinningNumbersInput()
            winningNumbers = Lotto.getWinningNumbers(input)
            break
        } catch (e: IllegalArgumentException) {
            outputView.showError(e.message ?: "An error occurred.")
        }
    }

    // Step 3: Bonus Number Input
    var bonusNumber: Int
    while (true) {
        try {
            val input = inputView.getBonusNumberInput()
            bonusNumber = Lotto.getBonusNumber(input, winningNumbers)
            break
        } catch (e: IllegalArgumentException) {
            outputView.showError(e.message ?: "An error occurred.")
        }
    }

    // Step 4: Result Evaluation
    val result = Lotto.evaluateResults(tickets, winningNumbers.toSet(), bonusNumber)

    // Step 5: Display Results
    result.displayStatistics(purchaseService.getPurchaseAmount())
}