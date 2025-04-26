package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMachineTest {
    @Test
    fun `throws an exception when purchase amount is negative`() {
        val lottoMachine = LottoMachine()
        
        assertThrows<IllegalArgumentException> {
            lottoMachine.generateTickets(-1000)
        }
    }

    @Test
    fun `throws an exception when purchase amount is not divisible by 1000`() {
        val lottoMachine = LottoMachine()
        
        assertThrows<IllegalArgumentException> {
            lottoMachine.generateTickets(1500)
        }
    }

    @Test
    fun `generates correct number of tickets`() {
        val lottoMachine = LottoMachine()
        
        val tickets = lottoMachine.generateTickets(5000)
        
        assertThat(tickets).hasSize(5)
    }

    @Test
    fun `generates no tickets when amount is zero`() {
        val lottoMachine = LottoMachine()
        
        val tickets = lottoMachine.generateTickets(0)
        
        assertThat(tickets).isEmpty()
    }
}
