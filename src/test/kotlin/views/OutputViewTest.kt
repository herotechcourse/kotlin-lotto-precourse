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

    @Test
    fun `printMatches should print match results`() {
        
        val matchMap = mutableMapOf(
            MatchCondition.MATCH_3 to CountAndPrize(2, 5000),
            MatchCondition.MATCH_4 to CountAndPrize(1, 50000)
        )
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
        val outputView = OutputView()

       
        outputView.printMatches(matchMap)

        val output = outputStream.toString()
        assertTrue(output.contains("Winning Statistics"))
        assertTrue(output.contains("3 Matches (5,000 KRW) – 2 tickets"))
        assertTrue(output.contains("4 Matches (50,000 KRW) – 1 tickets"))
    }
    
    @Test
    fun `printReturnRate should print the return rate`() {
        
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
        val outputView = OutputView()

        
        outputView.printReturnRate(62.5)

        
        val output = outputStream.toString()
        assertTrue(output.contains("Total return rate is 62.5%."))
    }
    
}
