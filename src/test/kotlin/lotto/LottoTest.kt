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
    fun `get amount of winning numbers in ticket test`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val ticket = listOf(2, 3, 4, 5, 6, 7)
        val ticket2 = listOf(12, 13, 14, 15, 16, 17)
        assertThat(lotto.getAmountOfWinningNumbersInTicket(ticket)).isEqualTo(5)
        assertThat(lotto.getAmountOfWinningNumbersInTicket(ticket2)).isEqualTo(0)
    }

}
