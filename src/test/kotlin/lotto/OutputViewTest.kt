package lotto

import lotto.Lotto
import lotto.domain.LottoResult
import lotto.domain.Prize
import lotto.view.OutputView
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {
    @Test
    fun `prints purchased tickets`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12))
        )

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        OutputView.printTickets(tickets)

        val output = outputStream.toString().trim()
        assertTrue(output.contains("You have purchased 2 tickets."))
        assertTrue(output.contains("[1, 2, 3, 4, 5, 6]"))
        assertTrue(output.contains("[7, 8, 9, 10, 11, 12]"))

        System.setOut(System.out) // Reset standard output
    }

    @Test
    fun `prints winning statistics`() {
        val prizeCounts = mapOf(
            Prize.FIRST to 1,
            Prize.SECOND to 2,
            Prize.THIRD to 0,
            Prize.FOURTH to 3,
            Prize.FIFTH to 5
        )
        val result = LottoResult(prizeCounts)
        val amount = 10000

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        OutputView.printStatistics(result, amount)

        val output = outputStream.toString().trim()
        assertTrue(output.contains("Winning Statistics"))
        assertTrue(output.contains("6 Matches (2,000,000,000 KRW) - 1 tickets"))
        assertTrue(output.contains("5 Matches + Bonus Ball (30,000,000 KRW) - 2 tickets"))
        assertTrue(output.contains("5 Matches (1,500,000 KRW) - 0 tickets"))
        assertTrue(output.contains("4 Matches (50,000 KRW) - 3 tickets"))
        assertTrue(output.contains("3 Matches (5,000 KRW) - 5 tickets"))
        assertTrue(output.contains("Total return rate is"))

        System.setOut(System.out) // Reset standard output
    }
}