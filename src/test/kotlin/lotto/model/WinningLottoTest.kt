package lotto.model

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {
    @Test
    fun `throws an exception when winning numbers are not exactly six`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5), 7)
        }

        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6, 7), 8)
        }
    }

    @Test
    fun `throws an exception when winning numbers are out of valid range`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(0, 1, 2, 3, 4, 5), 7)
        }

        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 46), 7)
        }
    }

    @Test
    fun `throws an exception when bonus number is out of valid range`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 0)
        }

        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 46)
        }
    }

    @Test
    fun `throws an exception when winning numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 5), 7)
        }
    }

    @Test
    fun `throws an exception when bonus number is in winning numbers`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 6)
        }
    }

    @Test
    fun `properly creates winning lotto with valid numbers`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        assertThat(winningLotto.getNumbers()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7)
    }

    @Test
    fun `correctly matches lotto tickets`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)

        val firstPrize = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(winningLotto.match(firstPrize)).isEqualTo(PrizeRank.FIRST)

        val secondPrize = Lotto(listOf(1, 2, 3, 4, 5, 7))
        assertThat(winningLotto.match(secondPrize)).isEqualTo(PrizeRank.SECOND)

        val thirdPrize = Lotto(listOf(1, 2, 3, 4, 5, 8))
        assertThat(winningLotto.match(thirdPrize)).isEqualTo(PrizeRank.THIRD)

        val fourthPrize = Lotto(listOf(1, 2, 3, 4, 8, 9))
        assertThat(winningLotto.match(fourthPrize)).isEqualTo(PrizeRank.FOURTH)

        val fifthPrize = Lotto(listOf(1, 2, 3, 8, 9, 10))
        assertThat(winningLotto.match(fifthPrize)).isEqualTo(PrizeRank.FIFTH)

        val noPrize = Lotto(listOf(1, 2, 8, 9, 10, 11))
        assertThat(winningLotto.match(noPrize)).isEqualTo(PrizeRank.NONE)
    }
}