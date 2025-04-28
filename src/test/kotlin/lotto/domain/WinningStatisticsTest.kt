package lotto.domain

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import lotto.Lotto
import lotto.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningStatisticsTest {

    @Test
    fun `feature test map prize`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
                                Lotto(listOf(1, 3, 5, 7, 9, 11)),
                                Lotto(listOf(1, 3, 9, 12, 15, 20))
        )
        val winningNumber = WinningNumbers(listOf(1, 3, 5, 9, 12, 15), 4)
        val mapPrizeNumber = WinningStatistics.getMapPrize(tickets, winningNumber)
        assertSimpleTest {
                assertThat(mapPrizeNumber[Lotto.Prize.FIFTH]).isEqualTo(1)
                assertThat(mapPrizeNumber[Lotto.Prize.FOURTH]).isEqualTo(1)
                assertThat(mapPrizeNumber[Lotto.Prize.THIRD]).isEqualTo(1)
                assertThat(mapPrizeNumber[Lotto.Prize.SECOND]).isEqualTo(0)
                assertThat(mapPrizeNumber[Lotto.Prize.FIRST]).isEqualTo(0)
            }

    }

    @Test
    fun `feature test total money`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
                            Lotto(listOf(1, 3, 5, 7, 9, 11)),
                            Lotto(listOf(1, 3, 9, 12, 15, 20))
        )
        val winningNumber = WinningNumbers(listOf(1, 3, 5, 9, 12, 15), 4)
        val mapPrizeNumber = WinningStatistics.getMapPrize(tickets, winningNumber)
        val totalMoney = WinningStatistics.getTotalMoney(mapPrizeNumber)
        assertSimpleTest {
            assertThat(totalMoney).isEqualTo(1555000)
        }
    }

}