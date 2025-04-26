package lotto

import org.assertj.core.api.Assertions.assertThat
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
    fun `throws an exception when lotto numbers are outside the range 1-45`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 46, 5, 6))
        }.also {
            assertThat(it.message).isEqualTo("[ERROR] Lotto numbers must be between 1 and 45.")
        }
    }

    @Test
    fun `throws an exception when lotto numbers are not unique`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 4, 5))
        }.also {
            assertThat(it.message).isEqualTo("[ERROR] Lotto numbers must be unique.")
        }
    }

    @Test
    fun `creates a valid lotto object with six unique numbers within range 1-45`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `countMatches should return correct number of matching numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(3, 4, 5, 6, 7, 8)

        val matches = lotto.countMatches(winningNumbers)

        assertThat(matches).isEqualTo(4)
    }

    @Test
    fun `hasNumber should return true when the number is in the lotto numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val hasNumber = lotto.hasNumber(3)

        assertThat(hasNumber).isTrue()
    }

    @Test
    fun `hasNumber should return false when the number is not in the lotto numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val hasNumber = lotto.hasNumber(7)

        assertThat(hasNumber).isFalse()
    }}
