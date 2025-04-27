package view

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.LottoGenerator
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

    private fun cleanOutput(): String {
        return output()
            .lines()
            .filterNot { it.contains("Mockito") }
            .joinToString("\n")
    }

    override fun runMain() {
        TODO("Not yet implemented")
    }
}