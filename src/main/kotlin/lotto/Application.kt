package lotto

fun main() {
    try {

        val inputHandler = InputHandler()
        val outputHandler = OutputHandler()


        println("Please enter the purchase amount.")
        val amount = inputHandler.getPurchaseAmount()
        val ticketCount = amount / 1000
        outputHandler.printTicketNumber(ticketCount)

        // Generate tickets
        val lottoMachine = LottoMachine()
        val tickets = lottoMachine.generateTickets(ticketCount)
        outputHandler.printTickets(tickets)

        println("\nPlease enter last week's winning numbers.")
        val winningNumbers = inputHandler.getWinningNumbers()

        println("\nPlease enter the bonus number.")
        val bonusNumber = inputHandler.getBonusNumber(winningNumbers)
        println(bonusNumber)

        //Calculate results
        val prizeCalculator = PrizeCalculator(winningNumbers,bonusNumber)
        val statistics = prizeCalculator.calculateResults(tickets)


        // Display results
        outputHandler.printStatistics(statistics)

    }catch (e: IllegalArgumentException){
        println("[ERROR] ${e.message}")

    }
}
