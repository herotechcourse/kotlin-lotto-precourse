package lotto.view

import lotto.domain.Rank
import lotto.service.Statistics
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {

    private val originalOut = System.out
    private val buffer = ByteArrayOutputStream()

    @AfterEach
    fun restoreOutput() {
        System.setOut(originalOut)
    }

    @Test
    fun `printTickets outputs correct header and each ticket`() {
        System.setOut(PrintStream(buffer))
        val tickets = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(7, 8, 9, 10, 11, 12)
        )
        OutputView.printTickets(tickets)

        val lines = buffer.toString().lines()
        assertThat(lines[0]).isEqualTo("2 tickets purchased.")
        assertThat(lines[1]).isEqualTo("[1, 2, 3, 4, 5, 6]")
        assertThat(lines[2]).isEqualTo("[7, 8, 9, 10, 11, 12]")
    }

    @Test
    fun `printStatistics outputs correct ranks and return rate`() {
        System.setOut(PrintStream(buffer))
        val counts = mapOf(
            Rank.FIFTH to 1,
            Rank.FOURTH to 2
        )
        val stats = Statistics(counts)
        OutputView.printStatistics(stats, purchaseAmount = 3000)

        val lines = buffer.toString().lines()
        assertThat(lines).contains(
            "Lotto Results",
            "3 matches (5000 KRW) – 1 tickets",
            "4 matches (50 KRW) – 2 tickets"
        )
        assertThat(lines.last()).matches("Total return rate: \\d+\\.\\d%")
    }
}
