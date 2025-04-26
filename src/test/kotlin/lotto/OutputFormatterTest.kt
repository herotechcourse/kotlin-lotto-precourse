package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputFormatterTest {

    @Test
    fun `printTicketNumbers should print sorted numbers of each ticket`() {
        val tickets = listOf(
            Lotto(listOf(8, 21, 23, 41, 42, 43)),
            Lotto(listOf(3, 5, 11, 16, 32, 38)),
            Lotto(listOf(7, 11, 16, 35, 36, 44))
        )

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        OutputFormatter.printTicketNumbers(tickets)

        val output = outputStream.toString().trim()
        val expectedOutput = """
            [8, 21, 23, 41, 42, 43]
            [3, 5, 11, 16, 32, 38]
            [7, 11, 16, 35, 36, 44]
        """.trimIndent()
        assertThat(output).isEqualTo(expectedOutput)
    }

    @Test
    fun `printLottoStatistics should print correct statistics and return rate`() {
        val matches = mapOf(
            Rank.FIFTH to 1,
            Rank.FOURTH to 2,
            Rank.THIRD to 0,
            Rank.SECOND to 0,
            Rank.FIRST to 0
        )
        val totalWinnings = 105_000L
        val purchaseAmount = 14000

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        OutputFormatter.printLottoStatistics(matches, totalWinnings, purchaseAmount)

        val output = outputStream.toString().trim()
        val expectedOutput = """
            Winning Statistics
            3 Matches (5,000 KRW) – 1 tickets
            4 Matches (50,000 KRW) – 2 tickets
            5 Matches (1,500,000 KRW) – 0 tickets
            5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
            6 Matches (2,000,000,000 KRW) – 0 tickets
            Total return rate is 750.0%.
        """.trimIndent()
        assertThat(output).isEqualTo(expectedOutput)
    }
}
