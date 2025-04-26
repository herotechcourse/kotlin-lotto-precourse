package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest : NsTest() {

    @Test
    fun `invalid purchase amount - negative value`() {
        assertSimpleTest {
            runException("-1000")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `invalid purchase amount - not divisible by 1000`() {
        assertSimpleTest {
            runException("1500")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `invalid winning numbers - duplicate numbers`() {
        assertSimpleTest {
            runException("8000", "1,1,2,3,4,5")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `invalid winning numbers - out of range`() {
        assertSimpleTest {
            runException("8000", "0,2,3,4,5,46")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `invalid bonus number - in winning numbers`() {
        assertSimpleTest {
            runException("8000", "1,2,3,4,5,6", "6")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `invalid bonus number - out of range`() {
        assertSimpleTest {
            runException("8000", "1,2,3,4,5,6", "46")
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