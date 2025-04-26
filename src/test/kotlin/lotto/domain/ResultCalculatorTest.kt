package lotto.domain

import WinningNumbers
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class ResultCalculatorTest {

 @Test
 fun `should calculate correct prize counts`() {
  val tickets = listOf(
   Lotto(listOf(1, 2, 3, 4, 5, 6)), // 6 matches
   Lotto(listOf(1, 2, 3, 4, 5, 7)), // 5 matches + bonus
   Lotto(listOf(1, 2, 3, 4, 5, 8)), // 5 matches
   Lotto(listOf(1, 2, 3, 4, 9, 10)), // 4 matches
   Lotto(listOf(1, 2, 3, 11, 12, 13)) // 3 matches
  )
  val winningNumbers = WinningNumbers(
   numbers = listOf(1, 2, 3, 4, 5, 6),
   bonus = 7
  )
  val resultCalculator = ResultCalculator()

  val result = resultCalculator.calculate(tickets, winningNumbers)

  assertThat(result.statistics).containsExactlyInAnyOrderEntriesOf(
   mapOf(
    PrizeCategory.SIX_MATCHES to 1,
    PrizeCategory.FIVE_MATCHES_BONUS to 1,
    PrizeCategory.FIVE_MATCHES to 1,
    PrizeCategory.FOUR_MATCHES to 1,
    PrizeCategory.THREE_MATCHES to 1
   )
  )
 }

 @Test
 fun `should calculate correct profit rate`() {
  val statistics = mapOf(
   PrizeCategory.SIX_MATCHES to 1, // 2,000,000,000 KRW
   PrizeCategory.FIVE_MATCHES to 2 // 1,500,000 KRW each
  )
  val result = LottoResult(statistics)
  val resultCalculator = ResultCalculator()

  val profitRate = resultCalculator.calculateProfitRate(result, 10_000)

  assertThat(profitRate).isEqualTo(
   ((2_000_000_000 + (2 * 1_500_000)).toDouble() / 10_000) * 100
  )
 }
}