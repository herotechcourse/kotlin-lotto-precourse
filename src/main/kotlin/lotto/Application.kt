package lotto

fun main() {
    val lottoController = LottoController(RandomLottoGenerator())
    lottoController.run()
}
