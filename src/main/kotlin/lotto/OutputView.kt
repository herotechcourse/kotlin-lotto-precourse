package lotto

class OutputView {
    fun printLottos(lottos: Lottos) {
        for (lotto in lottos.getTickets()) {
            println(lotto.getNumbers())
        }
    }
    fun welcome() {
        println("Please enter the purchase amount.")
    }

    fun printPurchasedCount(ticketCount: Int) {
        println("\nYou have purchased ${ticketCount} tickets.")
    }
}