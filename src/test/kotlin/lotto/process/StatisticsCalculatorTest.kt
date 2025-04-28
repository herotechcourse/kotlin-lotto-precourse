package lotto.process

import lotto.BonusNumber
import lotto.Lotto
import lotto.PurchaseAmount
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class StatisticsCalculatorTest {

    private val statisticsCalculator = StatisticsCalculator()

    @Test
    fun `calculateLottoRanks should return correct ranks for tickets`() {
        val winningTicket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7, winningTicket)

        val purchasedTickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 8)),
            Lotto(listOf(1, 2, 3, 4, 10, 11)),
            Lotto(listOf(1, 2, 3, 10, 11, 12)),
            Lotto(listOf(10, 11, 12, 13, 14, 15))
        )

        val ranks = statisticsCalculator.calculateLottoRanks(purchasedTickets, winningTicket, bonusNumber)

        assertThat(ranks).containsExactly(
            LottoRank.SECOND,
            LottoRank.THIRD,
            LottoRank.FOURTH,
            LottoRank.FIFTH,
            LottoRank.NONE
        )
    }

    @Test
    fun `calculateReturnRate should return correct percentage`() {
        val ranks = listOf(
            LottoRank.FIRST,
            LottoRank.SECOND,
            LottoRank.FIFTH
        )
        val purchaseAmount = PurchaseAmount(10_000)
        val returnRate = statisticsCalculator.calculateReturnRate(ranks, purchaseAmount)

        val expectedTotalPrize = 2_000_000_000 + 30_000_000 + 5_000
        val expectedReturnRate = BigDecimal(expectedTotalPrize)
            .multiply(BigDecimal(100))
            .divide(BigDecimal(10_000))

        assertThat(returnRate).isEqualTo(expectedReturnRate)
    }
}