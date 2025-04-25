package lotto

fun main() {
    try {

        val inputHandler = InputHandler()


        // Get purchase amount
        val amount = inputHandler.getPurchaseAmount()
        val ticketCount = amount / 1000
        println(ticketCount)

    }catch (e: IllegalArgumentException){
        println("[ERROR]${e.message}")

    }
}
