package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResultServiceTest {

    @Test
    fun `should correctly calculate the number of winning ranks`() {
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 8)),
            Lotto(listOf(1, 2, 3, 4, 9, 10)),
            Lotto(listOf(1, 2, 3, 11, 12, 13)),
            Lotto(listOf(20, 21, 22, 23, 24, 25))
        )

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val result = ResultService.calculateResult(lottos, winningNumbers, bonusNumber)

        assertThat(result[Rank.FIRST]).isEqualTo(1)
        assertThat(result[Rank.SECOND]).isEqualTo(1)
        assertThat(result[Rank.THIRD]).isEqualTo(1)
        assertThat(result[Rank.FOURTH]).isEqualTo(1)
        assertThat(result[Rank.FIFTH]).isEqualTo(1)
        assertThat(result[Rank.NONE]).isEqualTo(1)
    }

    @Test
    fun `should correctly calculate the profit rate`() {
        val result = mapOf(
            Rank.FIRST to 0,
            Rank.SECOND to 1,
            Rank.THIRD to 0,
            Rank.FOURTH to 1,
            Rank.FIFTH to 1,
            Rank.NONE to 7
        )

        val purchaseAmount = 10000

        val profitRate = ResultService.calculateProfitRate(result, purchaseAmount)

        assertThat(profitRate).isEqualTo(300550.0)
    }
}