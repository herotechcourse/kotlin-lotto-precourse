package lotto.controller

import lotto.Lotto
import lotto.model.LottoBundle
import lotto.model.generator.LottoNumberGenerator
import lotto.model.LottoPurchaseAmount
import lotto.model.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val lottoNumberGenerator: LottoNumberGenerator
) {
    fun run() {
        val lottoBundle = purchaseLottoBundle()
        outputView.printPurchaseLottos(lottoBundle.allLottoNumbers())

        val winningLotto = enterWinningLotto()
        val matchResults = lottoBundle.matchResults(winningLotto)
        outputView.printMatchResults(matchResults)
    }

    private fun purchaseLottoBundle(): LottoBundle {
        return retryUntilSuccess {
            LottoBundle.from(
                LottoPurchaseAmount(inputView.readPurchaseAmount()),
                lottoNumberGenerator
            )
        }
    }

    private fun enterWinningLotto(): WinningLotto {
        return retryUntilSuccess {
            val winningNumbers = inputView.readWinningNumbers()
            val bonusNumber = inputView.readBonusNumber()
            WinningLotto(Lotto(winningNumbers), bonusNumber)
        }
    }

    private fun <T> retryUntilSuccess(action: () -> T): T {
        while (true) {
            try {
                return action()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}