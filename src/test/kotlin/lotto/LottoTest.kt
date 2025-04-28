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
    fun `should create Lotto successfully with 6 unique numbers between 1 and 45`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        assertThat(lotto.getLottoNumber()).containsExactlyInAnyOrderElementsOf(numbers)
    }

    @Test
    fun `should throw exception if less than 6 numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5)
        assertThatThrownBy { Lotto(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Lotto must contain exactly 6 numbers.")
    }

    @Test
    fun `should throw exception if number out of range`() {
        val numbers = listOf(0, 2, 3, 4, 5, 6)

        assertThatThrownBy { Lotto(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Lotto numbers must be between 1 and 45.")
    }

    @Test
    fun `should correctly check if lotto contains a number`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)

        assertThat(lotto.containsNumber(3)).isTrue()
        assertThat(lotto.containsNumber(10)).isFalse()
    }

    @Test
    fun `should count matching numbers between two lotto tickets`() {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(4, 5, 6, 7, 8, 9))

        val matchingCount = lotto1.countMatchingNumbers(lotto2)

        assertThat(matchingCount).isEqualTo(3)
    }
}
