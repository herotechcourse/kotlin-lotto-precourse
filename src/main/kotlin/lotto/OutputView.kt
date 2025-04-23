package lotto

class OutputView {
    fun askWinningNumbers() {
        println()
        println("Please enter last week's winning numbers.")
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