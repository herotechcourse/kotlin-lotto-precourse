package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class GameTest {

    val winningTicket = Lotto(listOf(1, 2, 3, 4, 5, 6))
    val bonusNumber = 7
    val game = Game(Player(3000), winningTicket, bonusNumber)

    @Test
    fun `getMatches correctly pairs matches and bonus`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 3, 5, 7, 9, 11))
        )
        val result = game.getMatches(tickets)

        val expectedMatches = listOf(
            Pair(6, false),
            Pair(5, true),
            Pair(3, true)
        )
        assertThat(result).isEqualTo(expectedMatches)
    }

    @Test
    fun `getStatistics does not count prizes incorrectly`() {
        val finalMatches: List<Pair<Int, Boolean>> = listOf(
            Pair(3, false),
            Pair(0, true),
            Pair(5, true),
        )

        val result = game.getStatistics(finalMatches)

        val expected= listOf(
            Pair(Game.Prize.FIRST, 0),
            Pair(Game.Prize.SECOND, 1),
            Pair(Game.Prize.THIRD, 0),
            Pair(Game.Prize.FOURTH, 0),
            Pair(Game.Prize.FIFTH, 1)
        )
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `getFinalPrizeAmount correctly`() {
        val statistics= listOf(
            Pair(Game.Prize.FIRST, 0),
            Pair(Game.Prize.SECOND, 1),
            Pair(Game.Prize.THIRD, 0),
            Pair(Game.Prize.FOURTH, 0),
            Pair(Game.Prize.FIFTH, 1)
        )

        val result = game.getFinalPrizeAmount(statistics)

        assertThat(result).isEqualTo(30_005_000)
    }
    // TODO tests for getProfitRate
}