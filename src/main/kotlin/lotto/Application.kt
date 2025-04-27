
package lotto

fun main() {
    // TODO: Implement the program
    // Variable to hold the purchase amount from the user
    println("Please enter the purchase amount.")
    val purchaseAmountInput = readLine()?.trim()

    // Try to convert the purchase amount to an integer
    val purchaseAmount = try {
        purchaseAmountInput?.toInt() ?: throw IllegalArgumentException("[ERROR] Input cannot be empty.")
    } catch (e: NumberFormatException) {
        println("[ERROR] Please enter a valid number.")
        return
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return
    }

    // Validate the purchase amount (must be divisible by 1000)
    try {
        InputValidator.validatePurchaseAmount(purchaseAmount)
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return
    }

    // Calculate the number of tickets based on the purchase amount
    val ticketCount = purchaseAmount / 1000
    val lottoMachine = LottoMachine()

    // Generate the specified number of tickets
    val tickets = lottoMachine.generateTickets(ticketCount)

    // Display the number of tickets purchased and their numbers
    println("You have purchased ${tickets.size} tickets.")
    tickets.forEach { println(it.getNumbers()) }

    // Declare and get the winning numbers
    println("Please enter last week's winning numbers (comma separated).")
    val winningNumbersInput = readLine()?.trim()
    val winningNumbers = try {
        winningNumbersInput?.split(",")?.map { it.trim().toInt() } ?: throw IllegalArgumentException("[ERROR] Winning numbers cannot be empty.")
    } catch (e: NumberFormatException) {
        println("[ERROR] Winning numbers must be numbers separated by commas.")
        return
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return
    }

    // Validate the winning numbers (must be 6 unique numbers between 1 and 45)
    try {
        InputValidator.validateWinningNumbers(winningNumbers)
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return
    }

    // Declare and get the bonus number
    println("Please enter the bonus number.")
    val bonusNumberInput = readLine()?.trim()
    val bonusNumber = try {
        bonusNumberInput?.toInt() ?: throw IllegalArgumentException("[ERROR] Bonus number cannot be empty.")
    } catch (e: NumberFormatException) {
        println("[ERROR] Please enter a valid number for the bonus.")
        return
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return
    }

    // Validate the bonus number (must be unique and between 1 and 45)
    try {
        InputValidator.validateBonusNumber(bonusNumber, winningNumbers.toSet())
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return
    }

    // Create a LottoGame instance with the generated tickets, winning numbers, and bonus number
    val lottoGame = LottoGame(tickets, winningNumbers, bonusNumber)

    // Print the result of the game (matches and prize distribution)
    lottoGame.printResult()
}