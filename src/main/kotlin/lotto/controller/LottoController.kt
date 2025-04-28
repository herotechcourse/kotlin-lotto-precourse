package lotto.controller

import lotto.Lotto
import lotto.presentation.InputView
import lotto.presentation.OutputView
import lotto.InputValidator
import lotto.LottoTicketGenerator
import lotto.Statistics

interface LottoController {
    fun run()
}

class LottoControllerImpl(
    private val inputValidator: InputValidator,
    private val inputView: InputView,
    private val outputView: OutputView,
    private val lottoTicketGenerator: LottoTicketGenerator,
    private val statistics: Statistics,
) : LottoController {
    private fun processPurchaseAmount(): Int {
        outputView.printInputPrompt(PURCHASE_AMOUNT_PROMPT)
        val input = inputView.readPurchaseAmount()
        return try {
            inputValidator.validatePurchaseAmount(input)
        } catch (e: IllegalArgumentException) {
            outputView.printErrorMessage(e.message)
            processPurchaseAmount()
        }
    }

    private fun processTickets(purchaseAmount: Int): List<Lotto> {
        val numberOfTickets = lottoTicketGenerator.generateNumberOfTickets(purchaseAmount)
        outputView.printNumberOfTickets(numberOfTickets)
        val tickets = lottoTicketGenerator.generateTickets(numberOfTickets)
        outputView.printTickets(tickets)
        return tickets
    }

    private fun processWinningNumbers(): List<Int> {
        outputView.printInputPrompt(WINNING_NUMBERS_PROMPT)
        val input = inputView.readWinningNumbers()
        return try {
            inputValidator.validateWinningNumbers(input)
        } catch (e: IllegalArgumentException) {
            outputView.printErrorMessage(e.message)
            processWinningNumbers()
        }
    }

    private fun processBonusNumber(): Int {
        outputView.printBlankLine()
        outputView.printInputPrompt(BONUS_NUMBER_PROMPT)
        val input = inputView.readBonusNumber()
        return try {
            inputValidator.validateBonusNumber(input)
        } catch (e: IllegalArgumentException) {
            outputView.printErrorMessage(e.message)
            processBonusNumber()
        }
    }

    private fun processResult(
        tickets: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int,
    ) {
        val result = statistics.calculateResult(tickets, winningNumbers, bonusNumber)
        outputView.printStatistics(result)
    }

    private fun processProfitRate(purchaseAmount: Int) {
        val profitRate = statistics.calculateProfitRate(purchaseAmount)
        outputView.printProfitRate(profitRate)
    }

    override fun run() {
        val purchaseAmount = processPurchaseAmount()
        val tickets = processTickets(purchaseAmount)
        val winningNumbers = processWinningNumbers()
        val bonusNumber = processBonusNumber()
        processResult(tickets, winningNumbers, bonusNumber)
        processProfitRate(purchaseAmount)
    }

    companion object {
        private const val PURCHASE_AMOUNT_PROMPT = "Please enter the purchase amount."
        private const val WINNING_NUMBERS_PROMPT = "Please enter last week's winning numbers."
        private const val BONUS_NUMBER_PROMPT = "Please enter the bonus number."
    }
}