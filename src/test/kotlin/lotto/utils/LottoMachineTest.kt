package lotto.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
 class LottoMachineTest {

@Test
 fun testCalculateTicketCount() {

  val input = 8000
  val ticketCount = LottoMachine.calculateTicketCount(input)
  assertEquals(8, ticketCount)

 }

//  testGenerateTickets
//  1. If I request 5 tickets, the list must contain 5 Lotto instances.
@Test
 fun testGenerateTickets_shouldCreateTheCorrectNumberOfTickets() {
  val ticketCount = 5
  val tickets = LottoMachine.generateTickets(ticketCount)
  assertThat(tickets).hasSize(ticketCount)
 }

 //  2. Each Lotto must have 6 unique numbers.
  @Test
 fun testGenerateTickets_everyTicketShouldHaveSixUniqueNumbers() {
  val ticketCount = 5
  val tickets =
   LottoMachine.generateTickets(
    ticketCount
   )

  for (ticket in tickets) {
   val numbers = ticket.getNumbers()
   assertThat(numbers).hasSize(6)

   val setOfNumbers = numbers.toSet()
   assertThat(setOfNumbers).hasSize(6)
  }
 }

  //  3. Each number should be between 1 and 45.
  @Test
  fun testGenerateTickets_everyNumberShouldBeIsInRange() {
   val ticketCount = 5
   val tickets = LottoMachine.generateTickets(ticketCount)

   for (ticket in tickets) {
    val numbers = ticket.getNumbers()
    assertThat(numbers).allSatisfy { number ->
     assertThat(number).isBetween(1,45)
    }
   }
 }
}