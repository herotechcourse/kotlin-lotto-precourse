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

}