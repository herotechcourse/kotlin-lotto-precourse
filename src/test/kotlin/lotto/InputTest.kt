package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.ApplicationTest.Companion
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputTest : NsTest() {


    @Test
    fun `Purchase value greater than 0`() {
        assertSimpleTest {
            runException("0")
            assertThat(output()).contains(ApplicationTest.ERROR_MESSAGE)
        }
    }

    @Test
    fun `Purchase value divisible by 1000`() {
        assertSimpleTest {
            runException("1234")
            assertThat(output()).contains(ApplicationTest.ERROR_MESSAGE)
        }
    }

    @Test
    fun `Purchase value should not be null`() {
        assertSimpleTest {
            runException(" ")
            assertThat(output()).contains(ApplicationTest.ERROR_MESSAGE)
        }
    }



    @Test
    fun `Winning number must not be null`() {
        assertSimpleTest {
            runException("1000"," ")
            assertThat(output()).contains(ApplicationTest.ERROR_MESSAGE)
        }
    }

    @Test
    fun `Winning number must be between 1 and 45`() {
        assertSimpleTest {
            runException("1000","1,2,3,4,5,50")
            assertThat(output()).contains(ApplicationTest.ERROR_MESSAGE)
        }
    }

    @Test
    fun `Winning number must not contain duplicate`() {
        assertSimpleTest {
            runException("1000","1,1,3,4,5,5")
            assertThat(output()).contains(ApplicationTest.ERROR_MESSAGE)
        }
    }

    @Test
    fun `Bonus should be between 1 and 45`() {
        assertSimpleTest {
            runException("1000","1,2,3,4,5,6","60")
            assertThat(output()).contains(ApplicationTest.ERROR_MESSAGE)
        }
    }

    @Test
    fun `Bonus should not be null`() {
        assertSimpleTest {
            runException("1000","1,2,3,4,5,6"," ")
            assertThat(output()).contains(ApplicationTest.ERROR_MESSAGE)
        }
    }


    override fun runMain() {
        main()
    }


}