package lotto.view

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows

class InputViewTest {
    private fun validateNumberInput(input: String): Int {
        return input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
    }

    private fun validateWinningNumbersInput(input: String): List<Int> {
        return input.split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter valid numbers.") }
    }

    @Test
    fun `valid purchase amount input`() {
        val amount = validateNumberInput("8000")
        assertEquals(8000, amount)
    }

    @Test
    fun `throw exception when purchase amount is invalid`() {
        val inputs = listOf("1000j", "abc", "1.5", "")
        inputs.forEach { input ->
            val exception = assertThrows<IllegalArgumentException> {
                validateNumberInput(input)
            }
            assertEquals("[ERROR] Please enter a valid number.", exception.message)
        }
    }

    @Test
    fun `throw exception when purchase amount is not divisible by 1000`() {
        val amounts = listOf(999, 1001, 1500)
        amounts.forEach { amount ->
            val exception = assertThrows<IllegalArgumentException> {
                if (amount % 1000 != 0) throw IllegalArgumentException("[ERROR] Amount must be divisible by 1000.")
            }
            assertEquals("[ERROR] Amount must be divisible by 1000.", exception.message)
        }
    }

    @Test
    fun `valid winning numbers input`() {
        val numbers = validateWinningNumbersInput("1,2,3,4,5,6")
        assertEquals(listOf(1, 2, 3, 4, 5, 6), numbers)
    }

    @Test
    fun `throw exception when winning numbers count is not 6 or out of range`() {
        val inputs = listOf("1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,6,7,8")
        inputs.forEach { input ->
            val exception = assertThrows<IllegalArgumentException> {
                val numbers = validateWinningNumbersInput(input)
                if (numbers.size != 6) throw IllegalArgumentException("[ERROR] Please enter exactly 6 numbers.")
            }
            assertEquals("[ERROR] Please enter exactly 6 numbers.", exception.message)
        }
    }

    @Test
    fun `throw exception when winning numbers are out of range`() {
        val inputs = listOf("0,1,2,3,4,5", "1,2,3,4,5,46", "-1,1,2,3,4,5")
        inputs.forEach { input ->
            val exception = assertThrows<IllegalArgumentException> {
                val numbers = validateWinningNumbersInput(input)
                if (!numbers.all { it in 1..45 }) throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
            }
            assertEquals("[ERROR] Lotto numbers must be between 1 and 45.", exception.message)
        }
    }

    @Test
    fun `throw exception when winning numbers are duplicated`() {
        val input = "1,1,2,3,4,5"
        val exception = assertThrows<IllegalArgumentException> {
            val numbers = validateWinningNumbersInput(input)
            if (numbers.distinct().size != numbers.size) throw IllegalArgumentException("[ERROR] Numbers must be unique.")
        }
        assertEquals("[ERROR] Numbers must be unique.", exception.message)
    }

    @Test
    fun `valid bonus number input`() {
        val bonusNumber = validateNumberInput("7")
        assertEquals(7, bonusNumber)
    }

    @Test
    fun `throw exception when bonus number is out of range`() {
        val inputs = listOf("0", "46", "-1")
        inputs.forEach { input ->
            val exception = assertThrows<IllegalArgumentException> {
                val bonusNumber = validateNumberInput(input)
                if (bonusNumber !in 1..45) throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
            }
            assertEquals("[ERROR] Bonus number must be between 1 and 45.", exception.message)
        }
    }

    @Test
    fun `throw exception when bonus number is in winning numbers`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 1
        val exception = assertThrows<IllegalArgumentException> {
            if (bonusNumber in winningNumbers) throw IllegalArgumentException("[ERROR] Bonus number must not be in winning numbers.")
        }
        assertEquals("[ERROR] Bonus number must not be in winning numbers.", exception.message)
    }
} 