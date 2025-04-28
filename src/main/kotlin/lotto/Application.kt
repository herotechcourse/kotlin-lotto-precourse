package lotto

fun main() {
    val inputHandler = InputHandler()
    val outputHandler = OutputHandler()
    val lottoMachine = LottoMachine()

    val lottoGame = LottoGame(
        lottoMachine,
        inputHandler,
        outputHandler
    )
    
    lottoGame.run()
}
