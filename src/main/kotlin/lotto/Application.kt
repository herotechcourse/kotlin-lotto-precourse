package lotto

fun main() {
    // Temporary manual testing code
    val amount = readValidPurchaseAmount()
    validateAmount(amount)

    val tickets = generateTickets(amount)
    printTickets(tickets)

    val winningNumbersInput = readValidWinningNumbers()
    val bonusNumber = readValidBonusNumber()
    val winningNumbers = WinningNumbers(Lotto(winningNumbersInput), bonusNumber)

    val results = calculateResults(tickets, winningNumbers)

    // Print results
    println("\nWinning Statistics")
    println("-------------------")
    println("3 matches (5,000 won) - ${results.getOrDefault(5, 0)} tickets")
    println("4 matches (50,000 won) - ${results.getOrDefault(4, 0)} tickets")
    println("5 matches (1,500,000 won) - ${results.getOrDefault(3, 0)} tickets")
    println("5 matches + Bonus (30,000,000 won) - ${results.getOrDefault(2, 0)} tickets")
    println("6 matches (2,000,000,000 won) - ${results.getOrDefault(1, 0)} tickets")

    // Calculate and print total return rate
    val totalRate = calculateTotalRate(results, amount)
    println("Total return rate: %.1f%%".format(totalRate))
}
