package lotto.archive

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThatThrownBy

class ValidateAmountTest {
    @Test
    fun `givenNonNumericAmount_whenValidated_thenThrowsTypeError`() {
        assertThatThrownBy {
            ValidateAmount.validate("ThisIsNonNumericAmount")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Type of amount must be numeric.")
    }

    @Test
    fun `givenTooSmallAmount_whenValidated_thenThrowsMinimumError`() {
        assertThatThrownBy {
            ValidateAmount.validate("700")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Amount must be at least 1,000.")
    }

    @Test
    fun `givenBlankAmount_whenValidated_thenThrowsTypeError`() {
        assertThatThrownBy {
            ValidateAmount.validate(" ")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Type of amount must be numeric.")
    }

    @Test
    fun `givenAmountStartsWithZero_whenValidated_thenThrowsFormatError`() {
        assertThatThrownBy {
            ValidateAmount.validate("01000")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Amount must not start with zero.")
    }

    @Test
    fun `givenExactThousandAmount_whenValidated_thenPass`() {
        ValidateAmount.validate("1000")
    }

    @Test
    fun `givenValidAmount_whenValidated_thenPass`() {
        ValidateAmount.validate("1100")
    }
}