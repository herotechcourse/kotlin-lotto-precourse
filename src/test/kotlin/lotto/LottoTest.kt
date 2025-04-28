package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    @DisplayName("Throws exception when lotto numbers exceed six")
    fun constructorThrowsWhenSizeExceedsSix() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    @DisplayName("Throws exception when lotto numbers contain duplicates")
    fun constructorThrowsWhenDuplicatesExist() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    @DisplayName("Throws exception when lotto numbers are below minimum range")
    fun constructorThrowsWhenBelowMinRange() {
        val belowMin = Config.MIN_LOTTO_NUMBER - 1
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(belowMin, 2, 3, 4, 5, 6))
        }
    }

    @Test
    @DisplayName("Throws exception when lotto numbers exceed maximum range")
    fun constructorThrowsWhenAboveMaxRange() {
        val aboveMax = Config.MAX_LOTTO_NUMBER + 1
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, aboveMax))
        }
    }

    @Test
    @DisplayName("getNumbers returns the original list of numbers")
    fun getNumbersReturnsOriginalList() {
        val numbers = listOf(5, 12, 23, 34, 41, 45)
        val lotto = Lotto(numbers)
        assertThat(lotto.getNumbers()).isEqualTo(numbers)
    }

    @Test
    @DisplayName("countMatchingNumbers returns correct match count")
    fun countMatchingNumbersReturnsCorrectCount() {
        val winningNumbers = listOf(4, 5, 6, 7, 8, 9)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.countMatchingNumbers(winningNumbers)).isEqualTo(3)
    }

    @Test
    @DisplayName("hasNumber returns true when number is present")
    fun hasNumberReturnsTrueWhenPresent() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.hasNumber(3)).isTrue()
    }

    @Test
    @DisplayName("hasNumber returns false when number is absent")
    fun hasNumberReturnsFalseWhenAbsent() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.hasNumber(7)).isFalse()
    }
}
