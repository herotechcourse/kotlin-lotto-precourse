package lotto

class OutputView {
    fun askWinningNumbers() {
        println("\nPlease enter last week's winning numbers.")
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

    fun askBonusNumber() {
        println("\nPlease enter the bonus number.")
    }
}