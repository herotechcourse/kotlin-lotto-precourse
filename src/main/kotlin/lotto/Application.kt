package lotto

fun main() {
    val lottoService = LottoService()
    val inputView = InputView()
    val outputView = OutputView()

    val app = LottoApp(lottoService, inputView, outputView)
    app.run()
}
