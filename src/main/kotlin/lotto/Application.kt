package lotto

fun main() {
    try {

        val inputHandler = InputHandler()
        val outputHandler = OutputHandler()


        // Get purchase amount
        val amount = inputHandler.getPurchaseAmount()
        val ticketCount = amount / 1000
        outputHandler.printTicketNumber(ticketCount)


    }catch (e: IllegalArgumentException){
        println("[ERROR]${e.message}")

    }
}
