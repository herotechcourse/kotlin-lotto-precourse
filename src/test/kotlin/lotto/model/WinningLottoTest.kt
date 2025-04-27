package lotto.model

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    fun `throws exception when bonus number is out of range`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertThatThrownBy { WinningLotto(lotto, 0) }
            .isInstanceOf(IllegalArgumentException::class.java)

        assertThatThrownBy { WinningLotto(lotto, 46) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `throws exception when bonus number duplicates winning numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertThatThrownBy { WinningLotto(lotto, 6) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `returns correct MatchRank without bonus match`() {
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        val myLotto = Lotto(listOf(1, 2, 3, 10, 11, 12))

        val matchRank = winningLotto.match(myLotto)

        assertThat(matchRank).isEqualTo(MatchRank.FIFTH) // 3 Matches → FIFTH
    }

    @Test
    fun `returns correct MatchRank with bonus match`() {
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        val myLotto = Lotto(listOf(1, 2, 3, 4, 5, 7))

        val matchRank = winningLotto.match(myLotto)

        assertThat(matchRank).isEqualTo(MatchRank.SECOND) // 5 Matches + Bonus → SECOND
    }
}
