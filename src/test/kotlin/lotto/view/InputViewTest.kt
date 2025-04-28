package lotto.view

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest : NsTest() {

    @Test
    fun `reads valid purchase amount`() {
        assertSimpleTest {
            runException("8000")
            assertThat(InputView().readPurchaseAmount()).isEqualTo(8000)
        }
    }

    @Test
    fun `throws exception for invalid purchase amount`() {
        assertSimpleTest {
            runException("abc")
            assertThrows<IllegalArgumentException> {
                InputView().readPurchaseAmount()
            }
        }
    }

    @Test
    fun `reads valid winning numbers`() {
        assertSimpleTest {
            runException("1,2,3,4,5,6")
            val numbers = InputView().readWinningNumbers()
            assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6)
        }
    }

    @Test
    fun `throws exception for invalid winning numbers`() {
        // Non-numeric input
        assertSimpleTest {
            runException("1,2,3,4,5,a")
            assertThrows<IllegalArgumentException> {
                InputView().readWinningNumbers()
            }
        }

        // Wrong number of elements
        assertSimpleTest {
            runException("1,2,3,4,5")
            assertThrows<IllegalArgumentException> {
                InputView().readWinningNumbers()
            }
        }
    }

    @Test
    fun `reads valid bonus number`() {
        assertSimpleTest {
            runException("7")
            assertThat(InputView().readBonusNumber()).isEqualTo(7)
        }
    }

    @Test
    fun `throws exception for invalid bonus number`() {
        assertSimpleTest {
            runException("abc")
            assertThrows<IllegalArgumentException> {
                InputView().readBonusNumber()
            }
        }
    }

    override fun runMain() {
        // Not used in this test
    }
}