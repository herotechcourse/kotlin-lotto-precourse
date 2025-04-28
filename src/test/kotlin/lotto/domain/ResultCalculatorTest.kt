package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ResultCalculatorTest {
    @ParameterizedTest
    @MethodSource("provideRanksAndExpectedCounts")
    fun `calculate winning statistics`(input: Pair<LottoRank, Int>) {
        val (rank, expectedCount) = input

        val result = ResultCalculator.calculateMatchedLottoCount(lottos, winningNumbers, bonusNumber)

        assertThat(result[rank]).isEqualTo(expectedCount)
    }

    companion object {
        @JvmStatic
        fun provideRanksAndExpectedCounts() = listOf(
            LottoRank.FIRST to 1,
            LottoRank.SECOND to 1,
            LottoRank.THIRD to 1,
            LottoRank.FOURTH to 1,
            LottoRank.FIFTH to 1
        )

        private val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        private val bonusNumber = BonusNumber(7)

        private val lottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(1, 2, 3, 4, 5, 7)),
                Lotto(listOf(1, 2, 3, 4, 5, 8)),
                Lotto(listOf(1, 2, 3, 4, 7, 8)),
                Lotto(listOf(1, 2, 3, 7, 8, 9))
            )
        )
    }
}