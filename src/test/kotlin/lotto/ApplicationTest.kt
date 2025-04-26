package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest : NsTest() {

    @Test
    fun `feature test - no matches`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("2000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "You have purchased 2 tickets.",
                    "[10, 11, 12, 13, 14, 15]",
                    "[16, 17, 18, 19, 20, 21]",
                    "3 Matches (5,000 KRW) – 0 tickets",
                    "4 Matches (50,000 KRW) – 0 tickets",
                    "5 Matches (1,500,000 KRW) – 0 tickets",
                    "5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets",
                    "6 Matches (2,000,000,000 KRW) – 0 tickets",
                    "Total return rate is 0.0%."
                )
            },
            listOf(10, 11, 12, 13, 14, 15),
            listOf(16, 17, 18, 19, 20, 21)
        )
    }

    @Test
    fun `feature test - 3 matches`() {
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
    fun `feature test - jackpot 4 matches`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "You have purchased 1 tickets.",
                    "[1, 2, 3, 4, 8, 9]",
                    "4 Matches (50,000 KRW) – 1 tickets",
                    "Total return rate is"
                )
            },
            listOf(1, 2, 3, 4, 8, 9)
        )
    }

    @Test
    fun `feature test - 5 matches`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "You have purchased 1 tickets.",
                    "[1, 2, 3, 4, 5, 45]", // only 45 is wrong
                    "5 Matches (1,500,000 KRW) – 1 tickets",
                    "5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets",
                    "6 Matches (2,000,000,000 KRW) – 0 tickets",
                    "Total return rate is"
                )
            },
            listOf(1, 2, 3, 4, 5, 45)
        )
    }

    @Test
    fun `feature test - 5 matches plus bonus`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "45")
                assertThat(output()).contains(
                    "You have purchased 1 tickets.",
                    "[1, 2, 3, 4, 5, 45]", // 45 is the bonus number!
                    "5 Matches (1,500,000 KRW) – 0 tickets",
                    "5 Matches + Bonus Ball (30,000,000 KRW) – 1 tickets",
                    "6 Matches (2,000,000,000 KRW) – 0 tickets",
                    "Total return rate is"
                )
            },
            listOf(1, 2, 3, 4, 5, 45)
        )
    }

    @Test
    fun `feature test - jackpot 6 matches`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                run("1000", "1,2,3,4,5,6", "7")
                assertThat(output()).contains(
                    "You have purchased 1 tickets.",
                    "[1, 2, 3, 4, 5, 6]",
                    "6 Matches (2,000,000,000 KRW) – 1 tickets",
                    "Total return rate is"
                )
            },
            listOf(1, 2, 3, 4, 5, 6)
        )
    }


    // ---exception test---
    @Test
    fun `exception test`() {
        assertSimpleTest {
            runException("1000j")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `exception test1`() {
        assertSimpleTest {
            runException("0")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `exception test2`() {
        assertSimpleTest {
            runException("a")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `exception test3`() {
        assertSimpleTest {
            runException("-1")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `exception test4`() {
        assertSimpleTest {
            runException("  ")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    // ---inputView  test---
    @Test
    fun `inputView test`() {
        assertSimpleTest {
            run(
                "3000",           // Purchase amount (means 3 tickets)
                "1,2,3,4,5,6",    // Winning numbers
                "7"               // Bonus number
            )

            assertThat(output()).contains(
                "Please enter the purchase amount.",
                "Please enter last week's winning numbers.",
                "Please enter the bonus number.",
                "You have purchased 3 tickets."
            )
        }
    }

    // ---winning number input test
    @Test
    fun `exception on invalid winning numbers - duplicate number`() {
        assertSimpleTest {
            runException("3000", "1,2,2,4,5,6") // Duplicate 2
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `exception on invalid winning numbers - wrong size`() {
        assertSimpleTest {
            runException("3000", "1,2,3,4,5") // Only 5 numbers
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `exception on invalid winning numbers - number out of range`() {
        assertSimpleTest {
            runException("3000", "1,2,3,4,5,46")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `exception on invalid winning numbers - more than 6 numbers`() {
        assertSimpleTest {
            runException("3000", "1,2,3,4,5,6,7 ")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `exception on invalid winning numbers - number is not integer`() {
        assertSimpleTest {
            runException("3000", "1,2,3,4,5,q")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `exception on invalid winning numbers - number is negative`() {
        assertSimpleTest {
            runException("3000", "1,2,3,4,5,-1")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `exception on invalid winning numbers - number is 0`() {
        assertSimpleTest {
            runException("3000", "1,2,3,4,5,0")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `exception on invalid winning numbers - there is only space`() {
        assertSimpleTest {
            runException("3000", "    ")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    // ---bonus number test---

    @Test
    fun `exception on bonus number duplicated with winning numbers`() {
        assertSimpleTest {
            runException("3000", "1,2,3,4,5,6", "6") // Bonus number is 6 (duplicate)
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `exception on bonus number out of range`() {
        assertSimpleTest {
            runException("3000", "1,2,3,4,5,6", "46") // 46 out of valid range
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `exception on bonus number not integer`() {
        assertSimpleTest {
            runException("3000", "1,2,3,4,5,6", "a") // 46 out of valid range
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `exception on bonus number 0`() {
        assertSimpleTest {
            runException("3000", "1,2,3,4,5,6", "0") // 46 out of valid range
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `exception on bonus number negative`() {
        assertSimpleTest {
            runException("3000", "1,2,3,4,5,6", "-1") // 46 out of valid range
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `exception on bonus number empty`() {
        assertSimpleTest {
            runException("3000", "1,2,3,4,5,6", " ") // 46 out of valid range
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }
}
