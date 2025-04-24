package lotto.prize

import lotto.Lotto
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PrizeRankingTest {

    private val prizeRanking = PrizeRanking()

    @Test
    fun `calculates prize for 6 matches`() {

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val userNumbers = listOf(1, 2, 3, 4, 5, 6)

        val result = prizeRanking.calculatePrize(userNumbers, winningNumbers, bonusNumber)

        Assertions.assertEquals("6 Matches (2,000,000,000 KRW)", result)
    }

    @Test
    fun `calculates prize for 5 matches without bonus`() {

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val userNumbers = listOf(1, 2, 3, 4, 5, 8)

        val result = prizeRanking.calculatePrize(userNumbers, winningNumbers, bonusNumber)

        Assertions.assertEquals("5 Matches (1,500,000 KRW)", result)
    }

    @Test
    fun `calculates prize for 5 matches with bonus`() {

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val userNumbers = listOf(1, 2, 3, 4, 5, 7)

        val result = prizeRanking.calculatePrize(userNumbers, winningNumbers, bonusNumber)

        Assertions.assertEquals("5 Matches + Bonus Ball (30,000,000 KRW)", result)
    }

    @Test
    fun `calculates prize for 4 matches`() {

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val userNumbers = listOf(1, 2, 3, 4, 8, 9)

        val result = prizeRanking.calculatePrize(userNumbers, winningNumbers, bonusNumber)

        Assertions.assertEquals("4 Matches (50,000 KRW)", result)
    }

    @Test
    fun `calculates prize for 3 matches`() {

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val userNumbers = listOf(1, 2, 3, 8, 9, 10)

        val result = prizeRanking.calculatePrize(userNumbers, winningNumbers, bonusNumber)

        Assertions.assertEquals("3 Matches (5,000 KRW)", result)
    }

    @Test
    fun `returns empty string for no prize`() {

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val userNumbers = listOf(8, 9, 10, 11, 12, 13)

        val result = prizeRanking.calculatePrize(userNumbers, winningNumbers, bonusNumber)

        Assertions.assertEquals("", result)
    }

    @Test
    fun `calculates prize for all tickets correctly`() {

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),   // 6 matches
            Lotto(listOf(1, 2, 3, 4, 5, 8)),   // 5 matches
            Lotto(listOf(1, 2, 3, 4, 5, 7)),   // 5 matches + bonus ball
            Lotto(listOf(1, 2, 3, 4, 10, 11)), // 4 matches
            Lotto(listOf(8, 9, 10, 11, 12, 13)) // No match
        )

        val results = prizeRanking.calculatePrizeForAllTickets(tickets, winningNumbers, bonusNumber)

        val expectedResults = listOf(
            "Ticket [1, 2, 3, 4, 5, 6] - Prize: 6 Matches (2,000,000,000 KRW)",
            "Ticket [1, 2, 3, 4, 5, 8] - Prize: 5 Matches (1,500,000 KRW)",
            "Ticket [1, 2, 3, 4, 5, 7] - Prize: 5 Matches + Bonus Ball (30,000,000 KRW)",
            "Ticket [1, 2, 3, 4, 10, 11] - Prize: 4 Matches (50,000 KRW)"
        )

        Assertions.assertEquals(expectedResults, results)
    }
}