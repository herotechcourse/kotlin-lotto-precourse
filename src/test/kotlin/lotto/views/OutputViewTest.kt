package lotto.views

import lotto.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.PrintStream
import java.io.ByteArrayOutputStream

class OutputViewTest {
    private val outputView = OutputView()
    private val outputStream = ByteArrayOutputStream()

    @Test
    fun `print purchased tickets`() {
        System.setOut(PrintStream(outputStream))

        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12))
        )
        val ticketCount = 2

        outputView.printPurchasedTickets(tickets, ticketCount)

        val expectedOutput = """
            You have purchased $ticketCount tickets.
            [1, 2, 3, 4, 5, 6]
            [7, 8, 9, 10, 11, 12]
            """.trimIndent()

        val actualOutput = outputStream.toString().trim()

        assertEquals(expectedOutput, actualOutput)
        System.setOut(System.out)
    }

    @Test
    fun `print winning statistics`() {
        System.setOut(PrintStream(outputStream))

        val winningStatuses = listOf(
            "3 Matches (5,000 KRW) – 1 tickets",
            "4 Matches (50,000 KRW) – 0 tickets",
            "5 Matches (1,500,000 KRW) – 0 tickets",
            "5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets",
            "6 Matches (2,000,000,000 KRW) – 0 tickets"
        )

        outputView.printPrizeSummary(winningStatuses)

        val expectedOutput = winningStatuses.joinToString("\n")
        assertEquals(expectedOutput, outputStream.toString().trim())
        System.setOut(System.out)
    }

    @Test
    fun `print return rate`() {
        System.setOut(PrintStream(outputStream))

        val returnRate = "62.5"
        outputView.printReturnRate(returnRate)

        val expectedOutput = "Total return rate is 62.5%."
        assertEquals(expectedOutput, outputStream.toString().trim())
        System.setOut(System.out)
    }
}
