package lotto

fun main() {
    try {
        val lottoGame = LottoGame()
        lottoGame.play()
    } catch (e: LottoGame.MaxRetryException) {
        println(e.message + " Exiting...")
    }
}
