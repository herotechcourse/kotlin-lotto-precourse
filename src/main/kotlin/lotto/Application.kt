package lotto

import lotto.data.repo.LottoRepositoryImpl
import lotto.data.service.LottoNumberService
import lotto.domain.model.WinningNumbers
import lotto.domain.usecases.CalculateResultUseCase
import lotto.domain.usecases.ComputeProfitUseCase
import lotto.domain.usecases.PurchaseLottoUseCase
import lotto.presentation.controller.LottoController
import lotto.presentation.view.InputView

fun main() {
  val lottoNumberService = LottoNumberService()
  val lottoRepository = LottoRepositoryImpl(lottoNumberService)

  val purchaseLottoUseCase = PurchaseLottoUseCase(lottoRepository)
  val calculateResultUseCase = CalculateResultUseCase(lottoRepository)
  val computeProfitUseCase = ComputeProfitUseCase()

  val controller = LottoController(
    purchaseLottoUseCase,
    calculateResultUseCase,
    computeProfitUseCase
  )

  val purchaseAmount = InputView.readPurchaseAmount()

  val winningNumbers = InputView.readWinningNumbers()
  val bonusNumber = InputView.readBonusNumber(winningNumbers)

  controller.run(purchaseAmount, WinningNumbers(winningNumbers , bonusNumber ))
}
