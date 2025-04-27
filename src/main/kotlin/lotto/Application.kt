package lotto

fun main() {
    // TODO: Implement the program

    println("Please enter the purchase amount.")
    val amount = readLine()!!.toInt()
    InputValidator.validatePurchaseAmount(amount)
    val ticketCount = amount / 1000

    val machine = LottoMachine()
    val tickets = machine.generateTickets(ticketCount)

    println("\nYou have purchased $ticketCount tickets.")
    tickets.forEach { println(it.getNumbers()) }

    println("\nPlease enter last week's winning numbers (comma-separated).")
    val winningNumbers = readLine()!!.split(",").map { it.trim().toInt() }
    InputValidator.validateWinningNumbers(winningNumbers)

    println("Please enter the bonus number.")
    val bonus = readLine()!!.toInt()
    InputValidator.validateBonusNumber(bonus, winningNumbers.toSet())

    val game = LottoGame(tickets, winningNumbers.toSet(), bonus)
    game.evaluate()

    println("\nWinning Statistics")
    println("---")
    val results = game.getResults()
    println("3 Matches (5,000 KRW) – ${results[3]} tickets")
    println("4 Matches (50,000 KRW) – ${results[4]} tickets")
    println("5 Matches (1,500,000 KRW) – ${results[5]} tickets")
    println("5 Matches + Bonus Ball (30,000,000 KRW) – ${results[52]} tickets")
    println("6 Matches (2,000,000,000 KRW) – ${results[6]} tickets")

    println("Total return rate is ${"%.1f".format(game.calculateProfit())}%.")

}
