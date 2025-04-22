package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidationTest {

    @Test
    fun `throws error when purchase amount is invalid`() {
        val invalids = listOf("abc", "-1000", "999", "0")
        for (input in invalids) {
            val exception = assertThrows<IllegalArgumentException> {
                simulatePurchaseInput(input)
            }
            assertThat(exception.message).isEqualTo("[ERROR] Amount must be a positive number divisible by 1,000.")
        }
    }

    @Test
    fun `throws error when winning numbers are invalid`() {
        val cases = mapOf(
            "1,2,3" to "[ERROR] Please enter exactly 6 valid numbers.",
            "1,2,3,4,5,6,7" to "[ERROR] Please enter exactly 6 valid numbers.",
            "1,2,3,4,5,f" to "[ERROR] Please enter exactly 6 valid numbers.",
            "1,2,3,3,4,5" to "[ERROR] Winning numbers must be unique.",
            "1,2,3,4,5,100" to "[ERROR] Numbers must be between 1 and 45."
        )
        for ((input, expectedMessage) in cases) {
            val exception = assertThrows<IllegalArgumentException> {
                simulateWinningInput(input)
            }
            assertThat(exception.message).isEqualTo(expectedMessage)
        }
    }

    @Test
    fun `throws error when bonus number is invalid`() {
        val winning = listOf(1, 2, 3, 4, 5, 6)
        val cases = mapOf(
            "abc" to "[ERROR] Bonus number must be a valid integer.",
            "100" to "[ERROR] Bonus number must be between 1 and 45.",
            "3" to "[ERROR] Bonus number must not be part of the winning numbers."
        )
        for ((input, expectedMessage) in cases) {
            val exception = assertThrows<IllegalArgumentException> {
                simulateBonusInput(input, winning)
            }
            assertThat(exception.message).isEqualTo(expectedMessage)
        }
    }

    // Helpers to simulate internal parsing logic from InputView
    private fun simulatePurchaseInput(input: String) {
        val amount = input.toIntOrNull()
        if (amount == null || amount <= 0 || amount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] Amount must be a positive number divisible by 1,000.")
        }
    }

    private fun simulateWinningInput(input: String) {
        val numbers = input.split(",").map { it.trim().toIntOrNull() }
        if (numbers.any { it == null } || numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] Please enter exactly 6 valid numbers.")
        }
        val valid = numbers.filterNotNull()
        if (valid.toSet().size != 6) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be unique.")
        }
        if (valid.any { it !in 1..45 }) {
            throw IllegalArgumentException("[ERROR] Numbers must be between 1 and 45.")
        }
    }

    private fun simulateBonusInput(input: String, winning: List<Int>) {
        val bonus = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Bonus number must be a valid integer.")

        if (bonus !in 1..45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        }

        if (bonus in winning) {
            throw IllegalArgumentException("[ERROR] Bonus number must not be part of the winning numbers.")
        }
    }
}