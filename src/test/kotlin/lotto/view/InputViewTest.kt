package lotto.view

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest : NsTest() {

    @Test
    fun `valid purchase amount is parsed correctly`() {
        assertSimpleTest {
            run("3000")
            val amount = InputView.purchaseAmount()
            assertThat(amount).isEqualTo(3000)
        }
    }

    @Test
    fun `invalid purchase amount throws exception`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> {
                runException("abcd")
                InputView.purchaseAmount()
            }
            assertThat(exception.message).contains("[ERROR] invalid input")
        }
    }

    @Test
    fun `valid winning numbers are parsed correctly`() {
        assertSimpleTest {
            run("1,2,3,4,5,6")
            val winningNumbers = InputView.inputWinningsNumbers()
            assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6)
        }
    }

    @Test
    fun `invalid winning numbers throw exception when not unique`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> {
                runException("1,2,3,4,5,5")
                InputView.inputWinningsNumbers()
            }
            assertThat(exception.message).contains("[ERROR] Lotto numbers must be unique.")
        }
    }

    @Test
    fun `bonus number is parsed correctly`() {
        assertSimpleTest {
            run("7")
            val bonus = InputView.inputBonusNumber(listOf(1, 2, 3, 4, 5, 6))
            assertThat(bonus).isEqualTo(7)
        }
    }

    @Test
    fun `bonus number same as winning number throws exception`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> {
                runException("5")
                InputView.inputBonusNumber(listOf(1, 2, 3, 4, 5, 6))
            }
            assertThat(exception.message).contains("[ERROR] Bonus number must not be among the winning numbers.")
        }
    }

    @Test
    fun `bonus number out of range throws exception`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> {
                runException("50")
                InputView.inputBonusNumber(listOf(1, 2, 3, 4, 5, 6))
            }
            assertThat(exception.message).contains("[ERROR] Bonus number must be between 1 and 45.")
        }
    }

    override fun runMain() {}
}

