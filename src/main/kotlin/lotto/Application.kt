package lotto

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val lottoValidator = LottoValidator()

    val lottoGame = LottoGame(inputView, outputView, lottoValidator)

    lottoGame.start()
}
