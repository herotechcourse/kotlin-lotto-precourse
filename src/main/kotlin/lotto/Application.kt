package lotto

import lotto.business.LottoService
import lotto.ui.InputView
import lotto.ui.OutputView

const val COST_OF_ONE_LOTTERY_TICKET = 1000

fun main() {
    // TODO: Implement the program
    // Read and get Purchase Amount
    val purchaseAmount = InputView.readAndGetPurchaseAmount()
    val purchasedLottoTickets = LottoService
        .generateLottoTickets(purchaseAmount/COST_OF_ONE_LOTTERY_TICKET)
    OutputView.displayPurchasedLotteryTickets(purchasedLottoTickets)
}