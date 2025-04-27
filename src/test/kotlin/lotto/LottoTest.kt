package lotto

import org.assertj.core.api.Assertions.assertThat
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
    fun `should create a Lotto when number are unique and amount is 6`() {
        val lotto = Lotto(listOf(41, 42, 43, 44, 45, 6))
        assertThat(lotto).isNotNull
    }

    @Test
    fun `should return amount of matching number in the ticket`() {
        val lotto = Lotto(listOf(41, 42, 43, 44, 45, 6))
        val count = lotto.matchCount(listOf(6, 7, 8, 41, 15))
        assertThat(count).isEqualTo(2)
    }

    @Test
    fun `should return true when number is present in the ticket`() {
        val lotto = Lotto(listOf(41, 42, 43, 44, 45, 6))
        val containNumber = lotto.contains(43)
        assertThat(containNumber).isEqualTo(true)
    }
}
