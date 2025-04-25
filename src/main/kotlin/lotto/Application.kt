package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    try {
        // Step 1: Read and validate the purchase amount
        println("Enter the purchase amount:")
        val amountInput = Console.readLine()
        val amount = InputValidator.validatePurchaseAmount(amountInput)

        // Step 2: Calculate the number of tickets to purchase
        val ticketCount = amount / 1000
        println("You have purchased $ticketCount tickets.")

        // Step 3: Generate the lottery tickets
        val tickets = generateLottoTickets(ticketCount)
        tickets.forEach { println(it.sorted()) }

        // Step 4: Read and validate the winning numbers
        println("Enter the winning numbers (6 unique numbers, comma separated):")
        val winningNumbersInput = Console.readLine()
        val winningNumbers = InputValidator.validateWinningNumbers(winningNumbersInput)

        // Step 5: Read and validate the bonus number
        println("Enter the bonus number:")
        val bonusNumberInput = Console.readLine()
        val bonusNumber = InputValidator.validateBonusNumber(bonusNumberInput, winningNumbers)

        // Step 6: Compare tickets with the winning numbers and calculate results (not implemented in this part)
        // You can add the logic to compare tickets here in a further step

    } catch (e: IllegalArgumentException) {
        // Handle exceptions
        println("[ERROR] ${e.message}")
        main()  // Re-prompt input if there's an error
    }
}

// Function to generate the lotto tickets
fun generateLottoTickets(count: Int): List<List<Int>> {
    return List(count) {
        Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}
