import lotto.Lotto
import lotto.display.TicketDisplay
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.assertj.core.api.Assertions.assertThat

class TicketDisplayTest {

    @Test
    fun `prints the correct ticket display output`() {
        val tickets = listOf(
            Lotto(listOf(8, 21, 23, 41, 42, 43)),
            Lotto(listOf(3, 5, 11, 16, 32, 38)),
            Lotto(listOf(7, 11, 16, 35, 36, 44)),
            Lotto(listOf(1, 8, 11, 31, 41, 42)),
            Lotto(listOf(13, 14, 16, 38, 42, 45)),
            Lotto(listOf(7, 11, 30, 40, 42, 43)),
            Lotto(listOf(2, 13, 22, 32, 38, 45)),
            Lotto(listOf(1, 3, 5, 14, 22, 45))
        )
        val numberOfTickets = tickets.size

        val output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))

        TicketDisplay().displayTickets(numberOfTickets, tickets)

        // Assert using assertThat to check if output contains all the expected parts
        assertThat(output.toString()).contains(
            "You have purchased 8 tickets.",
            "[8, 21, 23, 41, 42, 43]",
            "[3, 5, 11, 16, 32, 38]",
            "[7, 11, 16, 35, 36, 44]",
            "[1, 8, 11, 31, 41, 42]",
            "[13, 14, 16, 38, 42, 45]",
            "[7, 11, 30, 40, 42, 43]",
            "[2, 13, 22, 32, 38, 45]",
            "[1, 3, 5, 14, 22, 45]"
        )
    }
}