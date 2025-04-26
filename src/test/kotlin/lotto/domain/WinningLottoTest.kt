package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningLottoTest {
 private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
 private val bonusNumber = 7

 @Test
 fun `getRank returns FIRST for 6 matches`() {
  val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
  val winningLotto = WinningLotto(winningNumbers, bonusNumber)
  assertThat(winningLotto.getRank(ticket)).isEqualTo(Rank.FIRST)
 }

 @Test
 fun `getRank returns SECOND for 5 matches plus bonus`() {
  val ticket = Lotto(listOf(1, 2, 3, 4, 5, 7))
  val winningLotto = WinningLotto(winningNumbers, bonusNumber)
  assertThat(winningLotto.getRank(ticket)).isEqualTo(Rank.SECOND)
 }

 @Test
 fun `getRank returns THIRD for 5 matches without bonus`() {
  val ticket = Lotto(listOf(1, 2, 3, 4, 5, 45))
  val winningLotto = WinningLotto(winningNumbers, bonusNumber)
  assertThat(winningLotto.getRank(ticket)).isEqualTo(Rank.THIRD)
 }

 @Test
 fun `getRank returns NONE when no match`() {
  val ticket = Lotto(listOf(10, 11, 12, 13, 14, 15))
  val winningLotto = WinningLotto(winningNumbers, bonusNumber)
  assertThat(winningLotto.getRank(ticket)).isEqualTo(Rank.NONE)
 }
 }
