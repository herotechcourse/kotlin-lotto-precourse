package lotto.controller

import lotto.Lotto
import lotto.domain.LottoMachine
import lotto.domain.LottoResult
import lotto.domain.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val lottoMachine: LottoMachine
) {
    fun run() {
        val tickets = purchaseTickets()
        outputView.printTickets(tickets)
        
        val winningNumbers = getWinningNumbers()
        val result = LottoResult(tickets, winningNumbers)
        
        outputView.printResult(result)
    }

    private fun purchaseTickets(): List<Lotto> {
        return try {
            val amount = inputView.readPurchaseAmount()
            lottoMachine.generateTickets(amount)
        } catch (e: IllegalArgumentException) {
            outputView.printError(e.message ?: "[ERROR] An unexpected error occurred.")
            purchaseTickets()
        }
    }

    private fun getWinningNumbers(): WinningNumbers {
        return try {
            val numbers = inputView.readWinningNumbers()
            val bonusNumber = inputView.readBonusNumber()
            WinningNumbers(numbers, bonusNumber)
        } catch (e: IllegalArgumentException) {
            outputView.printError(e.message ?: "[ERROR] An unexpected error occurred.")
            getWinningNumbers()
        }
    }
}
