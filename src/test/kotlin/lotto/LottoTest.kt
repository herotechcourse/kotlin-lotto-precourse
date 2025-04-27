package lotto

import lotto.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class LottoTest {

    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }.also {
            assertThat(it.message).isEqualTo("[ERROR] Lotto must contain exactly 6 numbers.")
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }.also {
            assertThat(it.message).isEqualTo("[ERROR] Winning numbers must be unique.")
        }
    }

    @Test
    fun `throws an exception when lotto numbers are out of range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }.also {
            assertThat(it.message).isEqualTo("[ERROR] Winning numbers must be between 1 and 45.")
        }

        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }.also {
            assertThat(it.message).isEqualTo("[ERROR] Winning numbers must be between 1 and 45.")
        }
    }

    @Test
    fun `returns sorted lotto numbers`() {
        val lotto = Lotto(listOf(6, 3, 1, 5, 2, 4))
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
    }
}