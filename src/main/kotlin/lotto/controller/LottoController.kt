package lotto.controller

import lotto.domain.BonusNumber
import lotto.Lotto
import lotto.domain.LottoMachine
import lotto.domain.Rank
import lotto.domain.ResultCalculator
import lotto.domain.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView
import camp.nextstep.edu.missionutils.Randoms

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun run() {
        val lottoMachine = createLottoMachine()
        outputView.displayPurchaseCount(lottoMachine.numberOfLottos)

        val purchasedLottos = generateLottos(lottoMachine.numberOfLottos)
        outputView.displayLottoTickets(purchasedLottos)

        val winningNumbers = createWinningNumbers()
        val bonusNumber = createBonusNumber(winningNumbers)

        val resultCalculator = ResultCalculator()
        val results = resultCalculator.calculateResults(purchasedLottos, winningNumbers, bonusNumber)
        val profitRate = resultCalculator.calculateProfitRate(results, lottoMachine.purchaseAmount)
        outputView.displayMatchResults(results)
        outputView.displayRate(profitRate)
    }

    private fun createLottoMachine(): LottoMachine {
        while (true) {
            val purchaseAmountInput = inputView.readPurchaseAmount()
            try {
                return LottoMachine(purchaseAmountInput)
            } catch (e: IllegalArgumentException) {
                outputView.displayError(e.message)
            }
        }
    }

    private fun generateLottos(count: Int): List<Lotto>{
        val lottos = mutableListOf<Lotto>()
        repeat(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(
                Lotto.MIN_LOTTO_NUMBER,
                Lotto.MAX_LOTTO_NUMBER,
                Lotto.VALID_NUMBER_COUNT
            )
            lottos.add(Lotto(numbers))
        }
        return lottos
    }

    private fun createWinningNumbers(): WinningNumbers {
        while (true) {
            val winningNumbersInput = inputView.readWinningNumbers()
            try {
                return WinningNumbers(winningNumbersInput)
            } catch (e: IllegalArgumentException) {
                outputView.displayError(e.message)
            }
        }
    }

    private fun createBonusNumber(winningNumbers: WinningNumbers): BonusNumber {
        while (true) {
            val bonusNumberInput = inputView.readBonusNumber()
            try {
                return BonusNumber(bonusNumberInput, winningNumbers)
            } catch (e: IllegalArgumentException) {
                outputView.displayError(e.message)
            }
        }
    }

}