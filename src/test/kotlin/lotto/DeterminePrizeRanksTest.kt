package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class DeterminePrizeRanksTest {

    @Test
    fun `correctly determines prize ranks`() {
        val winning = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonus = 7

        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)), // 1st Prize
            Lotto(listOf(1, 2, 3, 4, 5, 7)), // 2nd Prize
            Lotto(listOf(1, 2, 3, 4, 5, 8)), // 3rd Prize
            Lotto(listOf(1, 2, 3, 4, 8, 9)), // 4th Prize
            Lotto(listOf(1, 2, 3, 8, 9, 10)), // 5th Prize
            Lotto(listOf(8, 9, 10, 11, 12, 13)) // No prize
        )

        val result = determinePrizeRanks(tickets, winning, bonus)

        assertThat(result[0]).isEqualTo(PrizeRank.FIRST)
        assertThat(result[1]).isEqualTo(PrizeRank.SECOND)
        assertThat(result[2]).isEqualTo(PrizeRank.THIRD)
        assertThat(result[3]).isEqualTo(PrizeRank.FOURTH)
        assertThat(result[4]).isEqualTo(PrizeRank.FIFTH)
        assertThat(result[5]).isNull()
    }
}
