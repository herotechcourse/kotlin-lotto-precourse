package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidateTest {

    // ------- validateAmount Tests --------

    @Test
    fun `validateAmount with valid input returns correct amount`() {
        assertEquals(3000, InputValidate.validateAmount("3000"))
    }

    @Test
    fun `validateAmount throws if input is not a number`() {
        val exception = assertThrows<IllegalArgumentException> {
            InputValidate.validateAmount("abc")
        }
        assertEquals("[ERROR] Input purchaseAmount must be integer", exception.message)
    }

    @Test
    fun `validateAmount throws if input is not divisible by 1000`() {
        val exception = assertThrows<IllegalArgumentException> {
            InputValidate.validateAmount("2500")
        }
        assertEquals("[ERROR] Input purchaseAmount must be divided by 1000", exception.message)
    }

    @Test
    fun `validateAmount throws if input is zero`() {
        val exception = assertThrows<IllegalArgumentException> {
            InputValidate.validateAmount("0")
        }
        assertEquals("[ERROR] Input purchaseAmount must be positive integer", exception.message)
    }

    @Test
    fun `validateAmount throws if input is negative`() {
        val exception = assertThrows<IllegalArgumentException> {
            InputValidate.validateAmount("-1")
        }
        assertEquals("[ERROR] Input purchaseAmount must be positive integer", exception.message)
    }

    @Test
    fun `validateAmount throws if input is empty`() {
        val exception = assertThrows<IllegalArgumentException> {
            InputValidate.validateAmount(" ")
        }
        assertEquals("[ERROR] Input purchaseAmount must be integer", exception.message)
    }

    // ------- validateWinningNumber Tests --------

    @Test
    fun `validateWinningNumber accepts valid input`() {
        val input = "1, 2, 3, 4, 5, 6"
        val result = InputValidate.validateWinningNumber(input)
        assertEquals(listOf(1, 2, 3, 4, 5, 6), result)
    }

    @Test
    fun `validateWinningNumber throws on duplicate numbers`() {
        val input = "1, 2, 2, 3, 4, 5"
        val exception = assertThrows<IllegalArgumentException> {
            InputValidate.validateWinningNumber(input)
        }
        assertEquals("[ERROR] Winning numbers format is not correct.", exception.message)
    }

    @Test
    fun `validateWinningNumber throws if input is less than 6 numbers `() {
        val input = "1, 2, 3, 4,5"
        val exception = assertThrows<IllegalArgumentException> {
            InputValidate.validateWinningNumber(input)
        }
        assertEquals("[ERROR] Winning numbers format is not correct.", exception.message)
    }

    @Test
    fun `validateWinningNumber throws if any number is out of range`() {
        val input = "1, 2, 3, 4, 5, 46"
        val exception = assertThrows<IllegalArgumentException> {
            InputValidate.validateWinningNumber(input)
        }
        assertEquals("[ERROR] Lotto numbers must be between 1 and 45.", exception.message)
    }

    @Test
    fun `validateWinningNumber throws if any number is negative`() {
        val input = "1, 2, 3, 4, 5, -1"
        val exception = assertThrows<IllegalArgumentException> {
            InputValidate.validateWinningNumber(input)
        }
        assertEquals("[ERROR] Lotto numbers must be between 1 and 45.", exception.message)
    }

    @Test
    fun `validateWinningNumber throws if any number is not integer`() {
        val input = "1, 2, 3, 4, 5, a"
        val exception = assertThrows<IllegalArgumentException> {
            InputValidate.validateWinningNumber(input)
        }
        assertEquals("[ERROR] Input must be integer", exception.message)
    }



    // ------- validateBonusNumber Tests --------

    @Test
    fun `validateBonusNumber accepts valid input`() {
        val result = InputValidate.validateBonusNumber("7", listOf(1, 2, 3, 4, 5, 6))
        assertEquals(7, result)
    }

    @Test
    fun `validateBonusNumber throws if not an integer`() {
        val exception = assertThrows<IllegalArgumentException> {
            InputValidate.validateBonusNumber("abc", listOf(1, 2, 3, 4, 5, 6))
        }
        assertEquals("[ERROR] Bonus number must be integer", exception.message)
    }

    @Test
    fun `validateBonusNumber throws if out of range`() {
        val exception = assertThrows<IllegalArgumentException> {
            InputValidate.validateBonusNumber("50", listOf(1, 2, 3, 4, 5, 6))
        }
        assertEquals("[ERROR] Bonus number must between 1 to 45", exception.message)
    }

    @Test
    fun `validateBonusNumber throws if bonus number is in winning numbers`() {
        val exception = assertThrows<IllegalArgumentException> {
            InputValidate.validateBonusNumber("3", listOf(1, 2, 3, 4, 5, 6))
        }
        assertEquals("[ERROR] Bonus number must not be one of the winning numbers.", exception.message)
    }

    // ------- validateTickets Tests --------

    @Test
    fun `validateTickets returns the same list if not empty`() {
        val tickets = mutableListOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(7, 8, 9, 10, 11, 12)
        )
        val result = InputValidate.validateTickets(tickets)
        assertEquals(tickets, result)
    }

    @Test
    fun `validateTickets throws if list is empty`() {
        val exception = assertThrows<IllegalArgumentException> {
            InputValidate.validateTickets(mutableListOf())
        }
        assertEquals("[ERROR] Tickets are empty", exception.message)
    }
}
