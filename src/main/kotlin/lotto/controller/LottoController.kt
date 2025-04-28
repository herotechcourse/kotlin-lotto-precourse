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
        val bonusNumber = getBonusNumber(winningNumber)
        val matchedLottoCount = ResultCalculator.calculateMatchedLottoCount(lottos, winningNumber, bonusNumber)

        OutputView.printMatchedLottoCount(matchedLottoCount)

        val profitRate = ResultCalculator.calculateProfitRate(matchedLottoCount, purchaseAmount.amount)

        OutputView.printProfitRate(profitRate)
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

    fun getBonusNumber(winningNumbers: WinningNumbers): BonusNumber {
        while (true) {
            try {
                return BonusNumber.from(InputView.readBonusNumber(), winningNumbers)
            } catch (e: IllegalArgumentException) {
                e.message?.let { OutputView.printError(it) }
            }
        }
    }
}