package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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
    fun `constructor should create object with valid lotto numbers`() {
        // given
        val validNumbers = listOf(1, 2, 3, 4, 5, 6)

        // when
        val lotto = Lotto(validNumbers)

        // then
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `constructor should throw exception when numbers size is not 6`() {
        // given
        val tooFewNumbers = listOf(1, 2, 3, 4, 5)

        // when & then
        assertThatThrownBy { Lotto(tooFewNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("exactly 6 numbers")
    }

    @Test
    fun `constructor should throw exception when numbers are out of range`() {
        // given
        val numbersWithTooLowValue = listOf(0, 1, 2, 3, 4, 5)
        val numbersWithTooHighValue = listOf(1, 2, 3, 4, 5, 46)

        // when & then
        assertThatThrownBy { Lotto(numbersWithTooLowValue) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("between 1 and 45")

        assertThatThrownBy { Lotto(numbersWithTooHighValue) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("between 1 and 45")
    }

    @Test
    fun `getNumbers should return numbers sorted in ascending order`() {
        // given
        val unsortedNumbers = listOf(6, 1, 3, 5, 2, 4)
        val lotto = Lotto(unsortedNumbers)

        // when
        val result = lotto.getNumbers()

        // then
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `contains should return true when lotto has the number`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)

        // when
        val result = lotto.contains(3)

        // then
        assertThat(result).isTrue()
    }

    @Test
    fun `contains should return false when lotto does not have the number`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)

        // when
        val result = lotto.contains(7)

        // then
        assertThat(result).isFalse()
    }

    @Test
    fun `contains should throw exception when number is out of range`() {
        // given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // when & then
        assertThatThrownBy { lotto.contains(0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("between 1 and 45")

        assertThatThrownBy { lotto.contains(46) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("between 1 and 45")
    }

    @Test
    fun `countMatchingNumbers should return correct count of matching numbers`() {
        // given
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(lottoNumbers)
        val winningNumbers = listOf(1, 3, 5, 7, 9, 11)

        // when
        val matchCount = lotto.countMatchingNumbers(winningNumbers)

        // then
        assertThat(matchCount).isEqualTo(3) // matches: 1, 3, 5
    }

    @Test
    fun `countMatchingNumbers should return zero when no numbers match`() {
        // given
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(lottoNumbers)
        val winningNumbers = listOf(7, 8, 9, 10, 11, 12)

        // when
        val matchCount = lotto.countMatchingNumbers(winningNumbers)

        // then
        assertThat(matchCount).isZero()
    }

    @Test
    fun `countMatchingNumbers should return 6 when all numbers match`() {
        // given
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(lottoNumbers)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        // when
        val matchCount = lotto.countMatchingNumbers(winningNumbers)

        // then
        assertThat(matchCount).isEqualTo(6)
    }
}
