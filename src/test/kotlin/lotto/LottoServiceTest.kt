package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.collections.all
import kotlin.collections.distinct
import kotlin.collections.forEach

class LottoServiceTest {

    @Test
    fun `generateTickets should create the correct number of tickets`() {
        val tickets = LottoService.generateTickets(5)
        assertEquals(5, tickets.size)
        tickets.forEach { ticket ->
            assertEquals(6, ticket.getNumbers().size)
            assertTrue(ticket.getNumbers().all { it in 1..45 })
            assertEquals(6, ticket.getNumbers().distinct().size)
        }
    }

    @Test
    fun `calculateLottoResult should return all ranks even if count is zero`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12))
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonus = 7

        val result = LottoService.calculateLottoResult(tickets, winningNumbers, bonus)

        // Should include ALL ranks
        Rank.values().forEach { rank ->
            assertTrue(result.containsKey(rank))
        }
    }

    @Test
    fun `calculateLottoResult should correctly detect FIRST rank`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)) // exact match
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonus = 7

        val result = LottoService.calculateLottoResult(tickets, winningNumbers, bonus)

        assertEquals(1, result[Rank.FIRST])
        assertEquals(0, result[Rank.SECOND])
    }

    @Test
    fun `calculateLottoResult should correctly detect SECOND rank with bonus`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 7)) // 5 matches + bonus
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonus = 7

        val result = LottoService.calculateLottoResult(tickets, winningNumbers, bonus)

        assertEquals(1, result[Rank.SECOND])
        assertEquals(0, result[Rank.FIRST])
    }

    @Test
    fun `calculateLottoResult should correctly detect THIRD rank without bonus`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 8)) // 5 matches, no bonus
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonus = 7

        val result = LottoService.calculateLottoResult(tickets, winningNumbers, bonus)

        assertEquals(1, result[Rank.THIRD])
        assertEquals(0, result[Rank.SECOND])
    }

    @Test
    fun `calculateLottoResult should correctly detect FOURTH rank`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 7, 8)) // 4 matches
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonus = 7

        val result = LottoService.calculateLottoResult(tickets, winningNumbers, bonus)

        assertEquals(1, result[Rank.FOURTH])
    }

    @Test
    fun `calculateLottoResult should correctly detect FIFTH rank`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 7, 8, 9)) // 3 matches
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonus = 7

        val result = LottoService.calculateLottoResult(tickets, winningNumbers, bonus)

        assertEquals(1, result[Rank.FIFTH])
    }

    @Test
    fun `calculateLottoResult should correctly detect NONE`() {
        val tickets = listOf(
            Lotto(listOf(10, 11, 12, 13, 14, 15)) // no matches
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonus = 7

        val result = LottoService.calculateLottoResult(tickets, winningNumbers, bonus)

        assertEquals(1, result[Rank.NONE])
    }
}
