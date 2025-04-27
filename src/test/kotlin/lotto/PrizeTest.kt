package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrizeTest {
    @Test
    fun `returns correctly formatted money for each prize`() {
        assertEquals("2,000,000,000", Prize.FIRST.getFormattedMoney())
        assertEquals("30,000,000", Prize.SECOND.getFormattedMoney())
        assertEquals("1,500,000", Prize.THIRD.getFormattedMoney())
        assertEquals("50,000", Prize.FOURTH.getFormattedMoney())
        assertEquals("5,000", Prize.FIFTH.getFormattedMoney())
    }
}