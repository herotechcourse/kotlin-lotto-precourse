package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test

class ApplicationTest : NsTest() {
    @Test
    fun `TEST main feature test`() {
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
                    "3 Matches (5,000 KRW) - 1 tickets",
                    "4 Matches (50,000 KRW) - 0 tickets",
                    "5 Matches (1,500,000 KRW) - 0 tickets",
                    "5 Matches + Bonus (30,000,000 KRW) - 0 tickets",
                    "6 Matches (2,000,000,000 KRW) - 0 tickets",
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
    fun `EXCEPTION amount not divisible by 1000`() {
         assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("1234") }
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `EXCEPTION non-numeric input`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("1000j") }
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }
  
    @Test
    fun `EXCEPTION zero purchased`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("0") }
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `EXCEPTION extra unexpected input after winning numbers`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> {
                runException("2000", "1,2,3,4,5,6,7", "8")
            }
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `EXCEPTION blank input for purchase amount`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> {
                runException("\n")
            }
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `EXCEPTION nonNumeric Winning Numbers`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> {
                runException("1000","1,2,3,4,5,six", "6")
            }
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `EXCEPTION outOfRange Winning Numbers`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> {
                runException("1000","1,2,3,4,5,46", "6")
            }
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `EXCEPTION duplicate Winning Numbers`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> {
                runException("1000","1,2,3,4,5,5", "6")
            }
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `EXCEPTION empty Bonus Number`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> {
                runException("1000", "1,2,3,4,5,6", "\n")
            }
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `EXCEPTION invalid Bonus Number`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> {
                runException("1000", "1,2,3,4,5,6", "46")
            }
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }
}
