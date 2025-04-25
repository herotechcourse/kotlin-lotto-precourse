package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class LottoGameTest {
    private val lottoGame = LottoGame()

    @Test
    fun `throws an exception when the amount is negative`() {
        assertThrows<IllegalArgumentException> {
            val lottoGame = LottoGame()
            lottoGame.createLottoTickets(-1)
        }
    }

    @Test
    fun `throws an exception when the amount is 0`() {
        assertThrows<IllegalArgumentException> {
            lottoGame.createLottoTickets(0)
        }
    }

    @Test
    fun `create sorted lotto tickets when the amount is positive`() {
        val tickets = lottoGame.createLottoTickets(2)

        assertThat(tickets).hasSize(2)
        tickets.forEach { ticket ->
            val ticketNumbers = ticket.getNumbers()
            assertThat(ticketNumbers).hasSize(6)
            assertThat(ticketNumbers).isEqualTo(ticketNumbers.sorted())
        }
    }

}


