package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorTest : NsTest() {
    @Test
    fun `assert that input isn't empty`() {
        val validator = InputValidator()

        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validator.validateBudget("") }
        }
    }

    @Test
    fun `assert that input isn't less than 1`() {
        val validator = InputValidator()

        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validator.validateBudget("0") }
            assertThrows<IllegalArgumentException> { validator.validateBudget("-1") }
        }
    }

    @Test
    fun `assert that input is divisible by 1000`() {
        val validator = InputValidator()

        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validator.validateBudget("5") }
            assertThrows<IllegalArgumentException> { validator.validateBudget("3.3") }
        }
    }

    @Test
    fun `assert that winning numbers are not empty`() {
        val validator = InputValidator()
        assertThrows<IllegalArgumentException> { validator.validateWinningNumbers("") }
    }

    @Test
    fun `validateWinningNumbers throws exception when input has less than 6 numbers`() {
        val validator = InputValidator()
        assertThrows<IllegalArgumentException> { validator.validateWinningNumbers("1,2,3,4,5") }
    }

    @Test
    fun `validateWinningNumbers throws exception when input isn't between 1 and 45`() {
        val validator = InputValidator()
        assertThrows<IllegalArgumentException> { validator.validateWinningNumbers("1,2,3,4,47,5")}
    }

    @Test
    fun `validateWinningNumbers throws exception when input has duplicates`() {
        val validator = InputValidator()
        assertThrows<IllegalArgumentException> { validator.validateWinningNumbers("1,2,3,4,4,5")}
    }

    override fun runMain() {
        main()
    }
}
