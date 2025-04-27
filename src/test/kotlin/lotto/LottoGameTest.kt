package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoGameTest {
    private val game = LottoGame()

    @Test
    fun `returns correct count when winning numbers do not match ticket numbers`() {
        val ticket = Lotto(listOf(7,8,9,10,11,12))
        val winningNumbers = listOf(1,2,3,4,5,6)
        val result = game.compareWinningNumbers(ticket, winningNumbers)
        assertEquals(0, result)
    }

    @Test
    fun `returns 1 when bonus number matches`() {
        val ticket = Lotto(listOf(1,2,3,4,5,7))
        val bonusNumber = 7
        val result = game.compareBonusNumber(ticket, bonusNumber)
        assertEquals(1, result)
    }

    @Test
    fun `returns FIRST rank when 6 numbers match`() {
        val result = game.determineRank(6, 0)
        assertEquals(Rank.FIRST, result)
    }

    @Test
    fun `returns SECOND rank when 5 numbers and bonus match`() {
        val result = game.determineRank(5, 1)
        assertEquals(Rank.SECOND, result)
    }

    @Test
    fun `returns THIRD rank when 5 numbers match without bonus`() {
        val result = game.determineRank(5, 0)
        assertEquals(Rank.THIRD, result)
    }

    @Test
    fun `returns FOURTH rank when 4 numbers match`() {
        val result = game.determineRank(4, 0)
        assertEquals(Rank.FOURTH, result)
    }

    @Test
    fun `returns FIFTH rank when 3 numbers match`() {
        val result = game.determineRank(3, 0)
        assertEquals(Rank.FIFTH, result)
    }

    @Test
    fun `returns NONE rank when less than 3 numbers match`() {
        val result = game.determineRank(2, 0)
        assertEquals(Rank.NONE, result)
    }
}