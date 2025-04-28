package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.junit.jupiter.api.Assertions.*

class OutputHandlerTest {
    private val outputHandler = OutputHandler()
    private val outputStreamCaptor = ByteArrayOutputStream()
    private val originalOut = System.out

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(originalOut)
    }

    @Test
    fun `printTicketNumber should print correct ticket count`() {
        outputHandler.printTicketNumber(5)
        val output = outputStreamCaptor.toString().trim()
        assertEquals("You have purchased 5 tickets.", output)
    }

    @Test
    fun `printTickets should print all tickets in correct format`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12))
        )
        outputHandler.printTickets(tickets)

        val output = outputStreamCaptor.toString().trim().lines()
        assertEquals("[1, 2, 3, 4, 5, 6]", output[0])
        assertEquals("[7, 8, 9, 10, 11, 12]", output[1])
    }

    @Test
    fun `printStatistics should print correct statistics format`() {
        val statistics = Statistics().apply {
            addResult(Rank.FIFTH)  // 3 matches
            addResult(Rank.FOURTH) // 4 matches
            addResult(Rank.THIRD)  // 5 matches
            addResult(Rank.SECOND) // 5 matches + bonus
            addResult(Rank.FIRST)  // 6 matches
        }

        outputHandler.printStatistics(statistics)

        val output = outputStreamCaptor.toString()
        assertTrue(output.contains("Lotto result statistics:"))
        assertTrue(output.contains("3 Matches (5,000 KRW) – 1 tickets"))
        assertTrue(output.contains("4 Matches (50,000 KRW) – 1 tickets"))
        assertTrue(output.contains("5 Matches (1,500,000 KRW) – 1 tickets"))
        assertTrue(output.contains("5 Matches + Bonus Ball (30,000,000 KRW) – 1 tickets"))
        assertTrue(output.contains("6 Matches (2,000,000,000 KRW) – 1 tickets"))
        assertTrue(output.contains("Total return rate is"))
    }

    @Test
    fun `printStatistics should handle zero counts correctly`() {
        val statistics = Statistics() // Empty statistics

        outputHandler.printStatistics(statistics)

        val output = outputStreamCaptor.toString()
        assertTrue(output.contains("3 Matches (5,000 KRW) – 0 tickets"))
        assertTrue(output.contains("4 Matches (50,000 KRW) – 0 tickets"))
        assertTrue(output.contains("5 Matches (1,500,000 KRW) – 0 tickets"))
        assertTrue(output.contains("5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets"))
        assertTrue(output.contains("6 Matches (2,000,000,000 KRW) – 0 tickets"))
    }

    @Test
    fun `printStatistics should display correct profit rate`() {
        val statistics = Statistics().apply {
            addResult(Rank.FIFTH)  // 5,000 won
            addResult(Rank.FOURTH) // 50,000 won
            // Total spent: 2,000 won
            // Expected profit rate: (55,000 / 2,000) * 100 = 2750.0%
        }

        outputHandler.printStatistics(statistics)

        val output = outputStreamCaptor.toString()
        assertTrue(output.contains("Total return rate is 2750.0%."))
    }
}

