package lotto

import lotto.Lotto
import lotto.model.Prize
import lotto.model.WinningLotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.assertj.core.api.Assertions.assertThat

class WinningLottoModelTest{
  @Test
  fun `getNumbers returns correct numbers`() {
    val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
    assertThat(winningLotto.getNumbers()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
  }

  @Test
  fun `getBonusNumber returns correct bonus number`() {
    val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
    assertThat(winningLotto.getBonusNumber()).isEqualTo(7)
  }

  @Test
  fun `match returns correct prize`() {
    val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
    val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
    assertThat(winningLotto.match(lotto)).isEqualTo(Prize.SECOND)
  }
}