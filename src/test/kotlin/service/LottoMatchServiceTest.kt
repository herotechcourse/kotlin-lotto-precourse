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

}