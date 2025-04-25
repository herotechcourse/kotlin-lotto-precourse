package lotto

class OutputView {
    fun promptPurchase (){
        println("Please enter the purchase amount :")
    }

    fun ticketCount(count: Int) {
        println("You have purchased \n$count tickets.")
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