package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningLottoTest {

    @Test
    fun `match should return correct rank with no bonus match`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val rank = winningLotto.match(lotto)

        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `match should return correct rank with bonus match`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))  // Bonus match

        val rank = winningLotto.match(lotto)

        assertThat(rank).isEqualTo(Rank.SECOND)  // Since it's 5 matches + bonus
    }

}
