package lotto.view

import lotto.domain.Rank
import lotto.service.Statistics
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.junit.jupiter.api.BeforeEach

class OutputViewTest {

    private val originalOut = System.out
    private val buffer = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(buffer))
    }

    @AfterEach
    fun restoreOutput() {
        System.setOut(originalOut)
    }

    @Test
    fun `printTickets outputs correct header and each ticket`() {
        val tickets = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(7, 8, 9, 10, 11, 12)
        )
        OutputView.printTickets(tickets)

        val output = buffer.toString().trim().lines()
        assertThat(output).containsExactly(
            "You have purchased 2 tickets.",
            "[1, 2, 3, 4, 5, 6]",
            "[7, 8, 9, 10, 11, 12]"
        )
    }

    @Test
    fun `printStatistics outputs correct ranks and return rate`() {
        val counts = mapOf(
            Rank.FIFTH to 1,
            Rank.FOURTH to 2
        )
        val stats = Statistics(counts)
        OutputView.printStatistics(stats, purchaseAmount = 3000)

        val output = buffer.toString().trim().lines()
        assertThat(output).contains(
            "Winning Statistics",
            "---",
            "3 Matches (5,000 KRW) – 1 tickets",
            "4 Matches (50,000 KRW) – 2 tickets"
        )
        assertThat(output.last()).matches("Total return rate is \\d+(\\.\\d+)?%\\.")
    }
}