package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

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
    fun `numbers are returned in sorted order`() {
      val lotto = Lotto(listOf(5, 3, 1, 4, 2, 6))
      assertThat(lotto.getSortedNumbers()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }
  
    @Test
    fun `counts matching numbers with winning numbers`() {
      val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
      val winningNumbers = listOf(1, 3, 5, 7, 9, 11)
      assertThat(lotto.countMatchingNumbers(winningNumbers)).isEqualTo(3)
    }
  
    @Test
    fun `checks if bonus number is included`() {
      val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
      assertThat(lotto.hasBonusNumber(5)).isTrue
      assertThat(lotto.hasBonusNumber(7)).isFalse
    }
  
    @Test
    fun `throws exception when lotto numbers are not exactly 6`() {
      assertThrows<IllegalArgumentException> { Lotto(listOf(1, 2, 3, 4, 5)) }
    }
  
    @Test
    fun `throws exception when lotto numbers are out of range 1-45`() {
      assertThrows<IllegalArgumentException> { Lotto(listOf(1, 2, 3, 4, 5, 46)) }
    }
}
