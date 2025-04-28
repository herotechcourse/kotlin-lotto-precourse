package lotto

import lotto.view.InputView

fun main() {
    // Entry point that orchestrates the whole flow:
    // [x] InputView gets input
    // [ ] LottoGenerator creates tickets
    // [ ] OutputView prints tickets
    // [ ] ResultChecker calculates result
    // [ ] OutputView prints statistics

    val purchaseAmount =  InputView.readPurchaseAmount()
    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber(winningNumbers)
}
