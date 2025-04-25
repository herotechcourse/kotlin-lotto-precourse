package lotto

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import utils.InputValidator

class InputValidatorTest{
    @Test
    fun `validate should throws IllegalArgument exception if input is blank or blank`(){
        val input  = " "
        assertThatThrownBy{ InputValidator.validate(input)}
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Input cannot be null or empty.")
    }

    @Test
    fun `validate should throw IllegalArgument exception if input is not divisible by 1000`(){
        val input = "1500"
        assertThatThrownBy{ InputValidator.validate(input)}
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Amount must be divisible by 1000.")
    }

    @Test
    fun `validate should throw IllegalArgument exception if input is non digit`(){
        val input = "One"
        assertThatThrownBy{ InputValidator.validate(input)}
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("You entered an invalid number. Please enter a valid integer.")
    }

    @Test
    fun `validate should pass if the input is valid number`(){
        val input = "1000"
        assertDoesNotThrow{ InputValidator.validate(input)}
    }
}