package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy


class LottoTest {
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: Implement production code to pass the test
    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // TODO: Implement tests based on the added features
    @Test
    fun `create Lotto with valid numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        assertThat(lotto.getSortedNumbers()).isEqualTo(numbers)
    }

    @Test
    fun `create Lotto with invalid size`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Lotto must contain exactly 6 numbers")
    }

    @Test
    fun `create Lotto with invalid range`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5, 46)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Lotto numbers must be between 1 and 45")
    }

    @Test
    fun `create Lotto with duplicate numbers`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Lotto numbers must be unique")
    }

    @Test
    fun `match count should return correct count`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winning = Lotto(listOf(1, 2, 3, 10, 11, 12))
        assertThat(lotto.matchCount(winning)).isEqualTo(3)
    }

    @Test
    fun `contains should return true when number exists`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.contains(3)).isTrue()
    }

    @Test
    fun `contains should return false when number doesn't exist`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.contains(10)).isFalse()
    }
}
