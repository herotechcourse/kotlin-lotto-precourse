package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

class LottoTicketTest {
    @Test
    fun `create valid lotto ticket`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val ticket = LottoTicket.from(numbers)
        assertEquals(6, ticket.numbers.size)
        assertTrue(ticket.numbers.all { it.value in numbers })
    }

    @Test
    fun `throw exception when numbers count is not 6`() {
        assertThrows<IllegalArgumentException> {
            LottoTicket.from(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `throw exception when numbers are duplicated`() {
        assertThrows<IllegalArgumentException> {
            LottoTicket.from(listOf(1, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `count matches with winning numbers`() {
        val ticket = LottoTicket.from(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 7, 8, 9).map { LottoNumber.from(it) }
        assertEquals(3, ticket.countMatches(winningNumbers))
    }

    @Test
    fun `check bonus number`() {
        val ticket = LottoTicket.from(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.from(1)
        assertTrue(ticket.hasBonusNumber(bonusNumber))
    }

    @Test
    fun `toString returns numbers as string`() {
        val ticket = LottoTicket.from(listOf(1, 2, 3, 4, 5, 6))
        assertEquals("[1, 2, 3, 4, 5, 6]", ticket.toString())
    }
} 