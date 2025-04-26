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
}
