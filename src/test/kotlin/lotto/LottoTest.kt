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

    // TODO: Implement production code to pass the test
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
    fun `returns correct match count`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 10, 11, 12)
        
        assertThat(lotto.matchCount(winningNumbers)).isEqualTo(3)
    }
    
    @Test
    fun `correctly checks if number is contained`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        
        assertThat(lotto.contains(1)).isTrue
        assertThat(lotto.contains(7)).isFalse
    }

    // TODO: Implement tests based on the added features
}
