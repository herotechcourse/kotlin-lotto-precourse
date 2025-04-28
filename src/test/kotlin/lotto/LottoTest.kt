package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse

class LottoTest {
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }
    @Test
    fun `create lotto with valid numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        assertEquals(numbers.sorted(), lotto.getNumbers())
    }

    @Test
    fun `throw exception when lotto has less than 6 numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @Test
    fun `throw exception when lotto has more than 6 numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @Test
    fun `throw exception when lotto has numbers outside range`() {
        val numbers = listOf(0, 1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @Test
    fun `count matches correctly`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 7, 8, 9, 10)
        assertEquals(2, lotto.countMatches(winningNumbers))
    }

    @Test
    fun `check bonus number correctly`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertTrue(lotto.hasBonusNumber(1))
        assertFalse(lotto.hasBonusNumber(7))
    }

    @Test
    fun `Lotto numbers must be between 1 and 45`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5, 46)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Lotto numbers must be between 1 and 45.")
    }

    @Test
    fun `Lotto numbers must be sorted in ascending order`() {
        val lotto = Lotto(listOf(6, 5, 4, 3, 2, 1))
        assertThat(lotto.getNumbers()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @ParameterizedTest
    @CsvSource(
        "'1,2,3,4,5,6', '1,2,3,4,5,6', 6",
        "'1,2,3,4,5,6', '7,8,9,10,11,12', 0",
        "'1,2,3,4,5,6', '1,2,3,7,8,9', 3"
    )
    fun `Count matches between lotto and winning numbers`(
        numbers: String,
        winningNumbers: String,
        expectedCount: Int
    ) {
        val lotto = Lotto(numbers.split(",").map { it.toInt() })
        val winningNumbersList = winningNumbers.split(",").map { it.toInt() }
        assertThat(lotto.countMatches(winningNumbersList)).isEqualTo(expectedCount)
    }
}
