package lotto

fun main() {
    val amount = repeatUntilValid { InputView.readPurchaseAmount() }

    val ticketCount = amount / 1000
    val tickets = LottoService.generateTickets(ticketCount)

    OutputView.printTickets(tickets)

    val numbers = repeatUntilValid { InputView.readWinningNumbers() }
    val bonus = repeatUntilValid { InputView.readBonusNumber() }
    val result = LottoService.calculateLottoResult(tickets, numbers, bonus)
    OutputView.printResult(result)
}

fun <T> repeatUntilValid(action: () -> T): T {
    while (true) {
        try {
            return action()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        } catch (e: IllegalStateException) {
            println(e.message)
        }
    }
}