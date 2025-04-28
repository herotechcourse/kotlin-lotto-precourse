package lotto.controller

import lotto.domain.LottoTickets
import lotto.domain.Money
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun run() {
        val money = readPurchaseAmount()
        val tickets = LottoTickets.generate(money)

        OutputView.printPurchaseCount(money.getNumberOfTickets())
        OutputView.printLottoTickets(tickets.getTickets())
    }

    private fun readPurchaseAmount(): Money {
        while (true) {
            try {
                val input = InputView.readPurchaseAmount()
                val amount = input.toInt()
                return Money(amount)
            } catch (e: NumberFormatException) {
                println("[ERROR] Input must be a number.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}