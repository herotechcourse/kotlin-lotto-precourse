package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTicketTest {

    @Test
    fun `should create a LottoTicket with 6 unique numbers within range`() {
        val numbers = listOf(1, 10, 20, 30, 40, 45)
        val lottoTicket = LottoTicket(numbers)
        assertThat(lottoTicket.numbers).isEqualTo(numbers)
    }

    @Test
    fun `should throw IllegalArgumentException if LottoTicket has fewer than 6 numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            LottoTicket(numbers)
        }.message?.startsWith("[ERROR]") ?: false
    }

    @Test
    fun `should throw IllegalArgumentException if LottoTicket has more than 6 numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
        assertThrows<IllegalArgumentException> {
            LottoTicket(numbers)
        }.message?.startsWith("[ERROR]") ?: false
    }

    @Test
    fun `should throw IllegalArgumentException if LottoTicket has numbers out of range`() {
        val numbers = listOf(0, 10, 20, 30, 40, 45)
        assertThrows<IllegalArgumentException> {
            LottoTicket(numbers)
        }.message?.startsWith("[ERROR]") ?: false

        val numbers2 = listOf(1, 10, 20, 30, 40, 46)
        assertThrows<IllegalArgumentException> {
            LottoTicket(numbers2)
        }.message?.startsWith("[ERROR]") ?: false
    }

    @Test
    fun `should throw IllegalArgumentException if LottoTicket has duplicate numbers`() {
        val numbers = listOf(1, 10, 20, 30, 40, 1)
        assertThrows<IllegalArgumentException> {
            LottoTicket(numbers)
        }.message?.startsWith("[ERROR]") ?: false
    }

    @Test
    fun `should return the correct number of matches with winning numbers`() {
        val ticket = LottoTicket(listOf(1, 2, 3, 10, 11, 12))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertThat(ticket.match(winningNumbers)).isEqualTo(3)
    }

    @Test
    fun `should correctly identify if bonus number is present`() {
        val ticket = LottoTicket(listOf(1, 2, 3, 10, 11, 12))
        assertThat(ticket.hasBonus(12)).isTrue
        assertThat(ticket.hasBonus(13)).isFalse
    }
}