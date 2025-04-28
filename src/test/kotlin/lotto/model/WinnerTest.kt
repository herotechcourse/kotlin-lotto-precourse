package lotto.model

import lotto.common.ErrorMessages
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinnerTest {

    @Nested
    @DisplayName("Winner constructor validation tests")
    inner class ConstructorValidation {

        @Test
        @DisplayName("Should create Winner with valid parameters")
        fun createWithValidParameters() {
            // Given
            val numbers = listOf(1, 2, 3, 4, 5, 6)
            val bonus = 7

            // When
            val winner = Winner(numbers, bonus)

            // Then
            assertThat(winner.getNumbers()).isEqualTo(numbers)
            assertThat(winner.getBonus()).isEqualTo(bonus)
        }

        @Test
        @DisplayName("Should throw exception when numbers list is empty")
        fun emptyNumbersListShouldThrowException() {
            // Given
            val numbers = emptyList<Int>()
            val bonus = 7

            // When, Then
            assertThatThrownBy { Winner(numbers, bonus) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(ErrorMessages.INVALID_WINNING_NUMBERS_TYPE)
        }

        @Test
        @DisplayName("Should throw exception when numbers list has invalid size")
        fun invalidSizeNumbersListShouldThrowException() {
            // Given
            val numbers = listOf(1, 2, 3, 4, 5) // Missing one number
            val bonus = 7

            // When, Then
            assertThatThrownBy { Winner(numbers, bonus) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(ErrorMessages.INVALID_WINNING_NUMBERS_SIZE)
        }

        @ParameterizedTest
        @ValueSource(ints = [0, 46])
        @DisplayName("Should throw exception when numbers contain invalid lotto number")
        fun invalidLottoNumberInListShouldThrowException(invalidNumber: Int) {
            // Given
            val numbers = listOf(1, 2, 3, 4, 5, invalidNumber)
            val bonus = 7

            // When, Then
            assertThatThrownBy { Winner(numbers, bonus) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(ErrorMessages.INVALID_WINNING_NUMBERS_UNIT)
        }

        @Test
        @DisplayName("Should throw exception when numbers list contains duplicates")
        fun duplicateNumbersInListShouldThrowException() {
            // Given
            val numbers = listOf(1, 2, 3, 4, 5, 5) // Duplicate 5
            val bonus = 7

            // When, Then
            assertThatThrownBy { Winner(numbers, bonus) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(ErrorMessages.INVALID_WINNING_NUMBERS_ITEM)
        }

        @ParameterizedTest
        @ValueSource(ints = [0, 46])
        @DisplayName("Should throw exception when bonus number is invalid")
        fun invalidBonusNumberShouldThrowException(invalidBonus: Int) {
            // Given
            val numbers = listOf(1, 2, 3, 4, 5, 6)
            val bonus = invalidBonus

            // When, Then
            assertThatThrownBy { Winner(numbers, bonus) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(ErrorMessages.INVALID_BONUS_NUMBER_UNIT)
        }

        @Test
        @DisplayName("Should throw exception when bonus number is in the numbers list")
        fun bonusNumberInListShouldThrowException() {
            // Given
            val numbers = listOf(1, 2, 3, 4, 5, 6)
            val bonus = 6 // Bonus is same as one of the numbers

            // When, Then
            assertThatThrownBy { Winner(numbers, bonus) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(ErrorMessages.INVALID_BONUS_NUMBER_ITEM)
        }
    }

    @Nested
    @DisplayName("Winner methods tests")
    inner class MethodTests {

        @Test
        @DisplayName("getNumbers should return correct list of numbers")
        fun getNumbersShouldReturnCorrectList() {
            // Given
            val numbers = listOf(1, 2, 3, 4, 5, 6)
            val bonus = 7
            val winner = Winner(numbers, bonus)

            // When
            val result = winner.getNumbers()

            // Then
            assertThat(result).isEqualTo(numbers)
        }

        @Test
        @DisplayName("getBonus should return correct bonus number")
        fun getBonusShouldReturnCorrectNumber() {
            // Given
            val numbers = listOf(1, 2, 3, 4, 5, 6)
            val bonus = 7
            val winner = Winner(numbers, bonus)

            // When
            val result = winner.getBonus()

            // Then
            assertThat(result).isEqualTo(bonus)
        }
    }
}