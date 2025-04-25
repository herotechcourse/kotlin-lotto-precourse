package lotto.service.validation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals

/**
 *  [ Test list ]
 *  1. Valid winning numbers        Pass
 *  2. Non-numeric input            Fail
 *  3. MixedType input              Fail
 *  4. Empty list                   Fail
 *  5. Duplicate winning numbers    Fail
 *  6. Invalid size                 Fail
 *  7. Out of range(1-45)           Fail
 */
class ValidateWinningMainTest {

    @Test
    fun `givenValidWinningNumbers_whenValidateWinningMain_thenDoesNotThrowException`() {
        // given
        val validWinningNumbers = listOf(1, 2, 3, 4, 5, 45)

        // when
        val validator = ValidateWinningMain()

        // then
        assertDoesNotThrow {
            validator.validate(validWinningNumbers)
        }
    }

    @Test
    fun `givenNonNumericInput_whenValidateWinningMain_thenThrowsException`() {
        // given
        val nonNumericInput = listOf("abc", "def", "ghi")

        // when
        val validator = ValidateWinningMain()

        // then
        val exception = assertThrows<IllegalArgumentException> {
            validator.typeValidate(nonNumericInput)
        }
        assertEquals("[ERROR] Winning numbers must be of integer type.", exception.message)
    }

    @Test
    fun `givenMixedTypeInput_whenValidateWinningMain_thenThrowsException`() {
        // given
        val mixedTypeInput = listOf(1, 2, 3, 4, 5, "6")

        // when
        val validator = ValidateWinningMain()

        // then
        val exception = assertThrows<IllegalArgumentException> {
            validator.typeValidate(mixedTypeInput)
        }
        assertEquals("[ERROR] Winning numbers must be of integer type.", exception.message)
    }

    @Test
    fun `givenEmptyList_whenValidateWinningMain_thenThrowsException`() {
        // given
        val emptyList = listOf<Int>()

        // when
        val validator = ValidateWinningMain()

        // then
        val exception = assertThrows<IllegalArgumentException> {
            validator.validate(emptyList)
        }
        assertEquals("[ERROR] Winning numbers must not be empty.", exception.message)
    }

    @Test
    fun `givenDuplicateWinningNumbers_whenValidateWinningMain_thenThrowsException`() {
        // given
        val duplicateWinningNumbers = listOf(1, 1, 2, 3, 4, 5)

        // when
        val validator = ValidateWinningMain()

        // then
        val exception = assertThrows<IllegalArgumentException> {
            validator.validate(duplicateWinningNumbers)
        }
        assertEquals("[ERROR] Winning numbers must be unique.", exception.message)
    }

    @Test
    fun `givenInvalidSize_whenValidateWinningMain_thenThrowsException`() {
        // given
        val invalidSize = listOf(1, 2, 3, 4, 5)

        // when
        val validator = ValidateWinningMain()

        // then
        val exception = assertThrows<IllegalArgumentException> {
            validator.validate(invalidSize)
        }
        assertEquals("[ERROR] Winning numbers must contain exactly 6 numbers.", exception.message)
    }

    @Test
    fun `givenOutOfRange_whenValidateWinningMain_thenThrowsException`() {
        // given(1), (2)
        val outOfRangeWinningNumbers1 = listOf(0, 1, 2, 3, 4, 5)
        val outOfRangeWinningNumbers2 = listOf(1, 2, 3, 4, 5, 46)

        // when
        val validator = ValidateWinningMain()

        // then(1), (2)
        val exception1 = assertThrows<IllegalArgumentException> {
            validator.validate(outOfRangeWinningNumbers1)
        }
        val exception2 = assertThrows<IllegalArgumentException> {
            validator.validate(outOfRangeWinningNumbers2)
        }
        assertEquals("[ERROR] Winning numbers must be between 1 and 45.", exception1.message)
        assertEquals("[ERROR] Winning numbers must be between 1 and 45.", exception2.message)
    }
}