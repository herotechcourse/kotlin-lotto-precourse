package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

class ValidatorTest {

    @Test
    fun `validatePurchaseAmount should return valid integer`() {
        val result = Validator.validatePurchaseAmount("5000")
        assertEquals(5000, result)
    }

    @Test
    fun `validatePurchaseAmount should throw exception for non-numeric input`() {
        val exception = assertThrows<IllegalArgumentException> {
            Validator.validatePurchaseAmount("abc")
        }
        assertEquals("[ERROR] Please enter a valid number.", exception.message)
    }

    @Test
    fun `validatePurchaseAmount should throw exception for negative amount`() {
        val exception = assertThrows<IllegalArgumentException> {
            Validator.validatePurchaseAmount("-1000")
        }
        assertEquals("[ERROR] Purchase amount must be positive.", exception.message)
    }

    @Test
    fun `validatePurchaseAmount should throw exception for zero amount`() {
        val exception = assertThrows<IllegalArgumentException> {
            Validator.validatePurchaseAmount("0")
        }
        assertEquals("[ERROR] Purchase amount must be positive.", exception.message)
    }

    @Test
    fun `validatePurchaseAmount should throw exception for amount not divisible by 1000`() {
        val exception = assertThrows<IllegalArgumentException> {
            Validator.validatePurchaseAmount("1500")
        }
        assertEquals("[ERROR] Purchase amount must be divisible by 1,000.", exception.message)
    }

    @Test
    fun `validateBonusNumber should return valid integer`() {
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val result = Validator.validateBonusNumber("7", winningNumbers)
        assertEquals(7, result)
    }

    @Test
    fun `validateBonusNumber should throw exception for non-numeric input`() {
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val exception = assertThrows<IllegalArgumentException> {
            Validator.validateBonusNumber("abc", winningNumbers)
        }
        assertEquals("[ERROR] Please enter a valid number.", exception.message)
    }

    @Test
    fun `validateBonusNumber should throw exception for number less than 1`() {
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val exception = assertThrows<IllegalArgumentException> {
            Validator.validateBonusNumber("0", winningNumbers)
        }
        assertEquals("[ERROR] Bonus number must be between 1 and 45.", exception.message)
    }

    @Test
    fun `validateBonusNumber should throw exception for number greater than 45`() {
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val exception = assertThrows<IllegalArgumentException> {
            Validator.validateBonusNumber("46", winningNumbers)
        }
        assertEquals("[ERROR] Bonus number must be between 1 and 45.", exception.message)
    }

    @Test
    fun `validateBonusNumber should throw exception for number among winning numbers`() {
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val exception = assertThrows<IllegalArgumentException> {
            Validator.validateBonusNumber("3", winningNumbers)
        }
        assertEquals("[ERROR] Bonus number must not be among the winning numbers.", exception.message)
    }

    @Test
    fun `validateWinningNumbers should return valid Lotto object`() {
        val result = Validator.validateWinningNumbers("1, 2, 3, 4, 5, 6")
        assertTrue(result.contains(1))
        assertTrue(result.contains(2))
        assertTrue(result.contains(3))
        assertTrue(result.contains(4))
        assertTrue(result.contains(5))
        assertTrue(result.contains(6))
    }

    @Test
    fun `validateWinningNumbers should throw exception for non-numeric input`() {
        val exception = assertThrows<IllegalArgumentException> {
            Validator.validateWinningNumbers("1, 2, abc, 4, 5, 6")
        }
        assertEquals("[ERROR] Please enter valid numbers separated by commas.", exception.message)
    }
}