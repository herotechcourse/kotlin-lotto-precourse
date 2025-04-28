package view

object OutputView {
    fun promptPurchaseAmount() {
        println("Please enter the purchase amount.")
    }

    fun promptWinningNumbers() {
        println("Please enter last week's winning numbers.")
    }

    fun promptBonusNumber() {
        println("Please enter the bonus number.")
    }

    fun printErrorMessage(message: String) {
        println("[ERROR] $message")
    }

    fun printTicketCount(count: Int) {
        println("You have purchased $count tickets")
    }

    fun printTickets(tickets: List<List<Int>>) {
        tickets.forEach { ticket ->
            println(ticket.joinToString(", ", "[", "]"))
        }
    }

    fun printProfitRate(rate: String) {
        println("The profit rate is $rate")
    }

}