package views

import lotto.MatchCondition
import lotto.CountAndPrize
import lotto.Lotto
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {

    @Test
    fun `printTickets should print all tickets`() {
       
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12))
        )
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        val outputView = OutputView()
         outputView.printTickets(tickets)

        val output = outputStream.toString().trim()
        

        assertTrue(output.contains("You have purchased 2 tickets."))
        assertTrue(output.contains("1, 2, 3, 4, 5, 6"))
        assertTrue(output.contains("7, 8, 9, 10, 11, 12"))
    }

    
}
