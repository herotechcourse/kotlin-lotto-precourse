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
    fun `input Purchase Amount throws error for amount lower than ticket cost`() {
        assertSimpleTest {
            runException("10")
            assertThat(output()).contains("Not enough amount to purchase at least 1 ticket (min 1000 KRW).")
        }
    }

    @Test
    fun `input Purchase Amount throws error for invalid input (non-numeric)`() {
        assertSimpleTest {
            runException("abc")
            assertThat(output()).contains("[ERROR] Please enter digits only.")
        }
    }

    @Test
    fun `input Winning number throws error for fewer than 6 numbers`() {
        assertSimpleTest {
            runException("8000", "1,2,3,4")
            assertThat(output()).contains("[ERROR] Lotto must contain exactly 6 numbers.")
        }
    }

    @Test
    fun `input Winning number throws error for more than 6 numbers`() {
        assertSimpleTest {
            runException("8000", "1,2,3,4,5,6,7")
            assertThat(output()).contains("[ERROR] Lotto must contain exactly 6 numbers.")
        }
    }

    @Test
    fun `input Winning number throws error for non-numeric input`() {
        assertSimpleTest {
            runException("8000", "1,2,3,4,5, a")
            assertThat(output()).contains("[ERROR] Lotto numbers must be between 1 and 45.")
        }
    }

    @Test
    fun `input Winning number throws error for out-of-range numbers`() {
        assertSimpleTest {
            runException("8000", "1,2,3,4,5,100")
            assertThat(output()).contains("[ERROR] Lotto numbers must be between 1 and 45.")
        }
    }

    @Test
    fun `input Bonus number throws error for bonus number less than 1`() {
        assertSimpleTest {
            runException("8000", "1,2,3,4,5,6", "-1")
            assertThat(output()).contains("[ERROR] Lotto numbers must be between 1 and 45.")
        }
    }

    @Test
    fun `input Bonus number throws error for bonus number more than 45`() {
        assertSimpleTest {
            runException("8000", "1,2,3,4,5,6", "50")
            assertThat(output()).contains("[ERROR] Lotto numbers must be between 1 and 45.")
        }
    }

    @Test
    fun `input Bonus number throws error for non-numeric bonus number`() {
        assertSimpleTest {
            runException("8000", "1,2,3,4,5,6", "abc")
            assertThat(output()).contains("[ERROR] Lotto numbers must be between 1 and 45.")
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }
}
