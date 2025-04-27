package lotto

import lotto.view.InputView
import lotto.view.OutputView
import lotto.domain.LottoGenerator
import lotto.domain.WinningLotto
import lotto.domain.LottoManager

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()
    validatePurchaseAmount(purchaseAmount)

    val ticketCount = purchaseAmount / 1000
    val lottos = LottoGenerator.generateLottos(ticketCount)

    OutputView.printPurchasedTickets(lottos)


    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber()
    val winningLotto = WinningLotto(winningNumbers, bonusNumber)

    val lottoManager = LottoManager(lottos)
    val result = lottoManager.matchLottos(winningLotto)

    OutputView.printStatistics(result, purchaseAmount)
}

fun validatePurchaseAmount(amount: Int) {
    if (amount <= 0) {
        throw IllegalArgumentException("[ERROR] Purchase amount must be greater than 0.")
    }
    if (amount % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] Purchase amount must be divisible by 1,000.")
    }
}
