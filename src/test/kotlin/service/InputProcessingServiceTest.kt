package service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class InputProcessingServiceTest {
    @Test
    fun `validateInputInteger converts valid string to integer`() {
        val input = "123"

        val result = InputProcessingService.validateInputInteger(input)

        assertThat(result).isEqualTo(123)
    }
    
    @Test
    fun `validateInputInteger throws exception for non-integer input`() {
        val input = "abc"

        assertThrows<IllegalArgumentException> {
            InputProcessingService.validateInputInteger(input)
        }
    }
    
    @Test
    fun `validateInputInteger throws exception for decimal input`() {
        val input = "123.45"

        assertThrows<IllegalArgumentException> {
            InputProcessingService.validateInputInteger(input)
        }
    }

    @Test
    fun `validateNumberInLottoRange accepts numbers in range`() {
        val validNumbers = listOf(1, 10, 45)

        validNumbers.forEach { number ->
            InputProcessingService.validateNumberInLottoRange(number)
        }
    }

    @Test
    fun `validateNumberInLottoRange throws exception for numbers out of range`() {
        val invalidNumbers = listOf(0, 46, -1, 100)

        invalidNumbers.forEach { number ->
            assertThrows<IllegalArgumentException> {
                InputProcessingService.validateNumberInLottoRange(number)
            }
        }
    }

    @Test
    fun `splitWinningNumbers converts comma-separated string to list of integers`() {
        val input = "1,2,3,4,5,6"

        val result = InputProcessingService.splitWinningNumbers(input)

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `splitWinningNumbers throws exception for invalid numbers`() {
        val invalidInputs = listOf(
            "1,2,3,4,5,a",
            "1,2,3,4,5,0",
            "1,2,3,4,5,46"
        )

        invalidInputs.forEach { input ->
            assertThrows<IllegalArgumentException> {
                InputProcessingService.splitWinningNumbers(input)
            }
        }
    }
}