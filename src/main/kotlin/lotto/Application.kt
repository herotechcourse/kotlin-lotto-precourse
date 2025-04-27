package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val inputView: LottoInputView = InputView()
    val outputView: LottoOutputView = OutputView()

    val purchaseService = PurchaseService(inputView, outputView)

    while (true) {
        try {
            val ticketCount = purchaseService.getTicketCount()
            val tickets = List(ticketCount) {
                Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
            }
            outputView.printTickets(tickets)
            break
        } catch (e: IllegalArgumentException) {
            outputView.showError(e.message ?: "An error occurred.")
        }
    }

    val winningNumberInput = WinningNumberInput(inputView)
    var winningNumbers: List<Int>

    // Loop for getting valid winning numbers
    while (true) {
        try {
            winningNumbers = winningNumberInput.getWinningNumbers()
            break
        } catch (e: IllegalArgumentException) {
            outputView.showError(e.message ?: "An error occurred.")
        }
    }

    // Loop for getting a valid bonus number
    while (true) {
        try {
            val bonusNumber = winningNumberInput.getBonusNumber(winningNumbers)
            println("Winning Numbers: $winningNumbers")
            println("Bonus Number: $bonusNumber")
            break
        } catch (e: IllegalArgumentException) {
            outputView.showError(e.message ?: "An error occurred.")
        }
    }
}