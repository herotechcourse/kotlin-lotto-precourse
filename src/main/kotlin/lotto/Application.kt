package lotto

import lotto.domain.LottoResult
import lotto.domain.WinningNumbers
import lotto.service.LottoService
import lotto.service.ResultService
import lotto.service.StatisticsService
import lotto.utils.Utils
import lotto.view.InputView
import lotto.view.OutputView

/*
 * Get and validate the purchase amount from the user
 * Calculate the number of tickets to generate based on the purchase amount
 * Return a Pair of the amount and a Lotto List
 * */
fun purchaseFlow(): Pair<Int, List<Lotto>> {
    val amount: Int =
        Utils.retryInputUntilSuccess { InputView.getPurchaseAmount().also { LottoService.validatePurchaseAmount(it) } }
    val ticketsQuantity = amount / LottoConstants.TICKET_PRICE
    val tickets: List<Lotto> = LottoService.generateTickets(ticketsQuantity)
    println()
    return Pair(amount, tickets)
}

/*
 * Get and validate the winning numbers from the user
 * Get and validate the bonus number from the user
 * Return both values as a Pair
 */
fun winningNumbersFlow(): Pair<List<Int>, Int> {
    val winningNumbersInput: List<Int> =
        Utils.retryInputUntilSuccess { InputView.getWinningNumbers().also { LottoService.validateWinningNumbers(it) } }
    println()
    val bonusNumber: Int =
        Utils.retryInputUntilSuccess {
            InputView.getBonusNumber().also { LottoService.validateBonusNumber(it, winningNumbersInput) }
        }
    println()
    return Pair(winningNumbersInput, bonusNumber)
}

/*
 * Create the WinningNumbers object
 * Evaluate the results of the tickets
 * Calculate the return rate based on the results and the purchase amount
 * Return a Pair with a List of LottoResult and the returnRate
*/
fun lottoResultsFlow(
    winningNumbersInput: List<Int>,
    bonusNumber: Int,
    tickets: List<Lotto>,
    amount: Int,
): Pair<List<LottoResult>, Double> {
    val winningNumbers = WinningNumbers(winningNumbersInput, bonusNumber)
    val lottoResults: List<LottoResult> = tickets.map { ResultService.evaluateTicket(it, winningNumbers) }
    val returnRate = StatisticsService.calculateReturnRate(lottoResults, amount)

    return Pair(lottoResults, returnRate)
}

/**
 * Main entry point and the orchestrator of the Lotto application.
 * The program guides the user through the purchase process, input validation,
 * ticket generation, result evaluation, and finally displays the results.
 */
fun main() {
    val (amount, tickets) = purchaseFlow()
    // Print the generated tickets to the user
    OutputView.printTickets(tickets)
    println()
    val (winningNumbersInput, bonusNumber) = winningNumbersFlow()
    val (lottoResults, returnRate) = lottoResultsFlow(winningNumbersInput, bonusNumber, tickets, amount)
    // Print the winning statistics and the return rate
    OutputView.printWinningStatistics(lottoResults)
    OutputView.printReturnRate(returnRate)
}

