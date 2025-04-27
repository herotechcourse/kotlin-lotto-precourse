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

        // Get last Winning numbers
        val lastWinningNumbers = inputHandler.getWinningNumbers()
        println(lastWinningNumbers)
        val bonusNumber = inputHandler.getBonusNumber(lastWinningNumbers)
        println(bonusNumber)

        //Calculate results
        val prizeCalculator = PrizeCalculator(lastWinningNumbers,bonusNumber)
        val statistics = prizeCalculator.calculateResults(tickets)





    }catch (e: IllegalArgumentException){
        println("[ERROR]${e.message}")

    }
}
