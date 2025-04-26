package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: Implement the program
    val amountPurchase = promptUntilValid{InputView.getPurchaseAmount()}
    val tickets = LottoEngine.buyTickets(amountPurchase)

    OutputView.displayLottoTickets(tickets)

    val winningNumbers = promptUntilValid{InputView.getWinningNumbers()}
    val bonusNumber = promptUntilValid{InputView.getBonusNumber(winningNumbers)}

    val results = LottoEngine.evaluateTicketResults(tickets, winningNumbers, bonusNumber)
    val totalWinnings = LottoEngine.totalResultWinnings(results)

    OutputView.displayLottoResults(results, amountPurchase, totalWinnings)

}

private inline fun <T> promptUntilValid(block: () -> T): T {
    while (true) {
        try {
            return block()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        } catch (e: IllegalStateException) {
            println(e.message)
        }
    }
}
