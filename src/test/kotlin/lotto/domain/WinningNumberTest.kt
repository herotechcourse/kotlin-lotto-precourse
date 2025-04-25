package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class WinningNumberTest {

    @Test
    fun `throws exception when there are not exactly 6 winning numbers`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5)
        val bonus = 6

        // when & then
        assertThatThrownBy { WinningNumber(numbers, bonus) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Winning numbers must consist of exactly 6 numbers.")
    }

    @Test
    fun `throws exception when there are duplicate numbers`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 5)
        val bonus = 6

        assertThatThrownBy { WinningNumber(numbers, bonus) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Winning numbers must be unique")
    }

    @Test
    fun `throws exception when numbers are out of range`() {
        // given
        val numbers = listOf(0, 2, 3, 4, 5, 46)
        val bonus = 6

        // when & then
        assertThatThrownBy { WinningNumber(numbers, bonus) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Winning numbers must be between 1 and 45")
    }

    @Test
    fun `all 6 numbers match and bonus number is not included when match is called Then Rank is FIRST`() {
        // given
        val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6), bonusNumber = 7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // when
        val result = winningNumber.match(lotto)

        // then
        assertThat(result).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `5 numbers match and the bonus number also matches when match is called Then Rank is SECOND`() {
        // given
        val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6), bonusNumber = 7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))

        // when
        val result = winningNumber.match(lotto)

        // then
        assertThat(result).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `5 numbers match and the bonus number does not match when match is called Then Rank is THIRD`() {
        // given
        val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6), bonusNumber = 7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 8))

        // when
        val result = winningNumber.match(lotto)

        // Then
        assertThat(result).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `3 numbers match when match is called Then Rank is FIFT`() {
        // given
        val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6), bonusNumber = 7)
        val lotto = Lotto(listOf(1, 2, 3, 10, 11, 12))

        // when
        val result = winningNumber.match(lotto)

        // then
        assertThat(result).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `no numbers match when match is called Then Rank is NONE`() {
        // Given
        val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6), bonusNumber = 7)
        val lotto = Lotto(listOf(10, 11, 12, 13, 14, 15))

        // when
        val result = winningNumber.match(lotto)

        // then
        assertThat(result).isEqualTo(Rank.NONE)
    }
}

