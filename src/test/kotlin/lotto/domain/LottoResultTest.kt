package lotto.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class LottoResultTest {

 @Test
 fun `should calculate total winnings correctly`() {
  val statistics = mapOf(
   PrizeCategory.THREE_MATCHES to 2, // 2 tickets with 5,000 KRW each
   PrizeCategory.FOUR_MATCHES to 1, // 1 ticket with 50,000 KRW
   PrizeCategory.FIVE_MATCHES to 0, // 0 tickets
   PrizeCategory.SIX_MATCHES to 1  // 1 ticket with 2,000,000,000 KRW
  )
  val lottoResult = LottoResult(statistics)

  val totalWinnings = lottoResult.totalWinnings()

  assertThat(totalWinnings).isEqualTo(
   (2 * PrizeCategory.THREE_MATCHES.prizeAmount) +
           (1 * PrizeCategory.FOUR_MATCHES.prizeAmount) +
           (1 * PrizeCategory.SIX_MATCHES.prizeAmount)
  )
 }

 @Test
 fun `should return correct statistics`() {
  val statistics = mapOf(
   PrizeCategory.THREE_MATCHES to 2,
   PrizeCategory.FOUR_MATCHES to 1
  )
  val lottoResult = LottoResult(statistics)

  assertThat(lottoResult.statistics).isEqualTo(statistics)
 }
}