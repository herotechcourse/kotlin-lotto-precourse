package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest : NsTest() {
    @Test
    fun `feature test`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("8000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "You have purchased 8 tickets.",
                    "[8, 21, 23, 41, 42, 43]",
                    "[3, 5, 11, 16, 32, 38]",
                    "[7, 11, 16, 35, 36, 44]",
                    "[1, 8, 11, 31, 41, 42]",
                    "[13, 14, 16, 38, 42, 45]",
                    "[7, 11, 30, 40, 42, 43]",
                    "[2, 13, 22, 32, 38, 45]",
                    "[1, 3, 5, 14, 22, 45]",
                    "3 Matches (5,000 KRW) – 1 tickets",
                    "4 Matches (50,000 KRW) – 0 tickets",
                    "5 Matches (1,500,000 KRW) – 0 tickets",
                    "5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets",
                    "6 Matches (2,000,000,000 KRW) – 0 tickets",
                    "Total return rate is 62.5%.",
                )
            },
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45),
        )
    }

    @Test
    fun `exception test`() {
        assertSimpleTest {
            runException("1000j")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `should generate correct return rate when all tickets are losers`() {
        val expectedTickets =
                listOf(
                        listOf(1, 2, 3, 4, 5, 6),
                        listOf(7, 8, 9, 10, 11, 12),
                        listOf(13, 14, 15, 16, 17, 18)
                )

        assertRandomUniqueNumbersInRangeTest(
                {
                    run("3000", "1,1,1,1,1,1", "1")
                    assertThat(output())
                            .contains(
                                    "You have purchased 3 tickets.",
                                    "Total return rate is 0.0%.",
                            )
                },
                expectedTickets[0],
                expectedTickets[1],
                expectedTickets[2]
        )
    }

    @Test
    fun `should throw error when purchase amount is below 1000`() {
        assertSimpleTest {
            runException("500")
            assertThat(output()).contains("[ERROR] Invalid amount. Purchase must be at least 1000.")
        }
    }

    @Test
    fun `should generate correct number of tickets`() {
        val expectedTickets =
                listOf(
                        listOf(1, 2, 3, 4, 5, 6),
                        listOf(7, 8, 9, 10, 11, 12),
                        listOf(13, 14, 15, 16, 17, 18)
                )

        assertRandomUniqueNumbersInRangeTest(
                {
                    run("3000", "1,1,1,1,1,1", "1") // User purchases 3 tickets and input numbers
                    assertThat(output())
                            .contains("You have purchased 3 tickets.", "Total return rate is 0.0%.")
                },
                expectedTickets[0],
                expectedTickets[1],
                expectedTickets[2]
        )
    }

    @Test
    fun `should calculate return rate when some tickets win`() {
        val expectedTickets =
                listOf(
                        listOf(1, 2, 3, 4, 15, 16),
                        listOf(7, 8, 9, 10, 11, 12),
                        listOf(13, 14, 15, 16, 17, 18)
                )

        assertRandomUniqueNumbersInRangeTest(
                {
                    run(
                            "3000",
                            "1,2,3,4,5,6",
                            "1"
                    ) // User purchases 3 tickets and the first ticket wins
                    assertThat(output())
                            .contains(
                                    "You have purchased 3 tickets.",
                                    "Total return rate is 1666.7%" // Assuming that one of the tickets
                                    // wins completely
                                    )
                },
                expectedTickets[0],
                expectedTickets[1],
                expectedTickets[2]
        )
    }

    @Test
    fun `should calculate return rate when all tickets are losers`() {
        val expectedTickets =
                listOf(
                        listOf(10, 12, 31, 42, 53, 16),
                        listOf(7, 8, 9, 10, 11, 12),
                        listOf(13, 14, 15, 16, 17, 18)
                )

        assertRandomUniqueNumbersInRangeTest(
                {
                    run(
                            "3000", // User spends 3000 KRW
                            "1,2,3,4,5,6", // Winning numbers
                            "1" // Bonus number
                    )
                    assertThat(output())
                            .contains("You have purchased 3 tickets.", "Total return rate is 0.0%.")
                },
                expectedTickets[0],
                expectedTickets[1],
                expectedTickets[2]
        )
    }



    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }
}
