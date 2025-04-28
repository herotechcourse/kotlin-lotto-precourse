package lotto.common

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ParserTest {
    
    @Nested
    @DisplayName("toInt function tests")
    inner class ToIntTests {
        
        @Test
        @DisplayName("should convert valid string to int")
        fun toInt_validInput_returnsInt() {
            // Given
            val input = "123"
            
            // When
            val result = Parser.toInt(input)
            
            // Then
            assertThat(result).isEqualTo(123)
        }
        
        @Test
        @DisplayName("should throw exception for non-numeric input")
        fun toInt_nonNumericInput_throwsException() {
            // Given
            val input = "abc"
            
            // Then
            assertThatThrownBy { Parser.toInt(input) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(ErrorMessages.INVALID_INPUT_NUMBER)
        }
        
        @Test
        @DisplayName("should throw exception for empty string")
        fun toInt_emptyString_throwsException() {
            // Given
            val input = ""
            
            // Then
            assertThatThrownBy { Parser.toInt(input) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(ErrorMessages.INVALID_INPUT_NUMBER)
        }
    }
    
    @Nested
    @DisplayName("toIntList function tests")
    inner class ToIntListTests {
        
        @Test
        @DisplayName("should convert comma-separated values to list of integers")
        fun toIntList_validInput_returnsListOfInts() {
            // Given
            val input = "1,2,3,4,5"
            
            // When
            val result = Parser.toIntList(input)
            
            // Then
            assertThat(result).containsExactly(1, 2, 3, 4, 5)
        }
        
        @Test
        @DisplayName("should handle whitespace around numbers")
        fun toIntList_inputWithSpaces_returnsListOfInts() {
            // Given
            val input = " 1, 2 , 3,4 , 5 "
            
            // When
            val result = Parser.toIntList(input)
            
            // Then
            assertThat(result).containsExactly(1, 2, 3, 4, 5)
        }
        
        @Test
        @DisplayName("should throw exception when any value is non-numeric")
        fun toIntList_invalidInput_throwsException() {
            // Given
            val input = "1,2,abc,4,5"
            
            // Then
            assertThatThrownBy { Parser.toIntList(input) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(ErrorMessages.INVALID_INPUT_NUMBER)
        }
        
        @Test
        @DisplayName("should throw exception for empty string")
        fun toIntList_emptyString_throwsException() {
            // Given
            val input = ""
            
            // Then
            assertThatThrownBy { Parser.toIntList(input) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(ErrorMessages.INVALID_INPUT_NUMBER)
        }
    }
}