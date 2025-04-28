package lotto.controller

import lotto.Lotto
import lotto.Lotto.Companion.MAXIMUM_LOTTO_NUMBER
import lotto.Lotto.Companion.MINIMUM_LOTTO_NUMBER
import lotto.model.LottoMachine
import lotto.model.PriceCalculator
import lotto.model.Rank
import lotto.model.WinningChecker
import lotto.model.random.DefaultRandomNumbersGenerator
import lotto.view.InputView
import lotto.view.OutputView
import java.lang.IllegalArgumentException

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    private val lottoMachine = LottoMachine(DefaultRandomNumbersGenerator())
    private val priceCalculator = PriceCalculator()
    private val winnerChecker = WinningChecker()

    fun start() {
        val purchaseAmount: Int = readValidPurchaseAmount()
        val userLottos: List<Lotto> = lottoMachine.makeLottos(purchaseAmount)
        outputView.printUserLottos(userLottos)

        val countOfRanks = countRanks(userLottos)
        outputView.printWinningStatistics(countOfRanks)

        val returnRate = priceCalculator.calculateReturnRate(purchaseAmount, countOfRanks)
        outputView.printReturnRate(returnRate)
    }

    private tailrec fun readValidPurchaseAmount(): Int {
        val purchaseAmount = inputView.readPurchaseAmount().toIntOrNull()
        if (purchaseAmount != null) {
            return purchaseAmount
        }
        println("[ERROR] You must input only integer.")
        return readValidPurchaseAmount()
    }

    private fun countRanks(userLottos: List<Lotto>): Map<Rank, Int> {
        val winningLotto: Lotto = readValidWinningNumbers()
        val bonusNumber: Int = readValidBonusNumber(winningLotto)
        return winnerChecker.countMatches(userLottos, winningLotto, bonusNumber)
    }

    private tailrec fun readValidWinningNumbers(): Lotto {
        val winningNumbers = inputView.readWinningNumbers().split(",").map { it.toIntOrNull() }
        if (!winningNumbers.contains(null)) {
            return try {
                Lotto(winningNumbers.filterNotNull())
            } catch (e: IllegalArgumentException) {
                println(e.message)
                readValidWinningNumbers()
            }
        }
        println("[ERROR] You must input only integers.")
        return readValidWinningNumbers()
    }

    private tailrec fun readValidBonusNumber(winningLotto: Lotto): Int {
        val bonusNumber = inputView.readBonusNumber().toIntOrNull()
        if (bonusNumber != null) {
            return try {
                validateBonusNumber(bonusNumber, winningLotto)
                bonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
                return readValidBonusNumber(winningLotto)
            }
        }
        println("[ERROR] You must input only integer.")
        return readValidBonusNumber(winningLotto)
    }

    private fun validateBonusNumber(bonusNumber: Int, winningLotto: Lotto) {
        require(bonusNumber in MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER) {
            "[ERROR] Bonus number must be in range of 1 to 45."
        }
        require(bonusNumber !in winningLotto.numbers) { "[ERROR] Bonus number must not be in winning lotto." }
    }
}
