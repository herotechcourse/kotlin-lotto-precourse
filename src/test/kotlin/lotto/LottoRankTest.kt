package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoRankTest {
    @Test
    fun `6 matches - FIRST`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)

        assertEquals(LottoRank.FIRST, LottoRank.calculate(lotto, winningLotto))
    }

    @Test
    fun `5 matches, bonus number match - SECOND`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 8)), 6)

        assertEquals(LottoRank.SECOND, LottoRank.calculate(lotto, winningLotto))
    }

    @Test
    fun `5 matches, bonus number not match - THIRD`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 8)), 7)

        assertEquals(LottoRank.THIRD, LottoRank.calculate(lotto, winningLotto))
    }

    @Test
    fun `4 matches - FOURTH`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 7, 8)), 9)

        assertEquals(LottoRank.FOURTH, LottoRank.calculate(lotto, winningLotto))
    }

    @Test
    fun `3 matches - FIFTH`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 7, 8, 9)), 10)

        assertEquals(LottoRank.FIFTH, LottoRank.calculate(lotto, winningLotto))
    }

    @Test
    fun `2 or less match - NONE`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 7, 8, 9, 10)), 11)

        assertEquals(LottoRank.NONE, LottoRank.calculate(lotto, winningLotto))
    }
}
