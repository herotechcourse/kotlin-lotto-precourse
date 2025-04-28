package input.validation

import error.config.INVALID_LOTTO_NUMBER_MSG
import error.config.TICKET_AMOUNT_MUST_BE_MULTIPLE_MSG
import error.config.TICKET_AMOUNT_MUST_BE_POSITIVE_MSG
import lotto.config.TICKET_PRICE
import org.junit.jupiter.api.Assertions.assertEquals

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoValidatorTest {

    @Test
    fun `given valid lotto number, when validateAndReturnLottoNumber called, then return same number`() {
        // Given
        val validNumber = 10

        // When
        val result = validateAndReturnLottoNumber(validNumber)

        // Then
        assertEquals(validNumber, result)
    }

    @Test
    fun `given invalid lotto number, when validateAndReturnLottoNumber called, then throw IllegalArgumentException`() {
        // Given
        val invalidNumber = 0

        // When & Then
        val exception = assertThrows<IllegalArgumentException> {
            validateAndReturnLottoNumber(invalidNumber)
        }
        assertEquals(INVALID_LOTTO_NUMBER_MSG, exception.message)
    }

    @Test
    fun `given valid ticket amount, when validateAndReturnTicketAmount called, then return same amount`() {
        // Given
        val validAmount = TICKET_PRICE * 2

        // When
        val result = validateAndReturnTicketAmount(validAmount)

        // Then
        assertEquals(validAmount, result)
    }

    @Test
    fun `given non-positive ticket amount, when validateAndReturnTicketAmount called, then throw IllegalArgumentException`() {
        // Given
        val nonPositiveAmount = 0

        // When & Then
        val exception = assertThrows<IllegalArgumentException> {
            validateAndReturnTicketAmount(nonPositiveAmount)
        }
        assertEquals(TICKET_AMOUNT_MUST_BE_POSITIVE_MSG, exception.message)
    }

    @Test
    fun `given ticket amount not multiple of price, when validateAndReturnTicketAmount called, then throw IllegalArgumentException`() {
        // Given
        val invalidAmount = TICKET_PRICE + 1

        // When & Then
        val exception = assertThrows<IllegalArgumentException> {
            validateAndReturnTicketAmount(invalidAmount)
        }
        assertEquals(TICKET_AMOUNT_MUST_BE_MULTIPLE_MSG, exception.message)
    }
}
