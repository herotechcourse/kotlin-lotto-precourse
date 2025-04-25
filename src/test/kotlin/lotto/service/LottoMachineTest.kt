package lotto.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

 class LottoMachineTest{


  @Test
  fun `should generate correct number of tickets based on purchase amount`() {
   val lottoMachine = LottoMachine()

   val tickets = lottoMachine.generateTickets(1000)
   assertEquals(1, tickets.size)

   val tickets2 = lottoMachine.generateTickets(5000)
   assertEquals(5, tickets2.size)
  }

  @Test
  fun `should generate tickets with unique numbers`() {
   val lottoMachine = LottoMachine()

   val tickets = lottoMachine.generateTickets(1000)
   tickets.forEach { ticket ->
    val numbers = ticket.getNumbers()
    assertEquals(6, numbers.size)
    assertEquals(numbers.distinct().size, numbers.size)
   }
  }
 }
