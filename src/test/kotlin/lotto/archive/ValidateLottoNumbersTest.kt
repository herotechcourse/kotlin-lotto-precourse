package lotto.archive

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals

/**
 *  [ Test list ]
 *  1. valid numbers        Pass
 *  2. duplicate numbers    Fail
 *  3. invalid size         Fail
 *  4. Out of range         Fail
 *  5. Empty list           Fail
 */
class ValidateLottoNumbersTest {

    @Test
    fun `givenValidNumbers_whenValidateLottoNumbers_thenDoesNotThrowException`() {
        // given
        val validNumbers = listOf(1, 2, 3, 4, 5 ,6)

        // when
        val validator = ValidateLottoNumbers()

        // then
        assertDoesNotThrow {
            validator.validate(validNumbers)
        }
    }

    @Test
    fun `givenDuplicateNumbers_whenValidateLottoNumbers_thenThrowsException`() {
        // given
        val duplicateNumbers = listOf(1, 2, 3, 4, 5 ,5)

        // when
        val validator = ValidateLottoNumbers()

        // then
        val exception = assertThrows<IllegalArgumentException> {
            validator.validate(duplicateNumbers)
        }
        assertEquals("[ERROR] Lotto numbers must be unique.", exception.message)
    }

    @Test
    fun `givenInvalidSize_whenValidateLottoNumbers_thenThrowsException`() {
        // given
        val invalidSize = listOf(1, 2, 3, 4, 5)

        // when
        val validator = ValidateLottoNumbers()

        // then
        val exception = assertThrows<IllegalArgumentException> {
            validator.validate(invalidSize)
        }
        assertEquals("[ERROR] Lotto must contain exactly 6 numbers.", exception.message)
    }

    @Test
    fun `givenOutOfRange_whenValidateLottoNumbers_thenThrowsException`() {
        // given
        val OutOfRangeNumbers1 = listOf(1, 2, 3, 4, 5, 46)
        val OutOfRangeNumbers2 = listOf(0, 2, 3, 4, 5, 45)

        // when
        val validator = ValidateLottoNumbers()

        // then(1)
        val exception1 = assertThrows<IllegalArgumentException> {
            validator.validate(OutOfRangeNumbers1)
        }
        assertEquals("[ERROR] Lotto numbers must be between 1 and 45.", exception1.message)

        // then(2)
        val exception2 = assertThrows<IllegalArgumentException> {
            validator.validate(OutOfRangeNumbers2)
        }
        assertEquals("[ERROR] Lotto numbers must be between 1 and 45.", exception2.message)
    }

    @Test
    fun `givenEmptyList_whenValidateLottoNumbers_thenThrowsException`() {
        // given
        val emptyList = listOf<Int>()

        // when
        val validator = ValidateLottoNumbers()

        // then
        val exception = assertThrows<IllegalArgumentException> {
            validator.validate(emptyList)
        }
        assertEquals("[ERROR] Lotto must not be empty.", exception.message)
    }
}