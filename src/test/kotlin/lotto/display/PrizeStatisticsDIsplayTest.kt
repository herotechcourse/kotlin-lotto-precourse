package lotto.display

import lotto.prize.PrizeRanking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class PrizeStatisticsDisplayTest {

    @Test
    fun `displays prize statistics correctly`() {
        val prizeResults = listOf(
            "Ticket [1, 2, 3, 4, 5, 6] - Prize: 6 Matches (2,000,000,000 KRW)",
            "Ticket [7, 8, 9, 10, 11, 12] - Prize: 5 Matches (1,500,000 KRW)"
        )

        val prizeRanking = PrizeRanking()

        val output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))

        PrizeStatisticsDisplay().displayPrizeStatistics(prizeResults, prizeRanking)

        val expectedOutput = """
            3 Matches (5,000 KRW) – 0 tickets
            4 Matches (50,000 KRW) – 0 tickets
            5 Matches (1,500,000 KRW) – 1 tickets
            5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
            6 Matches (2,000,000,000 KRW) – 1 tickets
        """.trimIndent()

        //Check Expected output is present in the output string
        Assertions.assertTrue(output.toString().contains(expectedOutput))
    }
}