package lotto

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
                PurchaseAmountValidator.validate(input)
                return input.replace(",", "").trim().toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun generateLottoByPurchaseAmount(purchaseAmount: Int): List<Lotto> {
        val count = purchaseAmount / 1000
        return LottoGenerator.generateLottos(count)
    }

    private fun readPickedNumbers(): PickedNumbers {
        val winningNumbers = readWinningNumbers()

        while (true) {
            try {
                val bonusNumber = readBonusNumber()
                return PickedNumbers(winningNumbers, bonusNumber)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun readWinningNumbers(): List<Int> {
        while (true) {
            try {
                val input = inputView.readWinningNumber()
                InputValidator.validateWinningNumbersInput(input)
                val numbers = input.split(",").map { it.trim().toInt() }
                val dummyBonus = (1..45).first { it !in numbers }
                PickedNumbers(numbers, dummyBonus)
                return numbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun readBonusNumber(): Int {
        val input = inputView.readBonusNumber()
        InputValidator.validateBonusNumberInput(input)
        return input.trim().toInt()
    }
}