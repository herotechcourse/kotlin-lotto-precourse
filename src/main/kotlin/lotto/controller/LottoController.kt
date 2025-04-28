package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView
import lotto.domain.PurchaseAmount
import lotto.domain.WinningNumbers
import lotto.domain.BonusNumber
import lotto.domain.MatchResult
import lotto.service.GenerateLottos
import lotto.service.matchLottos
/**
 *  [ Logic flow of "start" method ]
 *  1. Input purchase amount & validation
 *  2. Calculate how many lottos can be made & Generate Lottos
 *  3. Print every lotto following by format
 *  4. Input winning numbers & validation
 *  5. Input bonus number & validation
 *  6. Match lotto numbers, winning numbers and store result to matchResult
 *  7. Print results
 */
class LottoController {
    fun start() {
        val purchaseAmount = inputPurchaseAmount()
        val lottos = generateLottos(purchaseAmount)
        OutputView.printPurchaseLottos(lottos)

        val winningNumbers = inputWinningNumbers()
        val bonusNumber = inputBonusNumber(winningNumbers)

        val ranks = matchLottos(lottos, winningNumbers.getNumbers(), bonusNumber.value())
        val matchResult = MatchResult(ranks)
        printResult(matchResult, purchaseAmount)
    }

    private fun generateLottos(purchaseAmount: PurchaseAmount): List<lotto.Lotto> {
        val count = purchaseAmount.countPurchasableLottos()
        return GenerateLottos.generate(count)
    }

    private fun inputPurchaseAmount(): PurchaseAmount {
        while (true) {
            try {
                val amount = InputView.readPurchaseAmount()
                return PurchaseAmount(amount)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputWinningNumbers(): WinningNumbers {
        while (true) {
            try {
                val numbers = InputView.readWinningNumbers()
                return WinningNumbers(numbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputBonusNumber(winningNumbers: WinningNumbers): BonusNumber {
        while (true) {
            try {
                val bonus = InputView.readBonusNumber()
                return BonusNumber(bonus, winningNumbers.getNumbers())
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun printResult(matchResult: MatchResult, purchaseAmount: PurchaseAmount) {
        OutputView.printMatchResult(matchResult)
        OutputView.printProfitRate(matchResult.profitRate(purchaseAmount.value()))
    }
}