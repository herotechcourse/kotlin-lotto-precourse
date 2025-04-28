package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `match tickets correctly and classify ranks`() {

        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)), // 6 match
            Lotto(listOf(1, 2, 3, 4, 5, 7)), // 5 match + bonus
            Lotto(listOf(1, 2, 3, 4, 5, 8)), // 5 match no bonus
            Lotto(listOf(1, 2, 3, 4, 10, 11)), // 4 match
            Lotto(listOf(1, 2, 3, 20, 21, 22)), // 3 match
            Lotto(listOf(10, 11, 12, 13, 14, 15)) // no match
        )

        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)

        val ranks = tickets.map { ticket ->
            val matchCount = winningNumbers.countMatch(ticket)
            val bonusMatched = winningNumbers.isBonusMatch(ticket)
            Rank.find(matchCount, bonusMatched)
        }

        assertThat(ranks[0]).isEqualTo(Rank.FIRST) // 6 match
        assertThat(ranks[1]).isEqualTo(Rank.SECOND) // 5 + bonus
        assertThat(ranks[2]).isEqualTo(Rank.THIRD) // 5 no bonus
        assertThat(ranks[3]).isEqualTo(Rank.FOURTH) // 4 match
        assertThat(ranks[4]).isEqualTo(Rank.FIFTH) // 3 match
        assertThat(ranks[5]).isEqualTo(Rank.MISS) // no match
    }
}
