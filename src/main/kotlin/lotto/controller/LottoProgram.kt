package lotto.controller

import lotto.constants.Constants
import lotto.model.LottoIssuer
import lotto.model.LottoResult
import lotto.model.LottoStorage
import lotto.view.InputHandler
import lotto.view.OutputView

class LottoProgram {
    fun run() {
        val purchaseAmount = InputHandler.readValidPurchaseAmount()
        val lottoStorage = issueLottery(purchaseAmount)
        val winningLotto = InputHandler.readWinningLotto()

        val lottoResult = LottoResult(lottoStorage, winningLotto)
        OutputView.winningStatistics(lottoResult, purchaseAmount)
    }
}

fun issueLottery(purchaseAmount: Int): LottoStorage {
    val lottoCount = purchaseAmount / Constants.LOTTO_PURCHASE_UNIT
    OutputView.purchaseCount(lottoCount)

    val lottery = LottoIssuer.execute(lottoCount)
    val lottoStorage = LottoStorage(lottery)

    OutputView.purchaseLottery(lottoStorage.getAll())
    return lottoStorage
}