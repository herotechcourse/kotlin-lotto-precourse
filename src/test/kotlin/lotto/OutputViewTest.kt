package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {
    private val outputView = OutputView()
    private val standardOut = System.out
    private val outputStream = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStream))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
        outputStream.reset()
    }

    @Test
    fun `printPurchasedTickets should display correct ticket count`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12))
        )
        outputView.printPurchasedTickets(tickets)
        val output = outputStream.toString()
        assertTrue(output.contains("You have purchased 2 tickets"))
    }

    @Test
    fun `printPurchasedTickets should display sorted ticket numbers`() {
        val tickets = listOf(
            Lotto(listOf(6, 5, 4, 3, 2, 1)),
            Lotto(listOf(12, 11, 10, 9, 8, 7))
        )
        outputView.printPurchasedTickets(tickets)
        val output = outputStream.toString()
        assertTrue(output.contains("[1, 2, 3, 4, 5, 6]"))
        assertTrue(output.contains("[7, 8, 9, 10, 11, 12]"))
    }

    @Test
    fun `printWinningStatistics should display header and separator`() {
        val rankCounts = mapOf<Rank, Int>()
        outputView.printWinningStatistics(rankCounts, 1000)
        val output = outputStream.toString()
        assertTrue(output.contains("Winning Statistics"))
        assertTrue(output.contains("---"))
    }

    @Test
    fun `printWinningStatistics should display all ranks in correct order`() {
        val rankCounts = mapOf(
            Rank.FIRST to 1,
            Rank.SECOND to 2,
            Rank.THIRD to 3,
            Rank.FOURTH to 4,
            Rank.FIFTH to 5
        )
        outputView.printWinningStatistics(rankCounts, 20000)
        val output = outputStream.toString()
        val fifthRankIndex = output.indexOf("3 Matches")
        val fourthRankIndex = output.indexOf("4 Matches")
        val thirdRankIndex = output.indexOf("5 Matches (1,500,000")
        val secondRankIndex = output.indexOf("5 Matches + Bonus Ball")
        val firstRankIndex = output.indexOf("6 Matches")
        assertTrue(fifthRankIndex < fourthRankIndex)
        assertTrue(fourthRankIndex < thirdRankIndex)
        assertTrue(thirdRankIndex < secondRankIndex)
        assertTrue(secondRankIndex < firstRankIndex)
    }

    @Test
    fun `printWinningStatistics should display correct count for each rank`() {
        val rankCounts = mapOf(
            Rank.FIRST to 1,
            Rank.SECOND to 0,
            Rank.THIRD to 2,
            Rank.FOURTH to 3,
            Rank.FIFTH to 5
        )
        outputView.printWinningStatistics(rankCounts, 20000)
        val output = outputStream.toString()
        assertTrue(output.contains("6 Matches") && output.contains("– 1 tickets"))
        assertTrue(output.contains("5 Matches + Bonus Ball") && output.contains("– 0 tickets"))
        assertTrue(output.contains("5 Matches (1,500,000") && output.contains("– 2 tickets"))
        assertTrue(output.contains("4 Matches") && output.contains("– 3 tickets"))
        assertTrue(output.contains("3 Matches") && output.contains("– 5 tickets"))
    }

    @Test
    fun `printWinningStatistics should calculate and display correct return rate`() {
        val rankCounts = mapOf(
            Rank.FIFTH to 1
        )
        val purchaseAmount = 8000
        outputView.printWinningStatistics(rankCounts, purchaseAmount)
        val output = outputStream.toString()
        assertTrue(output.contains("Total return rate is 62.5%"))
    }
} 