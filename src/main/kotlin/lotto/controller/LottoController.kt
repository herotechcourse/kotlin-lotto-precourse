package lotto.controller

import lotto.model.LottoMachine
import lotto.model.PriceCalculator
import lotto.model.WinningChecker
import lotto.model.random.DefaultRandomNumbersGenerator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    private val lottoMachine = LottoMachine(DefaultRandomNumbersGenerator())
    private val priceCalculator = PriceCalculator()
    private val winnerChecker = WinningChecker()

    fun start() {
        val purchaseAmount: Int = readValidPurchaseAmount()
    }

    private tailrec fun readValidPurchaseAmount(): Int {
        val purchaseAmount = inputView.readPurchaseAmount().toIntOrNull()
        if (purchaseAmount != null) {
            return purchaseAmount
        }
        println("[ERROR] You must input only integer.")
        return readValidPurchaseAmount()
    }
}
