package lotto

fun main() {
    val inputHandler = InputHandler()
    val lottoMachine = LottoMachine()

    val purchaseAmount = inputHandler.getPurchaseAmount()

    val lottoCount = purchaseAmount / 1000
    val lottos = lottoMachine.generateLottos(lottoCount)
}
