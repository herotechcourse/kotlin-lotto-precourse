package lotto.usecases

import lotto.domain.model.Rank
import lotto.domain.usecases.ComputeProfitUseCase
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ComputeProfitUseCaseTest {

    private val computeProfitUseCase = ComputeProfitUseCase()

    @Test
    fun `returns 0 percent profit when no ranks`() {
        val ranks = emptyList<Rank>()
        val totalSpent = 5000

        val profitRate = computeProfitUseCase.run(ranks, totalSpent)

        assertEquals(0.0, profitRate)
    }

    @Test
    fun `calculates correct profit when ranks have prizes`() {
        val ranks = listOf(Rank.FIFTH, Rank.FOURTH)
        val totalSpent = 10000

        val profitRate = computeProfitUseCase.run(ranks, totalSpent)

        val expectedProfitRate = ((5_000 + 50_000).toDouble() / 10_000) * 100
        assertEquals(expectedProfitRate, profitRate)
    }

    @Test
    fun `returns 100 percent profit when totalPrize equals totalSpent`() {
        val ranks = listOf(Rank.FIFTH, Rank.FIFTH)
        val totalSpent = 10_000

        val profitRate = computeProfitUseCase.run(ranks, totalSpent)

        assertEquals(100.0, profitRate)
    }

    @Test
    fun `returns correct profit rate for multiple winning ranks`() {
        val ranks = listOf(Rank.FIRST, Rank.SECOND, Rank.FIFTH)
        val totalSpent = 2_000_000_000

        val profitRate = computeProfitUseCase.run(ranks, totalSpent)

        val expectedProfitRate = ((2_000_000_000 + 30_000_000 + 5_000).toDouble() / totalSpent) * 100
        assertEquals(expectedProfitRate, profitRate)
    }
}
