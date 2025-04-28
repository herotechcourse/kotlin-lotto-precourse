package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {
    @Test
    fun `Lotto should have exactly 6 numbers`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Lotto must contain exactly 6 numbers.")
    }

    @Test
    fun `Lotto numbers should be between 1 and 45`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5, 46)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Lotto numbers must be between 1 and 45.")
    }

    @Test
    fun `Lotto numbers should not contain duplicates`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Lotto numbers must be unique.")
    }
    
    @Test
    fun `getNumbers should return sorted numbers`() {
        val lotto = Lotto(listOf(6, 3, 5, 1, 2, 4))
        assertThat(lotto.getNumbers()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }
    
    @Test
    fun `matchCount should return correct number of matches`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 10, 11, 12)
        assertThat(lotto.matchCount(winningNumbers)).isEqualTo(3)
    }
    
    @Test
    fun `contains should return true when number is in lotto`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.contains(3)).isTrue()
    }
    
    @Test
    fun `contains should return false when number is not in lotto`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.contains(10)).isFalse()
    }
}