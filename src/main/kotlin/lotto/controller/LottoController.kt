package lotto.controller

import lotto.domain.*
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun run() {
        val purchaseAmount = getPurchaseAmount()
        val lottos = generateLottos(purchaseAmount.possibleLottoTicketCount)

        OutputView.printGeneratedLottos(lottos)

        val winningNumber = getWinningNumbers()
        val bonusNumber = getBonusNumber()
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

    fun getWinningNumbers(): WinningNumbers {
        while (true) {
            try {
                return WinningNumbers.from(InputView.readWinningNumbers())
            } catch (e: IllegalArgumentException) {
                e.message?.let { OutputView.printError(it) }
            }
        }
    }

    fun getBonusNumber(): BonusNumber {
        while (true) {
            try {
                return BonusNumber.from(InputView.readBonusNumber())
            } catch (e: IllegalArgumentException) {
                e.message?.let { OutputView.printError(it) }
            }
        }
    }
}