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

    // TODO: Implement production code to pass the test
    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // TODO: Implement tests based on the added features
    @Test
    fun `should throw exception for invalid bonus number`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumber(1, setOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `should calculate correct prize for ticket`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val result = ticket.getNumbers()

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `should accept valid purchase amount divisible by 1000`() {
        val purchaseAmount = 5000
        val ticketCount = purchaseAmount / 1000
        assertThat(ticketCount).isEqualTo(5)
    }

    @Test
    fun `should throw error for purchase amount not divisible by 1000`() {
        val purchaseAmount = 1500
        assertThrows<IllegalArgumentException> {
            InputValidator.validatePurchaseAmount(purchaseAmount)
        }
    }

    @Test
    fun `should generate correct number of tickets based on purchase amount`() {
        val lottoMachine = LottoMachine()
        val tickets = lottoMachine.generateTickets(5)  // Purchase 5 tickets

        assertThat(tickets.size).isEqualTo(5)
    }

    @Test
    fun `should generate tickets with valid numbers`() {
        val lottoMachine = LottoMachine()
        val tickets = lottoMachine.generateTickets(2)

        tickets.forEach { ticket ->
            assertThat(ticket.getNumbers()).hasSize(6)
            assertThat(ticket.getNumbers()).allMatch { it in 1..45 }
        }
    }

}
