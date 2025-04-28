package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {

    @Test
    fun `creates valid winning lotto`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)

        assertThat(winningLotto.getWinningNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7)
    }

    @Test
    fun `throws exception when winning numbers are invalid`() {
        // Less than 6 numbers
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5), 7)
        }

        // More than 6 numbers
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6, 7), 8)
        }

        // Duplicate numbers
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 5), 7)
        }

        // Out of range numbers
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(0, 1, 2, 3, 4, 5), 7)
        }

        // Out of range numbers
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 46), 7)
        }
    }

    @Test
    fun `throws exception when bonus number is invalid`() {
        // Out of range (too small)
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 0)
        }

        // Out of range (too large)
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 46)
        }

        // Duplicate with winning numbers
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 6)
        }
    }

    @Test
    fun `correctly matches lotto with winning numbers`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)

        // First rank (6 matches)
        val firstRankLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(winningLotto.match(firstRankLotto)).isEqualTo(Rank.FIRST)

        // Second rank (5 matches + bonus)
        val secondRankLotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        assertThat(winningLotto.match(secondRankLotto)).isEqualTo(Rank.SECOND)

        // Third rank (5 matches)
        val thirdRankLotto = Lotto(listOf(1, 2, 3, 4, 5, 10))
        assertThat(winningLotto.match(thirdRankLotto)).isEqualTo(Rank.THIRD)

        // Fourth rank (4 matches)
        val fourthRankLotto = Lotto(listOf(1, 2, 3, 4, 10, 11))
        assertThat(winningLotto.match(fourthRankLotto)).isEqualTo(Rank.FOURTH)

        // Fifth rank (3 matches)
        val fifthRankLotto = Lotto(listOf(1, 2, 3, 10, 11, 12))
        assertThat(winningLotto.match(fifthRankLotto)).isEqualTo(Rank.FIFTH)

        // No rank (2 matches)
        val noRankLotto = Lotto(listOf(1, 2, 10, 11, 12, 13))
        assertThat(winningLotto.match(noRankLotto)).isEqualTo(Rank.NONE)
    }
}