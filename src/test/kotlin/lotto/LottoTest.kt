package lotto

import lotto.domain.LottoMachine
import lotto.domain.Settings
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `should create lotto successfully with valid numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)

        assertThat(lotto.getNumbers()).isEqualTo(numbers)
    }

    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `should throw exception if numbers are outside valid range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are not sorted`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(5, 2, 3, 4, 7, 8))
        }
    }

    @Test
    fun `matchCount method should correctly count matching numbers`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 10, 11, 12)

        val matchCount = ticket.matchCount(winningNumbers)

        assertThat(matchCount).isEqualTo(3)
    }

    @Test
    fun `contains() should correctly detect presence of a number`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertThat(ticket.contains(3)).isTrue()
        assertThat(ticket.contains(10)).isFalse()
    }

    @Test
    fun `getNumbers() should return the ticket numbers`() {
        val numbers = listOf(10, 20, 30, 35, 40, 45)
        val lotto = Lotto(numbers)

        assertThat(lotto.getNumbers()).isEqualTo(numbers)
    }

    @Test
    fun `should not throw exception with randomly generated ticket`() {
        assertDoesNotThrow {
            Lotto(LottoMachine.createTicket().getNumbers())
        }
    }

    @Test
    fun `createTicket should generate a sorted ticket with 6 unique numbers`() {
        val ticket = LottoMachine.createTicket()
        assertThat(ticket.getNumbers()).hasSize(Settings.TICKET_LEN)
        assertThat(ticket.getNumbers().toSet().size).isEqualTo(Settings.TICKET_LEN)
        assertThat(ticket.getNumbers()).isSorted()
    }


}
