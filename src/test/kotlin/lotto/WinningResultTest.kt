package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningResultTest {

    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7
    private val winningResult = WinningResult(winningNumbers, bonusNumber)

    @Test
    fun `should correctly match lottos to ranks`() {
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)), // 6 matches -> FIRST
            Lotto(listOf(1, 2, 3, 4, 5, 7)), // 5 matches + bonus -> SECOND
            Lotto(listOf(1, 2, 3, 4, 5, 8)), // 5 matches -> THIRD
            Lotto(listOf(1, 2, 3, 4, 7, 8)), // 4 matches -> FOURTH
            Lotto(listOf(1, 2, 3, 7, 8, 9)), // 3 matches -> FIFTH
            Lotto(listOf(1, 2, 7, 8, 9, 10)) // 2 matches -> NONE
        )

        val matchResult = winningResult.match(lottos)

        assertThat(matchResult[Rank.FIRST]).isEqualTo(1)
        assertThat(matchResult[Rank.SECOND]).isEqualTo(1)
        assertThat(matchResult[Rank.THIRD]).isEqualTo(1)
        assertThat(matchResult[Rank.FOURTH]).isEqualTo(1)
        assertThat(matchResult[Rank.FIFTH]).isEqualTo(1)
        assertThat(matchResult[Rank.NONE]).isNull()
    }

    @Test
    fun `should correctly calculate total prize`() {
        val matchResult = mapOf(
            Rank.FIRST to 1,
            Rank.FIFTH to 2
        )

        val totalPrize = winningResult.calculateTotalPrize(matchResult)

        assertThat(totalPrize).isEqualTo(
            (Rank.FIRST.prizeMoney * 1) + (Rank.FIFTH.prizeMoney * 2)
        )
    }

    @Test
    fun `should correctly calculate profit rate`() {
        val totalPrize = 20000
        val purchaseAmount = 10000

        val profitRate = winningResult.calculateProfitRate(totalPrize, purchaseAmount)

        assertThat(profitRate).isEqualTo(200.0)
    }
}
