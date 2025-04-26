package lotto.controller

import lotto.Lotto
import lotto.model.WinningNumbers
import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val lottoService: LottoService = LottoService()
) {
    fun run() {
        val lottoTickets = getValidLottoTickets()
        val winningNumbers = getValidWinningNumbers()
        val matchResult = lottoService.determineWinningResults(lottoTickets, winningNumbers)
        OutputView.printWinningStatistics(matchResult)
    }

    private fun getValidLottoTickets(): List<Lotto> {
        return try {
            val amount = InputView.readPurchaseAmount()
            val tickets = lottoService.purchaseLottoTickets(amount)
            OutputView.printPurchasedTickets(tickets.size, tickets.map { it.getNumbers() })
            tickets
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getValidLottoTickets()
        }
    }

    private fun getValidWinningNumbers(): WinningNumbers {
        return try{
            val numbers = InputView.readWinningNumbers()
            val bonusNumber = InputView.readBonusNumber(numbers)
            WinningNumbers(numbers, bonusNumber)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getValidWinningNumbers()
        }
    }
}