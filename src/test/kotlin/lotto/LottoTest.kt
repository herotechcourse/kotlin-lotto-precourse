package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }


  @Test
  fun `throws an exception when lotto numbers contain duplicates`() {
    assertThrows<IllegalArgumentException> {
      Lotto(listOf(1, 2, 3, 4, 5, 5))
    }
  }
  @Test
  fun `throws an exception when lotto numbers are more than 6`() {
    assertThrows<IllegalArgumentException> {
      Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
    }
  }


  @Test
  fun `creates lotto successfully when valid numbers provided`() {
    val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
    assertEquals(6, lotto.getNumbers().size)
  }}
