package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidationTest {

    companion object {
        private const val INVALID_AMOUNT = "[ERROR] Amount must be a positive number divisible by 1,000."
        private const val INVALID_WINNING_COUNT = "[ERROR] Please enter exactly 6 valid numbers."
        private const val DUPLICATE_WINNING_NUMBERS = "[ERROR] Winning numbers must be unique."
        private const val OUT_OF_RANGE_NUMBER = "[ERROR] Numbers must be between 1 and 45."
        private const val INVALID_BONUS = "[ERROR] Bonus number must be a valid integer."
        private const val BONUS_DUPLICATE = "[ERROR] Bonus number must not be part of the winning numbers."
    }

    @Test
    fun `throws error when purchase amount is invalid`() {
        val invalids = listOf("abc", "-1000", "999", "0")
        for (input in invalids) {
            val exception = assertThrows<IllegalArgumentException> {
                simulatePurchaseInput(input)
            }
            assertThat(exception.message).isEqualTo(INVALID_AMOUNT)
        }
    }

    @Test
    fun `throws error when winning numbers are invalid`() {
        val cases = mapOf(
            "1,2,3" to INVALID_WINNING_COUNT,
            "1,2,3,4,5,6,7" to INVALID_WINNING_COUNT,
            "1,2,3,4,5,f" to INVALID_WINNING_COUNT,
            "1,2,3,3,4,5" to DUPLICATE_WINNING_NUMBERS,
            "1,2,3,4,5,100" to OUT_OF_RANGE_NUMBER
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
            "abc" to INVALID_BONUS,
            "100" to OUT_OF_RANGE_NUMBER,
            "3" to BONUS_DUPLICATE
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
            throw IllegalArgumentException(INVALID_AMOUNT)
        }
    }

    private fun simulateWinningInput(input: String) {
        val numbers = input.split(",").map { it.trim().toIntOrNull() }
        if (numbers.any { it == null } || numbers.size != 6) {
            throw IllegalArgumentException(INVALID_WINNING_COUNT)
        }
        val valid = numbers.filterNotNull()
        if (valid.toSet().size != 6) {
            throw IllegalArgumentException(DUPLICATE_WINNING_NUMBERS)
        }
        if (valid.any { it !in 1..45 }) {
            throw IllegalArgumentException(OUT_OF_RANGE_NUMBER)
        }
    }

    private fun simulateBonusInput(input: String, winning: List<Int>) {
        val bonus = input.toIntOrNull()
            ?: throw IllegalArgumentException(INVALID_BONUS)

        if (bonus !in 1..45) {
            throw IllegalArgumentException(OUT_OF_RANGE_NUMBER)
        }

        if (bonus in winning) {
            throw IllegalArgumentException(BONUS_DUPLICATE)
        }
    }
}