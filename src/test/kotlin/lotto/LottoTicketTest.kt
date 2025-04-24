package lotto

import lotto.domain.LottoTicket
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoTicketTest {

    @Test
    fun `matchCount should return correct number of matching numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val ticket = LottoTicket(lotto)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 7)

        val matchCount = ticket.matchCount(winningNumbers)

        assertEquals(5, matchCount, "Should match 5 numbers")
    }

    @Test
    fun `containsBonusNumber should return true when bonus number is included`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val ticket = LottoTicket(lotto)
        val bonusNumber = 6

        val containsBonus = ticket.containsBonusNumber(bonusNumber)

        assertTrue(containsBonus, "Bonus number should be present in the ticket")
    }

    @Test
    fun `containsBonusNumber should return false when bonus number is not included`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val ticket = LottoTicket(lotto)
        val bonusNumber = 7

        val containsBonus = ticket.containsBonusNumber(bonusNumber)

        assertFalse(containsBonus, "Bonus number should not be present in the ticket")
    }

    @Test
    fun `getNumbers should return the numbers of the ticket`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val ticket = LottoTicket(lotto)

        val numbers = ticket.getNumbers()

        assertEquals(listOf(1, 2, 3, 4, 5, 6), numbers, "The numbers in the ticket should be returned correctly")
    }
}
