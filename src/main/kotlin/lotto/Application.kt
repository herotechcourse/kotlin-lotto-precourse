package lotto

fun main() {
    try {

        val inputHandler = InputHandler()
        val outputHandler = OutputHandler()


        // Get purchase amount
        val amount = inputHandler.getPurchaseAmount()
        val ticketCount = amount / 1000
        outputHandler.printTicketNumber(ticketCount)

        // Generate tickets
        val lottoMachine = LottoMachine()
        val tickets = lottoMachine.generateTickets(ticketCount)
        outputHandler.printTickets(tickets)

        // Get Winning numbers
        val lastWinningNumbers = inputHandler.getWinningNumbers()
        println(lastWinningNumbers)




    }catch (e: IllegalArgumentException){
        println("[ERROR]${e.message}")

    }
}
