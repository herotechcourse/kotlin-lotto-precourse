package lotto.presentation.controller

import lotto.domain.model.WinningNumbers
import lotto.domain.usecases.CalculateResultUseCase
import lotto.domain.usecases.ComputeProfitUseCase
import lotto.domain.usecases.PurchaseLottoUseCase
import lotto.presentation.view.OutputView

class LottoController(
  private val purchaseLottoUseCase: PurchaseLottoUseCase,
  private val calculateResultUseCase: CalculateResultUseCase,
  private val computeProfitUseCase: ComputeProfitUseCase
) {

  fun run(purchaseAmount: Int, winningNumbers: WinningNumbers) {
    val tickets = purchaseLottoUseCase.run(purchaseAmount)

    OutputView.printPurchasedTickets(tickets)

    val ranks = calculateResultUseCase.run(winningNumbers)

    OutputView.printWinningStatisticsHeader()
    OutputView.printStatistics(ranks)

    val profitRate = computeProfitUseCase.run(ranks, purchaseAmount)

    OutputView.printProfitRate(profitRate)
  }
}
