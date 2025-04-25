package lotto.view

import lotto.Lotto

class InputValidator {

    // Utility function to handle toIntOrNull() conversion
    private fun String.toValidInt(): Int {
        return this.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number format")
    }

    fun validatePurchaseAmount(input: String): Int {
        val amount = input.toValidInt()
        // Validate purchase amount: must be a positive number divisible by 1000
        return amount.takeIf { it > 0 && it % Lotto.TICKET_PRICE == 0 }
            ?: throw IllegalArgumentException("[ERROR] Purchase amount must be a positive number divisible by ${Lotto.TICKET_PRICE}")
    }

    fun validateWinningNumbers(input: String): List<Int> {
        val numbers = input.split(",").map { it.trim().toValidInt() }

        // Validate that there are exactly 6 winning numbers, they are unique, and within the range of 1-45
        require(numbers.size == Lotto.REQUIRED_SIZE) { "[ERROR] There must be exactly ${Lotto.REQUIRED_SIZE} winning numbers" }
        require(numbers.toSet().size == Lotto.REQUIRED_SIZE) { "[ERROR] Winning numbers must be unique" }
        require(numbers.all { it in Lotto.MIN_NUMBER ..Lotto.MAX_NUMBER }) { "[ERROR] Numbers must be between ${Lotto.MIN_NUMBER} and ${Lotto.MAX_NUMBER}" }

        return numbers
    }

    fun validateBonusNumber(input: String, winningNumbers: List<Int>): Int {
        val bonus = input.toValidInt()

        // Validate bonus number: must be between 1-45 and not duplicate any of the winning numbers
        require(bonus in Lotto.MIN_NUMBER ..Lotto.MAX_NUMBER) { "[ERROR] Bonus number must be between ${Lotto.MIN_NUMBER} and ${Lotto.MAX_NUMBER}" }
        require(bonus !in winningNumbers) { "[ERROR] Bonus number must not duplicate winning numbers" }

        return bonus
    }
}
