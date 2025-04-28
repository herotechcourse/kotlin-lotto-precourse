package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MoneyInputTest : NsTest() {

    @Test
    fun `inputMoneyAmount prints error on non-numeric input and returns valid amount`() {
        assertSimpleTest {
            run("letters", "5000")
            assertThat(output()).contains("[ERROR] Input must be fully numeric.")
            assertThat(lastResult).isEqualTo(5000)
        }
    }

    @Test
    fun `inputMoneyAmount prints error on amount not divisible by 1000 and returns valid amount`() {
        assertSimpleTest {
            run("2500", "3000")
            assertThat(output()).contains("[ERROR] Amount must be divisible by 1000.")
            assertThat(lastResult).isEqualTo(3000)
        }
    }

    @Test
    fun `inputMoneyAmount prints error on zero input and returns valid amount`() {
        assertSimpleTest {
            run("0", "1000")
            assertThat(output()).contains("[ERROR] Amount must be a positive number.")
            assertThat(lastResult).isEqualTo(1000)
        }
    }

    @Test
    fun `inputMoneyAmount prints error on negative input and returns valid amount`() {
        assertSimpleTest {
            run("-1000", "4000")
            assertThat(output()).contains("[ERROR] Amount must be a positive number.")
            assertThat(lastResult).isEqualTo(4000)
        }
    }

    private var lastResult: Int = 0

    override fun runMain() {
        val moneyInput = MoneyInput()
        lastResult = moneyInput.inputMoneyAmount()
    }
}
