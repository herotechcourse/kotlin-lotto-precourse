package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `throws an exception when lotto numbers are out of range`(invalidNumber: Int) {
        val numbers = listOf(1, 2, 3, 4, 5, invalidNumber)
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @Test
    fun `returns sorted numbers`() {
        val lotto = Lotto(listOf(6, 1, 4, 3, 5, 2))
        assertThat(lotto.getNumbers()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `counts matching numbers correctly`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 7, 8, 9)
        
        assertThat(lotto.countMatches(winningNumbers)).isEqualTo(3)
    }

    @Test
    fun `checks if number is contained`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        
        assertThat(lotto.containsNumber(1)).isTrue
        assertThat(lotto.containsNumber(7)).isFalse
    }
}
