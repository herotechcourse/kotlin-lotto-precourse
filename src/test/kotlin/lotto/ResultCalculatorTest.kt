package lotto

import lotto.domain.PrizeRank
import lotto.domain.ResultCalculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ResultCalculatorTest {
    private val winning = setOf(1, 2, 3, 4, 5, 6)
    private val bonus = 7
    private val calc = ResultCalculator(winning, bonus)

    @Test
    fun `calculate counts for all prize ranks`() {
        val tickets = listOf(
            Lotto(listOf(1,2,3,7,8,9)),  // 3 matches → FIFTH
            Lotto(listOf(1,2,3,4,8,9)),  // 4 matches → FOURTH
            Lotto(listOf(1,2,3,4,5,9)),  // 5 matches → THIRD
            Lotto(listOf(1,2,3,4,5,7)),  // 5 + bonus → SECOND
            Lotto(listOf(1,2,3,4,5,6))   // 6 matches → FIRST
        )

        val results = calc.calculate(tickets)
        assertEquals(1, results.getOrDefault(PrizeRank.FIFTH, 0))
        assertEquals(1, results.getOrDefault(PrizeRank.FOURTH, 0))
        assertEquals(1, results.getOrDefault(PrizeRank.THIRD, 0))
        assertEquals(1, results.getOrDefault(PrizeRank.SECOND, 0))
        assertEquals(1, results.getOrDefault(PrizeRank.FIRST, 0))
    }

    @Test
    fun `profitRate computes correct percentage`() {
        val counts = mapOf(
            PrizeRank.FIRST  to 1,  // 2,000,000,000
            PrizeRank.SECOND to 1,  //    30,000,000
            PrizeRank.THIRD  to 1,  //  1,500,000
            PrizeRank.FOURTH to 1,  //     50,000
            PrizeRank.FIFTH  to 1   //      5,000
        )
        // total prize = 2_031_555_000, purchase = 5 tickets * 1000
        val rate = calc.profitRate(counts, purchaseAmount = 5_000)
        // 2_031_555_000 / 5_000 * 100 = 40_631_100.0%
        assertEquals(40631100.0, rate)
    }
}
