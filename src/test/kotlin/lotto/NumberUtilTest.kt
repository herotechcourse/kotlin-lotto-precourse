package lotto

import lotto.NumberUtil.formatDouble
import lotto.NumberUtil.formatInt
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberUtilTest {

    @Test
    fun `format int to comma pattern`() {
        val formatInt = 2_000_000_000.formatInt()

        assertEquals("2,000,000,000", formatInt)
    }

    @Test
    fun `format double to comma and one decimal pattern`() {
        val formatDouble = 1_000_000.5.formatDouble()

        assertEquals("1,000,000.5", formatDouble)
    }
}
