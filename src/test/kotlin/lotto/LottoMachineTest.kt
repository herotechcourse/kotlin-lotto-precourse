package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoMachineTest {
    
    @Test
    fun `generateTickets should throw when count is not positive`() {
        val lottoMachine = LottoMachine()
        
        assertThatThrownBy { lottoMachine.generateTickets(0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Ticket count must be positive.")
    }
    
    @ParameterizedTest
    @ValueSource(ints = [1, 5, 10])
    fun `generateTickets should return correct number of tickets`(count: Int) {
        val lottoMachine = LottoMachine()
        val tickets = lottoMachine.generateTickets(count)
        
        assertThat(tickets).hasSize(count)
    }
    
    @Test
    fun `generated tickets should have valid numbers`() {
        val lottoMachine = LottoMachine()
        val tickets = lottoMachine.generateTickets(5)
        
        tickets.forEach { ticket ->
            val numbers = ticket.getNumbers()
            assertThat(numbers).hasSize(6)
            assertThat(numbers).allMatch { it in 1..45 }
            assertThat(numbers).doesNotHaveDuplicates()
        }
    }
}