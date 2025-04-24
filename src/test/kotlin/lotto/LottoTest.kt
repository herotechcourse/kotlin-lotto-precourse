package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {

    @Test
    fun `valid lotto numbers are sorted`() {
        val lotto = Lotto(listOf(6, 5, 4, 3, 2, 1))
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 5, 7])
    fun `invalid size throws exception`(size: Int) {
        val numbers = (1..size).toList()
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @Test
    fun `duplicate numbers throw exception`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `out of range numbers throw exception`(number: Int) {
        val numbers = listOf(1, 2, 3, 4, 5, number)
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @Test
    fun `countMatching works correctly`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.countMatching(listOf(1, 3, 5, 7, 9, 11))).isEqualTo(3)
    }

    @Test
    fun `contains bonus number check`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.contains(3)).isTrue()
        assertThat(lotto.contains(7)).isFalse()
    }
}