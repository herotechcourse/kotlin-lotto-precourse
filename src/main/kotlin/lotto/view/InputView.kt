package lotto.view

// Handles all user input for the lottery program
object InputView {

    // Messages to display before asking for each input
    private const val INPUT_PURCHASE_AMOUNT_MESSAGE = "Please enter the purchase amount."
    private const val INPUT_LAST_WINNING_NUMBER_MESSAGE = "Please enter last week's winning numbers."
    private const val INPUT_LAST_BONUS_NUMBER_MESSAGE = "Please enter the bonus number."

    // Displays a message and reads a line from the user
    private fun readWithMessage(message: String): String {
        println()
        println(message)
        return readln()
    }

    // Reads and validates the purchase amount
    fun readPurchaseAmount(): Int {
        val input = readWithMessage(INPUT_PURCHASE_AMOUNT_MESSAGE)
        return input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Input must be a valid number.")
    }

    // Reads and validates last week's winning numbers
    fun readLastWinningNumber(): List<Int> {
        val input = readWithMessage(INPUT_LAST_WINNING_NUMBER_MESSAGE)
        return input.split(",")
            .map {
                it.trim().toIntOrNull()
                    ?: throw IllegalArgumentException("[ERROR] Winning numbers must be numbers.")
            }
    }

    // Reads and validates the bonus number
    fun readLastBonusNumber(): Int {
        val input = readWithMessage(INPUT_LAST_BONUS_NUMBER_MESSAGE)
        return input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Bonus number must be a number.")
    }
}
