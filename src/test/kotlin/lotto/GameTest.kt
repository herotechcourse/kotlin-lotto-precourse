package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class GameTest {

    @Test
    fun `getMatches correctly pairs matches and bonus`() {
        val winningTicket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 3, 5, 7, 9, 11))
        )
        val game = Game(Player(3000,), winningTicket, bonusNumber)
        val result = game.getMatches(tickets)

        val expectedMatches = listOf(
            Pair(6, false),
            Pair(5, true),
            Pair(3, true)
        )
        assertThat(result).isEqualTo(expectedMatches)
    }
}