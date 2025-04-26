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
        val lotto = Lotto(listOf(1, 2, 3, 14, 25, 8))
        val bonusNumber = 7
        val matchedNumbersQuantity = 3
        val ticketChecker = TicketChecker()
        assertSimpleTest {
            ticketChecker.getPrize(lotto, bonusNumber, matchedNumbersQuantity)
        }
    }

    @Test
    fun `assert that when matchedNumbersQuantity is equal 3, getPrize returns FIFTH`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val matchedNumbersQuantity = 3
        val ticketChecker = TicketChecker()
        val prize = Prize.FIFTH
        assertEquals(
            prize,
            ticketChecker.getPrize(lotto, bonusNumber, matchedNumbersQuantity)
        )
    }

    @Test
    fun `assert that when matchedNumbersQuantity is equal 0, getPrize returns NO_PRIZE`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val matchedNumbersQuantity = 0
        val ticketChecker = TicketChecker()
        val prize = Prize.NO_PRIZE
        assertEquals(
            prize,
            ticketChecker.getPrize(lotto, bonusNumber, matchedNumbersQuantity)
        )
    }

    @Test
    fun `assert that when matchedNumbersQuantity is equal 5 and has the bonus number included on the lotto ticket, getPrize returns SECOND`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val bonusNumber = 7
        val matchedNumbersQuantity = 5
        val ticketChecker = TicketChecker()
        val prize = Prize.SECOND
        assertEquals(
            prize,
            ticketChecker.getPrize(lotto, bonusNumber, matchedNumbersQuantity)
        )
    }

    @Test
    fun `assert that when checkMultipleTickets returns a empty prizeList, the Lotto tickets doesn't contain any matches`() {
        val lottoGenerator = TicketGenerator()
        val lottoTickets = lottoGenerator.generateMultiples(2)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val prizeList = mutableListOf<Prize>()
        val ticketChecker = TicketChecker()
        assertEquals(
            prizeList,
            ticketChecker.checkMultipleTickets(lottoTickets, winningNumbers, bonusNumber )
        )
    }
}
