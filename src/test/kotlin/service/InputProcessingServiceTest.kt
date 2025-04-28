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

}