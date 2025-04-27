package utils

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class InputValidatorTest{
    @Test
    fun `validate should throws IllegalArgument exception if input is blank or blank`(){
        val input  = " "
        assertThatThrownBy{ InputValidator.validate(input)}
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Input cannot be null or empty.")
    }

    @Test
    fun `validate should throw IllegalArgument exception if input is not divisible by 1000`(){
        val input = "1500"
        assertThatThrownBy{ InputValidator.validate(input)}
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Amount must be divisible by 1000.")
    }

    @Test
    fun `validate should throw IllegalArgument exception if input is non digit`(){
        val input = "One"
        assertThatThrownBy{ InputValidator.validate(input)}
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] You entered an invalid number. Please enter a valid integer.")
    }

    @Test
    fun `validate should pass if the input is valid number`(){
        val input = "1000"
        assertDoesNotThrow{ InputValidator.validate(input)}
    }

    @Test
    fun `bonus validator throws an exception if number is not in range`(){
        val input = "56"
        val numList = listOf(1,2,3,4,5,6)
        assertThatThrownBy{InputValidator.validateBonusNum(input,numList)}
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] The bonus number need to be in range 1 to 45.")
    }
}