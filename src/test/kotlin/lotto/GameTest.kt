package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class GameTest {
    val winningTicket = Lotto(listOf(1, 2, 3, 4, 5, 6))
    val bonusNumber = 7
    val game = Game(Player(3000), winningTicket, bonusNumber)

    @ParameterizedTest
    @ValueSource(ints = [0, -1, 46, 99])
    fun `throws an exception when lotto contains numbers out of range 1-45`(input: Int) {
        assertThrows<IllegalArgumentException> {
            Game(Player(3000), winningTicket, input)
        }
    }

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

        val expected = listOf(
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
        val statistics = listOf(
            Pair(Game.Prize.FIRST, 0),
            Pair(Game.Prize.SECOND, 0),
            Pair(Game.Prize.THIRD, 0),
            Pair(Game.Prize.FOURTH, 0),
            Pair(Game.Prize.FIFTH, 1)
        )

        val result = game.getFinalPrizeAmount(statistics)

        assertThat(result).isEqualTo(5000)
    }

    @Test
    fun `getProfitRate correctly`() {
        val result = game.getProfitRate(8000, 5000)
        assertThat(result).isEqualTo(62.5)
    }
}