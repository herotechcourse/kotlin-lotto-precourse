package lotto

import lotto.LottoConstants.DELIMITER
import lotto.LottoConstants.LOTTO_NUMBER_MAX
import lotto.LottoConstants.LOTTO_NUMBER_MIN
import lotto.LottoConstants.LOTTO_PRICE

class LottoMachine(
    private val inputView: InputView = InputView(),
) {
    fun run() {
        val purchaseAmount = readPurchaseAmount()
        val lottos = generateLottoByPurchaseAmount(purchaseAmount)
        OutputView.printIssuedLottos(lottos)
        val pickedNumbers = readPickedNumbers()
        val result = ResultCalculator.calculate(lottos, pickedNumbers, purchaseAmount)
        OutputView.printWinningStatistics(result)
    }

    private fun readPurchaseAmount(): Int {
        while (true) {
            try {
                val input = inputView.readPurchaseAmount()
                InputValidator.validatePurchaseAmount(input)
                return input.replace(DELIMITER, "").trim().toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun generateLottoByPurchaseAmount(purchaseAmount: Int): List<Lotto> {
        val count = purchaseAmount / LOTTO_PRICE
        return LottoGenerator.generateLottos(count)
    }

    private fun readPickedNumbers(): PickedNumbers {
        val winningNumbers = readWinningNumbers()
        retryInput {
            val bonusNumber = readBonusNumber()
            return PickedNumbers(winningNumbers, bonusNumber)
        }
    }

    private fun readWinningNumbers(): List<Int> = retryInput {
        val input = inputView.readWinningNumber()
        InputValidator.validateWinningNumbersInput(input)
        val numbers = input.split(DELIMITER).map { it.trim().toInt() }
        val dummyBonus = (LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX).first { it !in numbers }
        PickedNumbers(numbers, dummyBonus)
        numbers
    }

    private fun readBonusNumber(): Int = retryInput {
        val input = inputView.readBonusNumber()
        InputValidator.validateBonusNumberInput(input)
        input.trim().toInt()
    }

    private inline fun <T> retryInput(block: () -> T): T {
        while (true) {
            try {
                return block()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}