package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {

  @Test
  fun `returns correct Rank for 6 matches`() {
    val rank = Rank.of(6, false)
    assertThat(rank).isEqualTo(Rank.FIRST)
  }

  @Test
  fun `returns correct Rank for 5 matches with bonus`() {
    val rank = Rank.of(5, true)
    assertThat(rank).isEqualTo(Rank.SECOND)
  }

  @Test
  fun `returns correct Rank for 5 matches without bonus`() {
    val rank = Rank.of(5, false)
    assertThat(rank).isEqualTo(Rank.THIRD)
  }

  @Test
  fun `returns null for less than 3 matches`() {
    val rank = Rank.of(2, false)
    assertThat(rank).isNull()
  }
}
