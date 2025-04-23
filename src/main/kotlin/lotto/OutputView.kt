package lotto

class OutputView {
    fun welcome() {
        println("Please enter the purchase amount.")
    }

    fun printPurchasedCount(ticketCount: Int) {
        println("\nYou have purchased ${ticketCount} tickets.")
    }
}