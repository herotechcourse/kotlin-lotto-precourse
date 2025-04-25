package lotto.service

import lotto.Lotto
import lotto.domain.Rank
import lotto.domain.WinningLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoStatisticsTest {

 private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
 private val bonusNumber = 7
 private val winningLotto = WinningLotto(winningNumbers, bonusNumber)

 @Test
 fun `calculate should count the number of ranks correctly`() {
  val tickets = listOf(
   Lotto(listOf(1, 2, 3, 4, 5, 6)),
   Lotto(listOf(1, 2, 3, 4, 5, 7)),
   Lotto(listOf(1, 2, 3, 4, 5, 45)),
   Lotto(listOf(1, 2, 3, 4, 44, 45)),
   Lotto(listOf(1, 2, 3, 43, 44, 45)),
   Lotto(listOf(10, 20, 30, 40, 41, 42))
  )

  val statistics = LottoStatistics.calculate(tickets, winningLotto)

  assertThat(statistics[Rank.FIRST]).isEqualTo(1)
  assertThat(statistics[Rank.SECOND]).isEqualTo(1)
  assertThat(statistics[Rank.THIRD]).isEqualTo(1)
  assertThat(statistics[Rank.FOURTH]).isEqualTo(1)
  assertThat(statistics[Rank.FIFTH]).isEqualTo(1)
  assertThat(statistics[Rank.NONE]).isEqualTo(1)
 }

 @Test
 fun `calculate should return empty map for no tickets`() {
  val tickets = emptyList<Lotto>()
  val statistics = LottoStatistics.calculate(tickets, winningLotto)
  assertThat(statistics).isEmpty()
 }
}
