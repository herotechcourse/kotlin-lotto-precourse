package lotto.controller

import lotto.LotteryConstants
import lotto.model.LotteryResult
import lotto.model.LottoGenerator
import lotto.model.WinningLotto
import lotto.util.PurchaseAmountParser
import lotto.util.BonusNumberParser
import lotto.util.WinningNumbersParser
import lotto.view.InputView
import lotto.view.OutputView

class LotteryController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val purchaseAmountParser: PurchaseAmountParser,
    private val winningNumbersParser: WinningNumbersParser,
    private val bonusNumberParser: BonusNumberParser,
    private val lottoGenerator: LottoGenerator,
) {
    fun start() {
        val purchaseAmount = getPurchaseAmount()
        val ticketCount = purchaseAmount / LotteryConstants.TICKET_PRIZE
        val tickets = lottoGenerator.generate(ticketCount)

        outputView.printTicketCount(ticketCount)
        outputView.printTickets(tickets)

        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)


        val result = LotteryResult(tickets, winningLotto)
        outputView.printResult(result)
        outputView.printReturnRate(result)
    }

    private fun getPurchaseAmount(): Int {
        while (true) {
            try {
                val input = inputView.readPurchaseAmount()
                return purchaseAmountParser.parse(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getWinningNumbers(): List<Int> {
        while (true) {
            try {
                val input = inputView.readWinningNumbers()
                return winningNumbersParser.parse(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            try {
                val input = inputView.readBonusNumber()
                return bonusNumberParser.parse(input, winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}