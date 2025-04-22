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
    fun `matchCount returns number of matching numbers`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winning = listOf(2, 3, 9, 10, 11, 12)
        assertThat(ticket.matchCount(winning)).isEqualTo(2)
    }

    @Test
    fun `contains returns true if number is in ticket`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(ticket.contains(4)).isTrue()
        assertThat(ticket.contains(10)).isFalse()
    }
}
