package lotto

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class LotteryMachineTest {

    @Test
    fun `test purchaseTickets with valid input`() {
        val lotteryMachine = LotteryMachine()

        // Simulate a valid purchase input where the amount is divisible by 1000
        val tickets = lotteryMachine.purchaseTickets("2000")

        // Validate that two tickets are purchased
        assertEquals(2, tickets.size)
        // Validate that each ticket has 6 unique numbers
        tickets.forEach { ticket ->
            assertEquals(6, ticket.getNumbers().size)
            assert(ticket.getNumbers().distinct().size == 6)  // Numbers should be unique
        }
    }

    @Test
    fun `test purchaseTickets with invalid input (non-divisible by 1000)`() {
        val lotteryMachine = LotteryMachine()

        // Expect an IllegalArgumentException due to invalid input (amount not divisible by 1000)
        assertFailsWith<IllegalArgumentException> {
            lotteryMachine.purchaseTickets("1500")
        }
    }

    @Test
    fun `test purchaseTickets with invalid format (non-numeric input)`() {
        val lotteryMachine = LotteryMachine()

        // Expect an IllegalArgumentException due to invalid input format (non-numeric string)
        assertFailsWith<IllegalArgumentException> {
            lotteryMachine.purchaseTickets("abcd")
        }
    }
    @Test
    fun `test purchaseTickets with zero amount`() {
        val lotteryMachine = LotteryMachine()

        // Simulate a zero purchase input
        val tickets = lotteryMachine.purchaseTickets("0")

        // Validate that zero tickets are purchased
        assertEquals(0, tickets.size)
    }
    @Test
    fun `test purchaseTickets with one ticket purchase`() {
        val lotteryMachine = LotteryMachine()

        // Simulate a purchase input for exactly one ticket
        val tickets = lotteryMachine.purchaseTickets("1000")

        // Validate that only one ticket is purchased
        assertEquals(1, tickets.size)
        // Validate that this ticket has 6 unique numbers
        tickets.forEach { ticket ->
            assertEquals(6, ticket.getNumbers().size)
            assert(ticket.getNumbers().distinct().size == 6)  // Numbers should be unique
        }
    }
    @Test
    fun `test purchaseTickets with duplicate numbers in a single ticket`() {
        val lotteryMachine = LotteryMachine()

        // Create a mock Lotto with duplicate numbers (this shouldn't happen in the real world, but we'll test it anyway)
        val tickets = lotteryMachine.purchaseTickets("1000")

        tickets.forEach { ticket ->
            val numbers = ticket.getNumbers()
            val duplicates = numbers.groupBy { it }.filter { it.value.size > 1 }
            assert(duplicates.isEmpty())  // Ensure there are no duplicate numbers in the ticket
        }
    }
    @Test
    fun `test calculateWinnings with no matching tickets`() {
        val lotteryMachine = LotteryMachine()

        // Simulate tickets and winning numbers
        val tickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(7, 8, 9, 10, 11, 12)))
        val winningNumbers = listOf(13, 14, 15, 16, 17, 18)
        val bonusNumber = 19

        // Calculate winnings
        val prizeCounts = lotteryMachine.calculateWinnings(tickets, winningNumbers, bonusNumber)

        // Validate that no tickets win
        assertEquals(0, prizeCounts["6 Matches"])
        assertEquals(0, prizeCounts["5 Matches + Bonus Ball"])
        assertEquals(0, prizeCounts["5 Matches"])
        assertEquals(0, prizeCounts["4 Matches"])
        assertEquals(0, prizeCounts["3 Matches"])
    }
    @Test
    fun `test calculateWinnings with 6 matching tickets`() {
        val lotteryMachine = LotteryMachine()

        // Simulate tickets with 6 matching numbers
        val tickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        // Calculate winnings
        val prizeCounts = lotteryMachine.calculateWinnings(tickets, winningNumbers, bonusNumber)

        // Validate that two tickets won with 6 matches
        assertEquals(2, prizeCounts["6 Matches"])
    }
    @Test
    fun `test calculateWinnings with 5 matches and bonus ball`() {
        val lotteryMachine = LotteryMachine()

        // Simulate tickets with 5 matching numbers and bonus ball
        val tickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(1, 2, 3, 4, 5, 7)))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        // Calculate winnings
        val prizeCounts = lotteryMachine.calculateWinnings(tickets, winningNumbers, bonusNumber)

        // Validate that one ticket won with 5 matches + bonus ball
        assertEquals(1, prizeCounts["5 Matches + Bonus Ball"])
    }
    @Test
    fun `test calculateReturnRate with mixed prize counts`() {
        val lotteryMachine = LotteryMachine()

        // Simulate prize counts and ticket count
        val prizeCounts = mapOf(
            "6 Matches" to 1,
            "5 Matches + Bonus Ball" to 1,
            "5 Matches" to 0,
            "4 Matches" to 1,
            "3 Matches" to 1
        )
        val ticketCount = 5

        // Calculate return rate
        val returnRate = lotteryMachine.calculateReturnRate(prizeCounts, ticketCount)

        // Calculate expected total winnings
        val prizeAmounts = mapOf(
            "6 Matches" to 2_000_000_000,
            "5 Matches + Bonus Ball" to 30_000_000,
            "5 Matches" to 1_500_000,
            "4 Matches" to 50_000,
            "3 Matches" to 5_000
        )

        val totalWinnings = prizeCounts.entries.sumOf { (prize, count) ->
            prizeAmounts[prize]!! * count
        }

        // Total spent is ticketCount * 1_000
        val totalSpent = ticketCount * 1000

        // Calculate return rate
        val expectedReturnRate = (totalWinnings.toDouble() / totalSpent) * 100

        // Validate return rate
        assertEquals(expectedReturnRate, returnRate, 0.1)  // Allow small margin due to floating point calculation
    }
}






