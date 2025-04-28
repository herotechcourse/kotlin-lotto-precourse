package service

import lotto.*
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class LottoMatchServiceTest {
    @Test
    fun `countMatchingNumbers returns correct count for matching numbers`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 7, 8, 9), 10)

        val matchCount = LottoMatchService.countMatchingNumbers(ticket, winningNumbers)

        assertThat(matchCount).isEqualTo(3) // 1, 2, 3
    }
    
    @Test
    fun `countMatchingNumbers returns 0 for no matching numbers`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = WinningNumbers(listOf(7, 8, 9, 10, 11, 12), 13)

        val matchCount = LottoMatchService.countMatchingNumbers(ticket, winningNumbers)

        assertThat(matchCount).isEqualTo(0)
    }
    
    @Test
    fun `countMatchingNumbers returns 6 for all matching numbers`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)

        val matchCount = LottoMatchService.countMatchingNumbers(ticket, winningNumbers)

        assertThat(matchCount).isEqualTo(6)
    }

    @Test
    fun `hasBonus returns true when ticket contains bonus number`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val winningNumbers = WinningNumbers(listOf(10, 20, 30, 40, 50, 60), 7)

        val hasBonus = LottoMatchService.hasBonus(ticket, winningNumbers)

        assertThat(hasBonus).isTrue()
    }

    @Test
    fun `hasBonus returns false when ticket does not contain bonus number`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = WinningNumbers(listOf(10, 20, 30, 40, 50, 60), 7)

        val hasBonus = LottoMatchService.hasBonus(ticket, winningNumbers)

        assertThat(hasBonus).isFalse()
    }

    @Test
    fun `determineRank returns correct rank for different match counts`() {
        assertThat(LottoMatchService.determineRank(3, false)).isEqualTo(LottoRank.THREE)
        assertThat(LottoMatchService.determineRank(4, false)).isEqualTo(LottoRank.FOUR)
        assertThat(LottoMatchService.determineRank(5, false)).isEqualTo(LottoRank.FIVE)
        assertThat(LottoMatchService.determineRank(5, true)).isEqualTo(LottoRank.FIVE_BONUS)
        assertThat(LottoMatchService.determineRank(6, false)).isEqualTo(LottoRank.SIX)
    }

    @Test
    fun `determineRank returns null for less than 3 matches`() {
        assertThat(LottoMatchService.determineRank(0, false)).isNull()
        assertThat(LottoMatchService.determineRank(1, false)).isNull()
        assertThat(LottoMatchService.determineRank(2, false)).isNull()
    }

    @Test
    fun `calculateStatistics returns correct counts for each rank`() {
        val ticketNumbers = listOf(
            listOf(1, 2, 3, 4, 5, 6), // 6
            listOf(1, 2, 3, 4, 5, 10), // 5
            listOf(1, 2, 3, 4, 7, 8), // 4
            listOf(1, 2, 3, 10, 20, 30), // 3
            listOf(1, 2, 10, 20, 30, 40), // 2
            listOf(7, 8, 9, 10, 20, 30) // 0
        )

        var index = 0
        val pickNumbers: (Int, Int, Int) -> List<Int> = { _, _, _ ->
            val numbers = ticketNumbers[index]
            index++
            numbers
        }

        val tickets = Tickets(6000, pickNumbers)
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)

        val statistics = LottoMatchService.calculateStatistics(tickets, winningNumbers)

        assertThat(statistics[LottoRank.THREE]).isEqualTo(1)
        assertThat(statistics[LottoRank.FOUR]).isEqualTo(1)
        assertThat(statistics[LottoRank.FIVE]).isEqualTo(1)
        assertThat(statistics[LottoRank.FIVE_BONUS]).isEqualTo(0)
        assertThat(statistics[LottoRank.SIX]).isEqualTo(1)
    }

    @Test
    fun `calculateReturnRate returns correct rate`() {

        val tickets = Tickets(5000)
        val statistics = mapOf(
            LottoRank.THREE to 1, // 5,000
            LottoRank.FOUR to 1, // 50,000
            LottoRank.FIVE to 0,
            LottoRank.FIVE_BONUS to 0,
            LottoRank.SIX to 0
        )

        val rate = LottoMatchService.calculateReturnRate(tickets, statistics)


        // Total: 5,000 + 50,000 = 55,000
        // Return: (55,000 / 5,000) * 100 = 1,100%
        assertThat(rate).isEqualTo(1100.0)
    }

    @Test
    fun `roundNearestTenth formats number correctly`() {
        assertThat(LottoMatchService.roundNearestTenth(123.456)).isEqualTo("123.5")
        assertThat(LottoMatchService.roundNearestTenth(123.45)).isEqualTo("123.5")
        assertThat(LottoMatchService.roundNearestTenth(123.44)).isEqualTo("123.4")
        assertThat(LottoMatchService.roundNearestTenth(0.0)).isEqualTo("0.0")
    }

}