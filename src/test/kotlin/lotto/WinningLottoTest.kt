package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningLottoTest {

    @Test
    fun `winning lotto matches correct number of matches`() {
        val winningLotto = WinningLotto(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            7
        )

        val ticket = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val matchResult = winningLotto.match(ticket)

        assertThat(matchResult.matchCount).isEqualTo(3)
        assertThat(matchResult.matchBonus).isFalse()
    }

    @Test
    fun `winning lotto matches bonus ball`() {
        val winningLotto = WinningLotto(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            7
        )

        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val matchResult = winningLotto.match(ticket)

        assertThat(matchResult.matchCount).isEqualTo(5)
        assertThat(matchResult.matchBonus).isTrue()
    }
}
