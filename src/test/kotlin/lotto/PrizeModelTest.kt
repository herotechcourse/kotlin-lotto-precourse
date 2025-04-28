package lotto

import lotto.model.Prize
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.assertj.core.api.Assertions.assertThat

class PrizeModelTest {
  @Test
  fun `getPrize returns correct prize for matching count and bonus`() {
    assertThat(Prize.getPrize(6, false)).isEqualTo(Prize.FIRST)
    assertThat(Prize.getPrize(5, true)).isEqualTo(Prize.SECOND)
    assertThat(Prize.getPrize(5, false)).isEqualTo(Prize.THIRD)
    assertThat(Prize.getPrize(4, false)).isEqualTo(Prize.FOURTH)
    assertThat(Prize.getPrize(3, false)).isEqualTo(Prize.FIFTH)
    assertThat(Prize.getPrize(2, false)).isEqualTo(Prize.NONE)
    assertThat(Prize.getPrize(1, false)).isEqualTo(Prize.NONE)
    assertThat(Prize.getPrize(0, false)).isEqualTo(Prize.NONE)
  }

  @Test
  fun `getPrize returns NONE for invalid matching count and bonus`() {
    assertThat(Prize.getPrize(7, false)).isEqualTo(Prize.NONE)
    assertThat(Prize.getPrize(-1, false)).isEqualTo(Prize.NONE)
    assertThat(Prize.getPrize(3, true)).isEqualTo(Prize.NONE)
  }

}