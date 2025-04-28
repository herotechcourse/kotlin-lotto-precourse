package lotto

import lotto.model.LottoResult
import lotto.model.Prize
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.assertj.core.api.Assertions.assertThat

class LottoResultModelTest {
  @Test
  fun `getResult returns correct result`() {
    val results = mapOf(
      Prize.FIRST to 1,
      Prize.SECOND to 1,
      Prize.THIRD to 1,
      Prize.FOURTH to 2,
      Prize.FIFTH to 3,
      Prize.NONE to 0
    )
    val lottoResult = LottoResult(results, 10)
    val expectedPrize = Prize.FIRST.prize * 1 +
        Prize.SECOND.prize * 1 +
        Prize.THIRD.prize * 1 +
        Prize.FOURTH.prize * 2 +
        Prize.FIFTH.prize * 3
    assertThat(lottoResult.getTotalPrize()).isEqualTo(expectedPrize)
  }

  @Test
  fun `calculate profit rate correctly`() {
    val results = mapOf(
      Prize.FOURTH to 1,
      Prize.NONE to 0
    )
    val lottoResult = LottoResult(results, 1)
    assertThat(lottoResult.getProfitRate()).isEqualTo(5000.0)
  }
}