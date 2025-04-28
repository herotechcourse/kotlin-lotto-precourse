package lotto.views

import lotto.Lotto
import lotto.Rank
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {
    private val output = ByteArrayOutputStream().also {
        System.setOut(PrintStream(it))
    }
    private val view = OutputView()

    @Test
    @DisplayName("OutputView prints the number of tickets and their details correctly")
    fun printsTicketsAndStatistics() {
        val tickets = listOf(Lotto(listOf(1,2,3,4,5,6)))
        view.printTickets(tickets)
        view.printResultStatistics(mapOf(Rank.FIRST to 1), profitRate = 200000000000.0)

        val out = output.toString().lines()
        assertThat(out).anyMatch { it.contains("You have purchased 1 tickets.") }
        assertThat(out).anyMatch { it.contains("[1, 2, 3, 4, 5, 6]") }
        assertThat(out).anyMatch { it.contains("6 Matches (2,000,000,000 KRW) – 1 tickets") }
        assertThat(out).anyMatch { it.contains("Total return rate is 200000000000.0%.") }
    }
}
