package lotto

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoTest {

  @Test
  fun `throws exception if not exactly 6 numbers`() {
    assertThatThrownBy {
      Lotto(listOf(1, 2, 3, 4, 5)) // only 5 numbers
    }.isInstanceOf(IllegalArgumentException::class.java)
     .hasMessageContaining("[ERROR]")
  }

  @Test
  fun `throws exception if there are duplicate numbers`() {
    assertThatThrownBy {
      Lotto(listOf(1, 2, 3, 3, 4, 5))
    }.isInstanceOf(IllegalArgumentException::class.java)
     .hasMessageContaining("[ERROR]")
  }

  @Test
  fun `throws exception if a number is out of range`() {
    assertThatThrownBy {
      Lotto(listOf(0, 2, 3, 4, 5, 6))
    }.isInstanceOf(IllegalArgumentException::class.java)
     .hasMessageContaining("[ERROR]")
  }
}
