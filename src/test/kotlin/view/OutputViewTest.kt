package view

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.LottoGame
import lotto.LottoGenerator
import lotto.main
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OutputViewTest : NsTest() {
    @Test
    fun `test output issued tickets (exact match)`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                val tickets = LottoGenerator.issue(4_000)
                OutputView.printIssuedTickets(tickets)
                assertEquals(cleanOutput(), """
                    You have purchased 4 tickets.
                    [1, 2, 3, 4, 5, 6]
                    [11, 12, 13, 14, 15, 16]
                    [21, 22, 23, 24, 25, 26]
                    [31, 32, 33, 34, 35, 36]
                """.trimIndent()
                )
            },
            listOf(1, 2, 3, 4, 5, 6),
            listOf(11, 12, 13, 14, 15, 16),
            listOf(21, 22, 23, 24, 25, 26),
            listOf(31, 32, 33, 34, 35, 36)
        )
    }

    @Test
    fun `test output result statistic (exact match)`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                val purchaseAmount = 10_000
                val tickets = LottoGenerator.issue(purchaseAmount)
                val result = LottoGame(listOf(1, 2, 3, 4, 5, 6), 7, tickets).countWinningTickets()
                OutputView.printStatistic(result, purchaseAmount)
                assertEquals(cleanOutput(), """
                    Winning Statistics
                    –––
                    3 Matches (5,000 KRW) – 1 tickets
                    4 Matches (50,000 KRW) – 1 tickets
                    5 Matches (1,500,000 KRW) – 0 tickets
                    5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
                    6 Matches (2,000,000,000 KRW) – 0 tickets
                    Total return rate is 550.0%.
                """.trimIndent()
                )
            },
            listOf(1, 2, 3, 4, 8, 9),
            listOf(1, 2, 3, 14, 15, 16),
            listOf(21, 22, 23, 24, 25, 26),
            listOf(27, 32, 23, 44, 5, 36),
            listOf(1, 14, 9, 29, 35, 26),
            listOf(40, 39, 13, 24, 45, 7),
            listOf(8, 42, 13, 4, 21, 41),
            listOf(38, 26, 3, 14, 25, 16),
            listOf(40, 2, 43, 14, 25, 36),
            listOf(31, 32, 33, 34, 35, 36),
        )
    }

    private fun cleanOutput(): String {
        return output()
            .lines()
            .filterNot { it.contains("Mockito") }
            .joinToString("\n")
    }

    override fun runMain() {
        main()
    }
}