package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest : NsTest() {

    @Test
    fun `exception test`() {
        assertSimpleTest {
            runException("1000j")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `test invalid purchase amount - less than minimum`() {
        assertSimpleTest {
            runException("900")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `test invalid winning numbers format`() {
        assertSimpleTest {
            runException("8000", "1,2,3,4,5")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `test winning numbers out of range`() {
        assertSimpleTest {
            runException("8000", "1,2,3,4,5,46")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `test bonus number out of range`() {
        assertSimpleTest {
            runException("8000", "1,2,3,4,5,6", "46")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `test bonus number already in winning numbers`() {
        assertSimpleTest {
            runException("8000", "1,2,3,4,5,6", "3")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `test number of tickets for purchase amount`() {
        assertSimpleTest {
            run("1000", "1,2,3,4,5,6", "7")
            assertThat(output()).contains("You have purchased 1 tickets.")
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }
}
