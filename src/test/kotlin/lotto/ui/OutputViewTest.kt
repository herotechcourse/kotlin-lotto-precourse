package lotto.ui

import lotto.Lotto
import lotto.ui.OutputView
import lotto.domain.PrizeRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {
    private val outputStream = ByteArrayOutputStream()
    private val originalOut = System.out

    @Test
    fun `print tickets correctly`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12))
        )

        System.setOut(PrintStream(outputStream))
        OutputView.printTickets(tickets)
        System.setOut(originalOut)

        val output = outputStream.toString().trim()
        assertThat(output).contains(
            "You have purchased 2 tickets.",
            "[1, 2, 3, 4, 5, 6]",
            "[7, 8, 9, 10, 11, 12]"
        )
    }

    @Test
    fun `print results with all prize ranks`() {
        val results = mapOf(
            PrizeRank.FIRST to 1,
            PrizeRank.SECOND to 0,
            PrizeRank.THIRD to 1,
            PrizeRank.FOURTH to 2,
            PrizeRank.FIFTH to 3,
            PrizeRank.NONE to 0
        )

        System.setOut(PrintStream(outputStream))
        OutputView.printResults(results)
        System.setOut(originalOut)

        val output = outputStream.toString().trim()
        assertThat(output).contains(
            "Winning Statistics",
            "---",
            "6 Matches (2,000,000,000 KRW) – 1 tickets",
            "5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets",
            "5 Matches (1,500,000 KRW) – 1 tickets",
            "4 Matches (50,000 KRW) – 2 tickets",
            "3 Matches (5,000 KRW) – 3 tickets"
        )
    }

    @Test
    fun `print results with no winning tickets`() {
        val results = PrizeRank.entries.associateWith { 0 }

        System.setOut(PrintStream(outputStream))
        OutputView.printResults(results)
        System.setOut(originalOut)

        val output = outputStream.toString().trim()
        assertThat(output).contains(
            "Winning Statistics",
            "---",
            "6 Matches (2,000,000,000 KRW) – 0 tickets",
            "5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets",
            "5 Matches (1,500,000 KRW) – 0 tickets",
            "4 Matches (50,000 KRW) – 0 tickets",
            "3 Matches (5,000 KRW) – 0 tickets"
        )
    }

    @Test
    fun `print profit rate with one decimal place`() {
        System.setOut(PrintStream(outputStream))
        OutputView.printProfitRate(62.5)
        System.setOut(originalOut)

        assertThat(outputStream.toString().trim())
            .isEqualTo("Total return rate is 62.5%.")
    }

    @Test
    fun `print profit rate with zero decimal place`() {
        System.setOut(PrintStream(outputStream))
        OutputView.printProfitRate(100.0)
        System.setOut(originalOut)

        assertThat(outputStream.toString().trim())
            .isEqualTo("Total return rate is 100.0%.")
    }
} 