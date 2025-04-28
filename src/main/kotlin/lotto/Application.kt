package lotto

import lotto.controller.LotteryController
import lotto.model.LottoGenerator
import lotto.util.PurchaseAmountParser
import lotto.util.BonusNumberParser
import lotto.util.WinningNumbersParser
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val purchaseAmountParser = PurchaseAmountParser()
    val winningNumbersParser = WinningNumbersParser()
    val bonusNumberParser = BonusNumberParser()
    val lottoGenerator = LottoGenerator()

    val game = LotteryController(
        inputView,
        outputView,
        purchaseAmountParser,
        winningNumbersParser,
        bonusNumberParser,
        lottoGenerator
    )

    game.start()
}
