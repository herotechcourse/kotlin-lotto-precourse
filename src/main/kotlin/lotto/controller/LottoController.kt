package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView

import lotto.domain.PurchaseAmount
import lotto.domain.WinningNumbers
import lotto.domain.BonusNumber
import lotto.domain.MatchResult

import lotto.service.GenerateLottos
import lotto.service.matchLottos

class LottoController {
    fun start() {
        // 1. Input purchase amount & validation
        val purchaseAmountInput = InputView.readPurchaseAmount()
        val purchaseAmount = PurchaseAmount(purchaseAmountInput)

        // 2. Calculate how many lottos can be made
        val count = purchaseAmount.countPurchasableLottos()

        // 3. Generate Lottos
        val lottos = GenerateLottos.generate(count)

        // 4. Print every lotto following by format
        OutputView.printPurchaseLottos(lottos)

        // 5. Input winning numbers & validation
        val winningNumbersInput = InputView.readWinningNumbers()
        val winningNumbers = WinningNumbers(winningNumbersInput)

        // 6. Input bonus number & validation
        val bonusNumberInput = InputView.readBonusNumber()
        val bonusNumber = BonusNumber(bonusNumberInput, winningNumbers.getNumbers())

        // 7. Match lotto numbers and winning numbers
        val ranks = matchLottos(lottos, winningNumbers.getNumbers(), bonusNumber.value())

        // 8. Print final result
        val matchResult = MatchResult(ranks)
        OutputView.printMatchResult(matchResult)
        OutputView.printProfitRate(matchResult.profitRate(purchaseAmount.value()))
    }
}