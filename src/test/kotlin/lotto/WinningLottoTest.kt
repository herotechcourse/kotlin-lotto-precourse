package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {

    @Test
    fun `should return FIRST prize for 6 matches`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        assertThat(winningLotto.compare(ticket)).isEqualTo(Prize.FIRST)
    }

    @Test
    fun `should return SECOND_BONUS prize for 5 matches and bonus ball`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 8), 6)
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        assertThat(winningLotto.compare(ticket)).isEqualTo(Prize.SECOND_BONUS)
    }

    @Test
    fun `should return THIRD prize for 5 matches`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 8), 6)
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 5, 10))
        assertThat(winningLotto.compare(ticket)).isEqualTo(Prize.THIRD)
    }

    @Test
    fun `should return FOURTH prize for 4 matches`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 10, 11), 12)
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 15, 16))
        assertThat(winningLotto.compare(ticket)).isEqualTo(Prize.FOURTH)
    }

    @Test
    fun `should return FIFTH prize for 3 matches`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 10, 11, 12), 13)
        val ticket = LottoTicket(listOf(1, 2, 3, 15, 16, 17))
        assertThat(winningLotto.compare(ticket)).isEqualTo(Prize.FIFTH)
    }

    @Test
    fun `should return NONE prize for less than 3 matches`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 10, 11, 12), 13)
        val ticket = LottoTicket(listOf(1, 2, 15, 16, 17, 18))
        assertThat(winningLotto.compare(ticket)).isEqualTo(Prize.NONE)
    }

    @Test
    fun `should throw IllegalArgumentException if winning numbers are invalid`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5), 6)
        }.message?.startsWith("[ERROR]") ?: false
    }

    @Test
    fun `should throw IllegalArgumentException if winning numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 5), 7)
        }.message?.startsWith("[ERROR]") ?: false
    }

    @Test
    fun `should throw IllegalArgumentException if winning numbers are out of range`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(0, 1, 2, 3, 4, 5), 6)
        }.message?.startsWith("[ERROR]") ?: false
    }

    @Test
    fun `should throw IllegalArgumentException if bonus number is out of range`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 0)
        }.message?.startsWith("[ERROR]") ?: false
    }

    @Test
    fun `should throw IllegalArgumentException if bonus number is the same as a winning number`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 6)
        }.message?.startsWith("[ERROR]") ?: false
    }
}