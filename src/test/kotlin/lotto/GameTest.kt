package lotto

import lotto.model.Game
import lotto.model.WinningLotto
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GameTest {

    private lateinit var lottoTicket: List<Lotto>
    private lateinit var winningLotto: WinningLotto
    private lateinit var game: Game

    @BeforeEach
    fun setUp() {
        lottoTicket = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(11, 12, 13, 14, 15, 16)), Lotto(listOf(21, 22, 23, 24, 25, 26)))
        winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 23)), 4)
        game = Game(3_000, lottoTicket, winningLotto)
    }

    @Test
    fun `match test`() {
        val matchResult = game.match()
        assertEquals(matchResult[Rank.SECOND_PRIZE], 1)
        assertEquals(matchResult[Rank.NONE], 2)
    }
}