package lotto

fun main() {
    // Temporary manual testing code
    val amount = readPurchaseAmount()
    validateAmount(amount)

    val tickets = generateTickets(amount)
    printTickets(tickets)

    val winningNumbersInput = readWinningNumbers()
    val bonusNumber = readBonusNumber()
    val winningNumbers = WinningNumbers(Lotto(winningNumbersInput), bonusNumber)

    println("Winning Numbers: $winningNumbers")
    println("Bonus Number: $bonusNumber")
}
