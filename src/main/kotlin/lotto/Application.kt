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

    println("3 Matches (5,000 KRW) – ${results.getOrDefault(5, 0)} tickets")
    println("4 Matches (50,000 KRW) – ${results.getOrDefault(4, 0)} tickets")
    println("5 Matches (1,500,000 KRW) – ${results.getOrDefault(3, 0)} tickets")
    println("5 Matches + Bonus Ball (30,000,000 KRW) – ${results.getOrDefault(2, 0)} tickets")
    println("6 Matches (2,000,000,000 KRW) – ${results.getOrDefault(1, 0)} tickets")

    // Calculate and print total return rate
    val totalRate = calculateTotalRate(results, amount)
    println("Total return rate is %.1f%%.".format(totalRate))
}
