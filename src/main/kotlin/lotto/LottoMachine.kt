package lotto

class LottoMachine(
    private val inputView: InputView = InputView(),
) {
    fun run() {
        val purchaseAmount = readPurchaseAmount()
        val lottos = generateLottoByPurchaseAmount(purchaseAmount)
        OutputView.printIssuedLottos(lottos)
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
}