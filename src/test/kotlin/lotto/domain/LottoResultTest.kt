package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `returns first rank when all numbers match`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val tickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))

        val prizeResult = LottoResult.checkResult(tickets, winningLotto)

        assertThat(prizeResult.getRankCount(Rank.FIRST)).isEqualTo(1)
    }

    @Test
    fun `returns second rank when five numbers match plus bonus`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val tickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 7)))

        val prizeResult = LottoResult.checkResult(tickets, winningLotto)

        assertThat(prizeResult.getRankCount(Rank.SECOND)).isEqualTo(1)
    }

    @Test
    fun `returns third rank when five numbers match without bonus`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val tickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 8)))

        val prizeResult = LottoResult.checkResult(tickets, winningLotto)

        assertThat(prizeResult.getRankCount(Rank.THIRD)).isEqualTo(1)
    }
}
