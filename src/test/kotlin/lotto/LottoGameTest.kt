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

}