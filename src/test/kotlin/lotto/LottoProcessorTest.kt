package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

private var lottoProcessor = LottoProcessor()

class LottoProcessorTest {
    @Test
    fun `ticketGenerator should return correct number of tickets`() {
        val tickets = lottoProcessor.ticketGenerator(3000)
        assertThat(tickets).hasSize(3)
    }

    @Test
    fun `tickerGenerator should return no ticket when amount is less`() {
        val tickets = lottoProcessor.ticketGenerator(900)
        assertThat(tickets).isEmpty()
    }

    @Test
    fun `prizeCalculator should return correct prize groups`() {
        val tickets = listOf(
            Lotto(listOf(1,2,3,4,5,6)),
            Lotto(listOf(1,2,3,4,5,7)),
            Lotto(listOf(1,2,3,4,5,8)),
        )
        val winningNumbers = listOf(1,2,3,4,5,6)
        val bonusNumber = 7

        val prizeCategory = lottoProcessor.prizeCalculator(tickets, winningNumbers, bonusNumber)

        assertThat(prizeCategory).containsEntry(Prize.FIRST, 1)
        assertThat(prizeCategory).containsEntry(Prize.SECOND, 1)
        assertThat(prizeCategory).containsEntry(Prize.THIRD, 1)
    }

    @Test
    fun `prizeCalculator should return no prize groups`() {
        val tickets = listOf(
            Lotto(listOf(1,2,3,4,5,6)),
            Lotto(listOf(1,2,3,4,5,7)),
            Lotto(listOf(1,2,3,4,5,8)),
        )
        val winningNumbers = listOf(11,12,13,14,15,16)
        val bonusNumber = 7

        val prizeCategory = lottoProcessor.prizeCalculator(tickets, winningNumbers, bonusNumber)

        assertThat(prizeCategory).containsEntry(Prize.NONE, 3)
    }

    @Test
    fun `prizeCalculator should return mixed result groups`() {
        val tickets = listOf(
            Lotto(listOf(1,2,3,4,5,6)),
            Lotto(listOf(11,2,3,4,5,7)),
            Lotto(listOf(1,12,13,4,5,8)),
            Lotto(listOf(11,12,13,4,5,8)),
        )
        val winningNumbers = listOf(11,12,13,14,15,16)
        val bonusNumber = 7

        val prizeCategory = lottoProcessor.prizeCalculator(tickets, winningNumbers, bonusNumber)

        assertThat(prizeCategory).containsEntry(Prize.NONE, 3)
        assertThat(prizeCategory).containsEntry(Prize.FIFTH, 1)
    }

    @Test
    fun `calculateProfitRate should return correct profit rate`() {
        val prizeDistribution = mapOf(
            Prize.FIRST to 1,
            Prize.SECOND to 2
        )
        val totalSpent = 3000
        val profitRate = lottoProcessor.profitRateCalculator(totalSpent, prizeDistribution)

        assertThat(profitRate).isGreaterThan(0.0)
    }

    @Test
    fun `calculateProfitRate should return 0 when totalSpent is 0`() {
        val prizeDistribution = mapOf(
            Prize.FIRST to 1,
            Prize.SECOND to 2
        )
        val totalSpent = 0
        val profitRate = lottoProcessor.profitRateCalculator(totalSpent, prizeDistribution)

        assertThat(profitRate).isEqualTo(0.0)
    }

    @Test
    fun `calculatePrizes should handle empty ticket list`() {
        val tickets = emptyList<Lotto>()
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val prizeDistribution = lottoProcessor.prizeCalculator(tickets, winningNumbers, bonusNumber)

        assertThat(prizeDistribution).isEmpty()
    }
}