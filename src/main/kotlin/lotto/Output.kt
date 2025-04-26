package lotto

class OutputView {
    fun promptPurchase (){
        println("Please enter the purchase amount :")
    }

    fun ticketAmount(count: Int) {
        println("You have purchased $count tickets.")
    }

    fun tickets(tickets: List<Lotto>){
        tickets.forEach { ticket ->
            println(ticket.getNumbers())
        }
    }

    fun promptWinningNumbers (){
        println("Please enter last week's winning numbers (comma-separated) :")
    }

    fun promptBonusNumber (){
        println("Please enter the bonus number :")
    }

    fun error(message: String)  {
        println("[ERROR] $message")
    }
}