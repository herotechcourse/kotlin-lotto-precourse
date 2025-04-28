package lotto.controller

import lotto.domain.LottoGenerator
import lotto.domain.Lottos
import lotto.domain.PurchaseAmount
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun run() {
        val purchaseAmount = getPurchaseAmount()
        val lottos = generateLottos(purchaseAmount.possibleLottoTicketCount)
    }

    fun getPurchaseAmount(): PurchaseAmount {
        while (true) {
            try {
                return PurchaseAmount.from(InputView.readPurchaseAmount())
            } catch (e: IllegalArgumentException) {
                e.message?.let { OutputView.printError(it) }
            }
        }
    }

    fun generateLottos(lottoTicketCount: Int): Lottos {
        try {
            return LottoGenerator.generate(lottoTicketCount)
        } catch (e: IllegalArgumentException) {
            e.message?.let { OutputView.printError(it) }
            throw e
        }
    }
}