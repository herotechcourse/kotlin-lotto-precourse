package lotto.view

object InputView {

    private const val INPUT_PURCHASE_AMOUNT_MESSAGE = "Please enter the purchase amount."
    private const val INPUT_LAST_WINNING_NUMBER_MESSAGE = "Please enter last week's winning numbers."
    private const val INPUT_LAST_BONUS_NUMBER_MESSAGE = "Please enter the bonus number."

    private fun readWithMessage(message: String): String {
        println()
        println(message)
        return readln()
    }

    fun readPurchaseAmount(): Int {
        val input = readWithMessage(INPUT_PURCHASE_AMOUNT_MESSAGE)
        return input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Input must be a valid number.")
    }

    fun readLastWinningNumber(): List<Int> {
        val input = readWithMessage(INPUT_LAST_WINNING_NUMBER_MESSAGE)
        return input.split(",")
            .map {
                it.trim().toIntOrNull()
                    ?: throw IllegalArgumentException("[ERROR] Winning numbers must be numbers.")
            }
    }

    fun readLastBonusNumber(): Int {
        val input = readWithMessage(INPUT_LAST_BONUS_NUMBER_MESSAGE)
        return input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Bonus number must be a number.")
    }
}
