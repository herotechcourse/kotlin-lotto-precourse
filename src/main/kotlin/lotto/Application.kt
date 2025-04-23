package lotto

import lotto.business.LottoService
import lotto.ui.InputView
import lotto.ui.OutputView

const val COST_OF_ONE_LOTTERY_TICKET = 1000

fun main() {
    // TODO: Implement the program
    val inputView = InputView()
    val outputView = OutputView()
    val lottoService = LottoService()
    // Read and get Purchase Amount
    val purchaseAmount = inputView.getPurchaseAmount()

    // Get generated Purchase tickets
    val purchasedLottoTickets = lottoService
        .generateLottoTickets(purchaseAmount / COST_OF_ONE_LOTTERY_TICKET)

    // Display generated tickets
    outputView.displayPurchasedLotteryTickets(purchasedLottoTickets)

    // Input last week's winning numbers
    val lastWeekWinningLotto = inputView.getWinningNumbers()

    // Input last week's bonus number
    val bonusNumber = inputView.getBonusNumber()

    // Get Winning statistics
    val winningStatistics = lottoService.getWinningStatistics(purchasedLottoTickets, lastWeekWinningLotto, bonusNumber)

    // Print winning statistics
    outputView.displayWinningStatistics(winningStatistics, purchaseAmount)
}