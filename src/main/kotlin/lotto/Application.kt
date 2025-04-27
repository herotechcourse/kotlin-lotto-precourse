package lotto

fun main() {
    // TODO: Implement the program
    val inputView = InputView()
    val ticketGenerate = inputView.run()
    println()
    val lotto=Lotto(inputView.readWinningNumbers())
    lotto.run(ticketGenerate,inputView.getPurchase())
}
