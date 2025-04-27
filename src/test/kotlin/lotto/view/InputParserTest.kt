package lotto.view

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputParserTest {
    private val parser = InputParser()

    @Test
    fun `throws an exception when purchase amount is not numeric`() {
        assertThrows<IllegalArgumentException> {
            parser.parsePurchaseAmount("1000j")
        }
    }

    @Test
    fun `throws an exception when purchase amount is not positive`() {
        assertThrows<IllegalArgumentException> {
            parser.parsePurchaseAmount("-1000")
        }
    }

    @Test
    fun `throws an exception when winning numbers contains not numeric`() {
        assertThrows<IllegalArgumentException> {
            parser.parseWinningNumbers("1,2,3,4,5,six")
        }
    }

    @Test
    fun `throws an exception when bonus number is not numeric`() {
        assertThrows<IllegalArgumentException> {
            parser.parseBonusNumber("ten")
        }
    }
}
