package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class LottoGameTest {
    @Test
    fun `should properly simulate the game process`() {
        val tickets = mutableListOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 7, 8, 9)),
            Lotto(listOf(1, 2, 3, 7, 8, 10)),
            Lotto(listOf(1, 2, 3, 10, 11, 12))

        )
        val winningNumbers = listOf(1, 2, 3, 10, 11, 12)
        val bonusNumber = 13

        val lottoGame = LottoGame(tickets, winningNumbers, bonusNumber)
        val results = lottoGame.start()
        assertThat(2).isEqualTo(results.getMatchResult(LottoRanks.MATCH_3))
        assertThat(1).isEqualTo(results.getMatchResult(LottoRanks.MATCH_4))
        assertThat(0).isEqualTo(results.getMatchResult(LottoRanks.MATCH_5))
        assertThat(0).isEqualTo(results.getMatchResult(LottoRanks.MATCH_5_AND_BONUS))
        assertThat(1).isEqualTo(results.getMatchResult(LottoRanks.MATCH_6))
    }
}
