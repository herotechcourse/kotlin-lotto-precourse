package lotto

class LottoMachine(
    private val inputView: InputView = InputView(),
) {
    fun run() {
        val purchaseAmount = readPurchaseAmount()
        val lottos = generateLottoByPurchaseAmount(purchaseAmount)
        OutputView.printIssuedLottos(lottos)
        val winningNumbers = readWinningNumber()
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

    private fun readWinningNumber(): List<Int> {
        while (true) {
            try {
                val input = inputView.readWinningNumber()
                WinningNumberValidator.validate(input)
                return input.split(",").map { it.trim().toInt() }
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}