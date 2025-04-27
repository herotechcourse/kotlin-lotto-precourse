package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {

  @Test
  fun `correctly counts ranks and calculates total winnings`() {
    val winning = listOf(1, 2, 3, 4, 5, 6)
    val bonus = 7

    val tickets = listOf(
      Lotto(listOf(1, 2, 3, 4, 5, 6)), // 1st
      Lotto(listOf(1, 2, 3, 4, 5, 7)), // 2nd
      Lotto(listOf(1, 2, 3, 4, 5, 45)), // 3rd
      Lotto(listOf(1, 2, 3, 4, 44, 45)), // 4th
      Lotto(listOf(1, 2, 3, 40, 41, 42)), // 5th
      Lotto(listOf(10, 11, 12, 13, 14, 15)) // No match
    )

    val result = LottoResult(tickets, winning, bonus)
    val ranks = result.getRankCounts()

    assertThat(ranks[Rank.FIRST]).isEqualTo(1)
    assertThat(ranks[Rank.SECOND]).isEqualTo(1)
    assertThat(ranks[Rank.THIRD]).isEqualTo(1)
    assertThat(ranks[Rank.FOURTH]).isEqualTo(1)
    assertThat(ranks[Rank.FIFTH]).isEqualTo(1)

    val expectedTotal = Rank.FIRST.prize +
                        Rank.SECOND.prize +
                        Rank.THIRD.prize +
                        Rank.FOURTH.prize +
                        Rank.FIFTH.prize
    assertThat(result.totalWinnings()).isEqualTo(expectedTotal)
  }
}
