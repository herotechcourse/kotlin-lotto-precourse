package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class OutputValidatorTest : NsTest() {
    @Test
    fun `assert that output isn't empty`() {
        val validator = OutputValidator()
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validator.validatePrintPurchase("") }
        }
    }

    @Test
    fun `assert that output is a number`() {
        val validator = OutputValidator()
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validator.validatePrintPurchase("") }
        }
    }

    override fun runMain() {
        main()
    }
}
