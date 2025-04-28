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
    fun `throws error if less than 6 numbers are provided`() {
        assertThatThrownBy {
            Lotto(listOf(1, 2, 3, 4, 5))
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Lotto must contain exactly 6 numbers")
    }

    @Test
    fun `throws error if any number is out of range`() {
        assertThatThrownBy {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Lotto numbers must be between 1 and 45")

        assertThatThrownBy {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Lotto numbers must be between 1 and 45")
    }

    @Test
    fun `create lotto with valid numbers`() {
        val lotto = Lotto(listOf(8, 21, 23, 41, 42, 43))
        assertThat(lotto.getNumbers()).containsExactly(8, 21, 23, 41, 42, 43)
    }

    @Test
    fun `lotto numbers are sorted`() {
        val lotto = Lotto(listOf(45, 10, 1, 30, 25, 5))
        assertThat(lotto.getNumbers()).containsExactly(1, 5, 10, 25, 30, 45)
    }
}
