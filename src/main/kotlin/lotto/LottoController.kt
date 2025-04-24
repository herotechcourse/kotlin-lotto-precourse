package lotto

import lotto.domain.Bonus
import lotto.domain.Lotto
import lotto.domain.LottoManager
import lotto.util.EarningCalculator
import lotto.util.RandomNumberGenerator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    companion object {
        private const val LOTTO_PRICE = 1000
    }

    fun run() {
        val purchaseAmount = getPurchaseAmount()
        val count = purchaseAmount / LOTTO_PRICE
        val lottos = getLottosFrom(count)
        OutputView.showPurchaseLotto(count, lottos)

        val winningLotto = getWinningLotto()
        val bonus = getBonus()
        checkIfBonusIsDuplicate(winningLotto, bonus)

        val lottoManager = LottoManager(lottos, winningLotto, bonus)
        OutputView.showLottoResult(lottoManager.getLottoResultMap())

        val winningAmount = lottoManager.calculateWinningAmount()
        val earningsRate = EarningCalculator.calculateEarningsRate(winningAmount, purchaseAmount)
        OutputView.showEarningRate(earningsRate)
    }

    private fun getPurchaseAmount(): Int {
        return try {
            val purchaseAmount = InputView.readPurchaseAmount()
            checkIfPurchaseAmountIsValid(purchaseAmount)
            purchaseAmount
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getPurchaseAmount()
        }
    }

    private fun getWinningLotto(): Lotto {
        return try {
            InputView.readWinningLotto()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getWinningLotto()
        }
    }

    private fun getBonus(): Bonus {
        return try {
            InputView.readBonus()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getBonus()
        }
    }

    private fun checkIfBonusIsDuplicate(lotto: Lotto, bonus: Bonus) {
        if (lotto.hasBonus(bonus)) {
            throw IllegalArgumentException("[ERROR] Bonus number must not duplicate any winning number.")
        }
    }

    private fun checkIfPurchaseAmountIsValid(purchaseAmount: Int) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be in units of the lotto ticket price.")
        }
    }

    private fun getLottosFrom(count: Int): List<Lotto> {
        return List(count) {
            Lotto(RandomNumberGenerator.generateRandomNumbers())
        }
    }
}
