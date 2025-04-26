package lotto.controller

import lotto.Lotto
import lotto.model.MatchResult
import lotto.model.WinningNumbers
import lotto.service.LottoService
import lotto.util.Validator
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
        while (true) {
            try {
                val amount = InputView.readPurchaseAmount()
                val tickets = lottoService.purchaseLottoTickets(amount)
                OutputView.printPurchasedTickets(tickets.size, tickets.map { it.getNumbers() })
                return tickets
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getValidWinningNumbers(): WinningNumbers {
        while (true) {
            try{
                val numbers = InputView.readWinningNumbers()
                val bonusNumber = InputView.readBonusNumber(numbers)
                return WinningNumbers(numbers, bonusNumber)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }



}