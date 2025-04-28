package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThatThrownBy

class LottoTest {
    @Test
    fun `should be create Lotto`() {
        val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]")
    }

    @Test
    fun `lotto must parse to string`() {
        val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]")
    }

    @Test
    fun `lotto must count matches`() {
        val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 14, 15, 16)
        assertThat(lotto.countMatches(winningNumbers)).isEqualTo(3)
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThatThrownBy {Lotto.from(listOf(1, 2, 3, 4, 5, 5))}
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Lotto numbers must be unique.")
    }

    @Test
    fun `throws an exception when lotto numbers are less than six`() {
        assertThrows<IllegalArgumentException> {
            Lotto.from(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are out of range`() {
        assertThatThrownBy {Lotto.from(listOf(0, 2, 3, 4, 5, 6))}
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Lotto numbers must be between 1 and 45.")

        assertThatThrownBy {Lotto.from(listOf(46, 2, 3, 4, 5, 7))}
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Lotto numbers must be between 1 and 45.")
    }

}
