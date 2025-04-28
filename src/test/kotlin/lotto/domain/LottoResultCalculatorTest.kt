package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.offset
import org.junit.jupiter.api.Test

class LottoResultCalculatorTest {
    @Test
    fun `calculateStats returns correct counts for each rank`() {
        // given
        val winning = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        val bonus = BonusNumber(7)
        val calculator = LottoResultCalculator(winning, bonus)

        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),    // FIRST
            Lotto(listOf(1, 2, 3, 4, 5, 7)),    // SECOND (5 matches + bonus)
            Lotto(listOf(1, 2, 3, 4, 5, 8)),    // THIRD (5 matches)
            Lotto(listOf(1, 2, 3, 4, 8, 9)),    // FOURTH (4 matches)
            Lotto(listOf(1, 2, 3, 8, 9, 10)),    // FIFTH (3 matches)
            Lotto(listOf(7, 8, 9, 10, 11, 12))  // MISS
        )

        // when
        val stats = calculator.calculateStats(lottos)

        // then
        assertThat(stats).hasSize(Rank.entries.size)
        assertThat(stats[Rank.FIRST]).isEqualTo(1)
        assertThat(stats[Rank.SECOND]).isEqualTo(1)
        assertThat(stats[Rank.THIRD]).isEqualTo(1)
        assertThat(stats[Rank.FOURTH]).isEqualTo(1)
        assertThat(stats[Rank.FIFTH]).isEqualTo(1)
    }

    @Test
    fun `calculateRate returns correct percent for mixed prize statistics`() {
        // given
        val winning = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        val bonus = BonusNumber(7)
        val calculator = LottoResultCalculator(winning, bonus)

        // 2 fifth prizes (5,000 KRW each) and 1 fourth prize (50,000 KRW)
        val stats = mapOf(
            Rank.FIFTH to 2,
            Rank.FOURTH to 1
        )
        val purchase = PurchaseAmount(3_000) // purchased 3 tickets

        // when
        val rate = calculator.calculateRate(stats, purchase)

        // then
        // total prize = 2*5_000 + 1*50_000 = 60_000
        // rate = 60_000 / 3_000 * 100 = 2_000%
        assertThat(rate).isCloseTo(2000.0, offset(0.0001))
    }
}
