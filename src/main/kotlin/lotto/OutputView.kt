package lotto

class OutputView {
    fun askWinningNumbers() {

    }

    fun printLottos(lottos: Lottos) {
        for (lotto in lottos.getTickets()) {
            println(lotto.getNumbers())
        }
    }
    fun askPurchaseAmount() {
        println("Please enter the purchase amount.")
    }

    fun printPurchasedCount(ticketCount: Int) {
        println("\nYou have purchased ${ticketCount} tickets.")
    }
}