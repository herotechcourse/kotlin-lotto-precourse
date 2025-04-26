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
        val numbers = readWinningNumbersWithRetry()
        val bonus = readBonusWithRetry(numbers)
        return WinningNumbers(numbers, bonus)
    }

    private fun readWinningNumbersWithRetry(): List<Int> =
        try {
            InputView.readWinningNumbers()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readWinningNumbersWithRetry()
        }

    private fun readBonusWithRetry(numbers: List<Int>): Int =
        try {
            InputView.readBonusNumber(numbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readBonusWithRetry(numbers)
        }
}