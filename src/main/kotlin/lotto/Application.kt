package lotto

fun main() {
    try {
        val lottoGame = LottoGame()
        lottoGame.play()
    } catch (e: InputView.MaxRetryException) {
        println(e.message + " Exiting...")
        return
    }
}
