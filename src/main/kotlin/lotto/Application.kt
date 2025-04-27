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

}
