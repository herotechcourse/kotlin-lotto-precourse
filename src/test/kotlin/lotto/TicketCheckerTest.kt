package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TicketCheckerTest {
    @Test
    fun `assert that checkTicket is called with its arguments`() {
        val lotto = Lotto(listOf(1, 2, 3, 14, 25, 8))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val ticketChecker = TicketChecker()
        assertSimpleTest {
            ticketChecker.checkTicket(lotto, winningNumbers, bonusNumber)
        }
    }

    @Test
    fun `assert that getPrize is called with its arguments`() {
        val hasBonusNumber = false
        val matchedNumbersQuantity = 3
        val ticketChecker = TicketChecker()
        assertSimpleTest {
            ticketChecker.getPrize(hasBonusNumber, matchedNumbersQuantity)
        }
    }

    @Test
    fun `assert that when matchedNumbersQuantity is equal 3, getPrize returns FIFTH`() {
        val hasBonusNumber = false
        val matchedNumbersQuantity = 3
        val ticketChecker = TicketChecker()
        val prize = Prize.FIFTH
        assertEquals(
            prize,
            ticketChecker.getPrize(hasBonusNumber, matchedNumbersQuantity)
        )
    }

    @Test
    fun `assert that when matchedNumbersQuantity is equal 0, getPrize returns NO_PRIZE`() {
        val hasBonusNumber = false
        val matchedNumbersQuantity = 0
        val ticketChecker = TicketChecker()
        val prize = Prize.NO_PRIZE
        assertEquals(
            prize,
            ticketChecker.getPrize(hasBonusNumber, matchedNumbersQuantity)
        )
    }

    @Test
    fun `assert that when matchedNumbersQuantity is equal 5 and has the bonus number included on the lotto ticket, getPrize returns SECOND`() {
        val hasBonusNumber = true
        val matchedNumbersQuantity = 5
        val ticketChecker = TicketChecker()
        val prize = Prize.SECOND
        assertEquals(
            prize,
            ticketChecker.getPrize(hasBonusNumber, matchedNumbersQuantity)
        )
    }

    @Test
    fun `assert that when calculateTicketsResults returns a empty prizeList, the Lotto tickets doesn't contain any matches`() {
        val lottoGenerator = TicketGenerator()
        val lottoTickets = lottoGenerator.generateMultiples(2)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val expected = listOf<TicketResults>()
        val ticketChecker = TicketChecker()
        assertEquals(
            expected,
            ticketChecker.calculateTicketsResults(lottoTickets, winningNumbers, bonusNumber)
        )
    }

    @Test
    fun `assert that 6 matching numbers without bonus returns FIRST prize`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 9
        val expected = TicketResults(6, false, Prize.FIRST)
        val ticketChecker = TicketChecker()
        val ticketResult = ticketChecker.checkTicket(lotto, winningNumbers, bonusNumber)
        assertEquals(expected, ticketResult)
    }

    @Test
    fun `assert that 5 matching numbers without bonus returns THIRD prize`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 45))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 9
        val expected = TicketResults(5, false, Prize.THIRD)
        val ticketChecker = TicketChecker()
        val ticketResult = ticketChecker.checkTicket(lotto, winningNumbers, bonusNumber)
        assertEquals(expected, ticketResult)
    }

    @Test
    fun `assert that 5 matching numbers with bonus returns SECOND prize`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 9))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 9
        val expected = TicketResults(5, true, Prize.SECOND)
        val ticketChecker = TicketChecker()
        val ticketResult = ticketChecker.checkTicket(lotto, winningNumbers, bonusNumber)
        assertEquals(expected, ticketResult)
    }

    @Test
    fun `assert that 4 matching numbers with bonus returns FOURTH prize`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 11, 10))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 9
        val expected = TicketResults(4, false, Prize.FOURTH)
        val ticketChecker = TicketChecker()
        val ticketResult = ticketChecker.checkTicket(lotto, winningNumbers, bonusNumber)
        assertEquals(expected, ticketResult)
    }

    @Test
    fun `assert that 3 matching numbers with bonus returns FIFTH prize`() {
        val lotto = Lotto(listOf(1, 2, 3, 12, 11, 10))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 9
        val expected = TicketResults(3, false, Prize.FIFTH)
        val ticketChecker = TicketChecker()
        val ticketResult = ticketChecker.checkTicket(lotto, winningNumbers, bonusNumber)
        assertEquals(expected, ticketResult)
    }

}
