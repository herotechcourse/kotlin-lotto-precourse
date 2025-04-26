package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
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
    fun `assert that output isn't a non-numeric number`() {
        val validator = OutputValidator()
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validator.validatePrintPurchase("abc") }
        }
    }

    @Test
    fun `assert that output is a number`() {
        val validator = OutputValidator()
        assertDoesNotThrow { validator.validatePrintPurchase("1000") }
    }

    @Test
    fun `assert that printResults doesn't include a NO_PRIZE result`() {
        val thirdPrize = Prize.FIFTH
        val noPrize = Prize.NO_PRIZE
        val validator = OutputValidator()
        val invalidResults = listOf(
            TicketResults(3, false, thirdPrize),
            TicketResults(0, false, noPrize),
        )
        assertThrows<IllegalArgumentException> {
            validator.validatePrintResults(invalidResults)
        }
    }

    @Test
    fun `assert that printResults requires bonus number true for SECOND prize`() {
        val secondPrize = Prize.SECOND
        val validator = OutputValidator()
        val invalidResults = listOf(
            TicketResults(5, false, secondPrize),
        )
        assertThrows<IllegalArgumentException> {
            validator.validatePrintResults(invalidResults)
        }
    }

    override fun runMain() {
        main()
    }
}
