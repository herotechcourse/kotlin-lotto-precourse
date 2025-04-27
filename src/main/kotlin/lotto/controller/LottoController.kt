package lotto.controller

import lotto.presentation.InputView
import lotto.presentation.OutputView
import lotto.utils.InputValidator
import lotto.utils.LottoTicketGenerator

class LottoController(
    private val inputValidator: InputValidator,
    private val inputView: InputView,
    private val outputView: OutputView,
    private val lottoTicketGenerator: LottoTicketGenerator,
) {
    private fun processPurchaseAmount(): Int {
        val input = inputView.promptInputForPurchaseAmount()
        return try {
            inputValidator.validateInput(input)
        } catch (e: IllegalArgumentException) {
            outputView.printErrorMessage(e.message)
            processPurchaseAmount()
        }
    }

    fun run() {
        val purchaseAmount = processPurchaseAmount()
        val numberOfTickets = lottoTicketGenerator.generateNumberOfTickets(purchaseAmount)
        //println(numberOfTickets)
        val tickets = lottoTicketGenerator.generateTickets(numberOfTickets)
        //println(tickets)
    }
}