package lotto.ui

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import lotto.main

class InputValidationTest : NsTest() {

    @Test
    fun `invalid purchase amount - not divisible by 1000`() {
        assertSimpleTest {
            runException("1500")
            assertThat(output()).contains("[ERROR] Purchase amount must be divisible by 1000.")
        }
    }

    @Test
    fun `invalid winning numbers - not digits`() {
        assertSimpleTest {
            runException("1000", "1,2,3,4,5,a", "7")
            assertThat(output()).contains("[ERROR] Winning numbers must be digits")
        }
    }

    @Test
    fun `invalid winning numbers - not exactly 6 numbers`() {
        assertSimpleTest {
            runException("1000", "1,2,3,4,5", "7")
            assertThat(output()).contains("[ERROR] Exactly 6 winning numbers must be entered.")
        }
    }

    @Test
    fun `invalid winning numbers - numbers outside range`() {
        assertSimpleTest {
            runException("1000", "1,2,3,4,5,46", "7")
            assertThat(output()).contains("[ERROR] Winning numbers must be between 1 and 45")
        }
    }

    @Test
    fun `invalid winning numbers - duplicate numbers`() {
        assertSimpleTest {
            runException("1000", "1,2,3,4,5,5", "7")
            assertThat(output()).contains("[ERROR] Winning numbers must be unique.")
        }
    }

    @Test
    fun `invalid bonus number - not a digit`() {
        assertSimpleTest {
            runException("1000", "1,2,3,4,5,6", "a")
            assertThat(output()).contains("[ERROR] Bonus number must be a digit.")
        }
    }

    @Test
    fun `invalid bonus number - outside range`() {
        assertSimpleTest {
            runException("1000", "1,2,3,4,5,6", "46")
            assertThat(output()).contains("[ERROR] Bonus number must be between 1 and 45.")
        }
    }

    @Test
    fun `invalid bonus number - in winning numbers`() {
        assertSimpleTest {
            runException("1000", "1,2,3,4,5,6", "6")
            assertThat(output()).contains("[ERROR] Bonus number must not be in winning numbers.")
        }
    }

    override fun runMain() {
        main()
    }
} 