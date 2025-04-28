package lotto.domain

import lotto.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoResultCheckerTest {

        private val lottoResultChecker = LottoResultChecker()

        @Test
        fun `should correctly group lottos by winning ranks`() {
                val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
                val bonusNumber = 7

                val tickets =
                        listOf(
                                Lotto(listOf(1, 2, 3, 4, 5, 6)), // 6 numbers match → FIRST
                                Lotto(
                                        listOf(1, 2, 3, 4, 5, 7)
                                ), // 5 numbers match + bonus number match → SECOND
                                Lotto(listOf(1, 2, 3, 4, 5, 8)), // 5 numbers match → THIRD
                                Lotto(listOf(1, 2, 3, 4, 10, 11)), // 4 numbers match → FOURTH
                                Lotto(listOf(1, 2, 3, 10, 11, 12)) // 3 numbers match → FIFTH
                        )

                val result =
                        lottoResultChecker.checkLottoResults(tickets, winningNumbers, bonusNumber)

                assertEquals(1, result[WinningPrizeRanks.FIRST])
                assertEquals(1, result[WinningPrizeRanks.SECOND])
                assertEquals(1, result[WinningPrizeRanks.THIRD])
                assertEquals(1, result[WinningPrizeRanks.FOURTH])
                assertEquals(1, result[WinningPrizeRanks.FIFTH])
        }

        @Test
        fun `should correctly calculate total prize`() {
                val winningCounts =
                        mapOf(
                                WinningPrizeRanks.FIRST to 1,
                                WinningPrizeRanks.SECOND to 1,
                                WinningPrizeRanks.THIRD to 1,
                                WinningPrizeRanks.FOURTH to 1,
                                WinningPrizeRanks.FIFTH to 1
                        )

                val totalPrize = lottoResultChecker.calculateTotalPrize(winningCounts)

                val expectedPrize =
                        ( // Total sum of all prizes
                        WinningPrizeRanks.FIRST.prize +
                                WinningPrizeRanks.SECOND.prize +
                                WinningPrizeRanks.THIRD.prize +
                                WinningPrizeRanks.FOURTH.prize +
                                WinningPrizeRanks.FIFTH.prize)
                assertEquals(expectedPrize, totalPrize)
        }

        @Test
        fun `should correctly calculate profit rate`() {
                val totalPrize = 5000
                val purchaseAmount = 10000

                val profitRate = lottoResultChecker.getProfitRate(totalPrize, purchaseAmount)

                assertEquals(50.0, profitRate)
        }
}
