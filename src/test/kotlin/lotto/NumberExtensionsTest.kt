package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class NumberExtensionsTest {

    @Test
    fun `formatWithComma should format Int correctly`() {
        val number = 1234567
        val formatted = number.formatWithComma()
        assertEquals("1,234,567", formatted)
    }

    @Test
    fun `formatWithComma should format Long correctly`() {
        val number = 9876543210
        val formatted = number.formatWithComma()
        assertEquals("9,876,543,210", formatted)
    }

    @Test
    fun `formatWithComma should format Float correctly with one decimal place`() {
        val number = 3333.3f
        val formatted = number.formatWithComma()
        assertEquals("3,333.3", formatted)
    }

    @Test
    fun `formatWithComma should format Double correctly with one decimal place`() {
        val number = 1234567.89
        val formatted = number.formatWithComma()
        assertEquals("1,234,567.9", formatted) // Only 1 decimal place, rounds to .9
    }

    @Test
    fun `roundToDecimalPlaces should round Float to specified places`() {
        val number = 3.14159f
        val rounded = number.roundToDecimalPlaces(2)
        assertEquals(3.14, rounded)
    }

    @Test
    fun `roundToDecimalPlaces should round Float with no decimal places`() {
        val number = 9.99f
        val rounded = number.roundToDecimalPlaces(0)
        assertEquals(10.0, rounded)
    }

    @Test
    fun `roundToDecimalPlaces should throw exception for negative places`() {
        val number = 2.5f
        val exception = assertThrows(IllegalArgumentException::class.java) {
            number.roundToDecimalPlaces(-1)
        }
        assertEquals("Decimal places must be non-negative.", exception.message)
    }
}