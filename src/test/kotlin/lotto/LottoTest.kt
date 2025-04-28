package lotto

import lotto.domain.BonusNumber
import lotto.domain.WinningNumbers
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
    fun `matchCount returns correct number of matches`() {
        // given
        val winning = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        val lotto = Lotto(listOf(1, 7, 8, 9, 10, 11))

        // when
        val matches = lotto.matchCount(winning)

        // then
        assertThat(matches).isEqualTo(1)
    }

    @Test
    fun `matchCount returns zero when no numbers match`() {
        // given
        val winning = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        val lotto = Lotto(listOf(7, 8, 9, 10, 11, 12))

        // when
        val matches = lotto.matchCount(winning)

        // then
        assertThat(matches).isEqualTo(0)
    }

    @Test
    fun `containsNumber returns true when lotto contains the bonus number`() {
        // given
        val winning = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        val bonus = BonusNumber(7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))

        // when
        val contains = lotto.containsNumber(bonus)

        // then
        assertThat(contains).isTrue()
    }

    @Test
    fun `containsNumber returns false when lotto does not contain the bonus number`() {
        // given
        val winning = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        val bonus = BonusNumber(7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // when
        val contains = lotto.containsNumber(bonus)

        // then
        assertThat(contains).isFalse()
    }
}
