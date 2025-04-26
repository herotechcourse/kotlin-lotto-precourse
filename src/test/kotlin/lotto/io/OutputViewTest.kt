package lotto.io

import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.domain.PrizeCategory
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class OutputViewTest {

 class TestIO : IOInterface {
  val output = mutableListOf<String>()
  private val input = mutableListOf<String>()

  override fun print(content: String) {
   output.add(content)
  }

  override fun read(): String {
   return if (input.isNotEmpty()) input.removeAt(0) else ""
  }

  fun addInput(vararg inputs: String) {
   input.addAll(inputs)
  }
 }

 @Test
 fun `should print purchased tickets`() {
  val testIO = TestIO()
  val outputView = OutputView(testIO)
  val tickets = listOf(
   Lotto(listOf(1, 2, 3, 4, 5, 6)),
   Lotto(listOf(7, 8, 9, 10, 11, 12))
  )

  outputView.printPurchasedTickets(tickets)

  assertThat(testIO.output).containsExactly(
   "You have purchased 2 tickets.",
   "[1, 2, 3, 4, 5, 6]",
   "[7, 8, 9, 10, 11, 12]"
  )
 }

 @Test
 fun `should print results`() {
  val testIO = TestIO()
  val outputView = OutputView(testIO)
  val result = LottoResult(
   statistics = mapOf(
    PrizeCategory.THREE_MATCHES to 1,
    PrizeCategory.FOUR_MATCHES to 0,
    PrizeCategory.FIVE_MATCHES to 0,
    PrizeCategory.SIX_MATCHES to 0
   )
  )
  val profitRate = 62.5

  outputView.printResult(result, profitRate)

  assertThat(testIO.output).containsExactly(
   "\nWinning Statistics\n---",
   "3 Matches (5,000 KRW) – 1 tickets",
   "4 Matches (50,000 KRW) – 0 tickets",
   "5 Matches (1,500,000 KRW) – 0 tickets",
   "5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets",
   "6 Matches (2,000,000,000 KRW) – 0 tickets",
   "Total return rate is 62.5%."
  )
 }
}