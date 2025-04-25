package view

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.assertj.core.api.Assertions.assertThat
import view.ParseAndValidate.winningNumbers
import view.ParseAndValidate.purchaseAmount
import view.ParseAndValidate.bonusNumber

class ParseAndValidateTest {
    @Test
    fun `exception test, invalid purchase amount input, negative sum`() {
        assertThrows<IllegalArgumentException> {
            purchaseAmount("-1000")
        } .also { e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE)) }
    }

    @Test
    fun `exception test, invalid purchase amount input, not multiple of 1,000`() {
        assertThrows<IllegalArgumentException> {
            purchaseAmount("7777")
        } .also { e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE)) }
    }

    @Test
    fun `exception test, invalid purchase amount input, empty string`() {
        assertThrows<IllegalArgumentException> {
            purchaseAmount("")
        } .also { e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE)) }
    }

    @Test
    fun `exception test, invalid purchase amount input, blank string`() {
        assertThrows<IllegalArgumentException> {
            purchaseAmount("       ")
        } .also { e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE)) }
    }

    @Test
    fun `exception test, invalid purchase amount input, string`() {
        assertThrows<IllegalArgumentException> {
            purchaseAmount("abcdf")
        } .also { e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE)) }
    }

    @Test
    fun `parse valid purchase amount input with white spaces at the start of input and at the end`() {
        assertEquals(purchaseAmount(" 8000 "), 8000)
    }

    @Test
    fun `parse valid purchase amount input`() {
        assertEquals(purchaseAmount("8000"), 8000)
    }

    @Test
    fun `exception test, invalid winning numbers input, not a number`() {
        assertThrows<IllegalArgumentException> {
            winningNumbers("1,abc")
        } .also { e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE)) }
    }

    @Test
    fun `exception test, invalid winning numbers input, empty string`() {
        assertThrows<IllegalArgumentException> {
            winningNumbers("")
        } .also { e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE)) }
    }

    @Test
    fun `exception test, invalid winning numbers input, blank string`() {
        assertThrows<IllegalArgumentException> {
            winningNumbers("         ")
        } .also { e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE)) }
    }

    @Test
    fun `exception test, invalid winning numbers input, string`() {
        assertThrows<IllegalArgumentException> {
            winningNumbers("abcdf")
        } .also { e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE)) }
    }

    @Test
    fun `exception test, invalid winning numbers input, one of numbers is grater than 45`() {
        assertThrows<IllegalArgumentException> {
            winningNumbers("1,2222,3,4,5,6")
        } .also { e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE)) }
    }

    @Test
    fun `exception test, invalid winning numbers input, one of numbers is negative`() {
        assertThrows<IllegalArgumentException> {
            winningNumbers("1,2,3,4,-5,6")
        } .also { e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE)) }
    }

    @Test
    fun `parse valid winning numbers input`() {
        assertThat(winningNumbers("1,2,3,4,5,6")).containsExactlyElementsOf(WINNING_NUMBERS)
    }

    @Test
    fun `parse valid winning numbers input with white spaces`() {
        assertThat(winningNumbers("1,2, 3 ,  4 ,5,6")).containsExactlyElementsOf(WINNING_NUMBERS)
    }

    @Test
    fun `exception test, invalid bonus number input, empty string`() {
        assertThrows<IllegalArgumentException> {
            bonusNumber("", WINNING_NUMBERS)
        } .also { e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE)) }
    }

    @Test
    fun `exception test, invalid bonus number input, blank string`() {
        assertThrows<IllegalArgumentException> {
            bonusNumber("      ", WINNING_NUMBERS)
        } .also { e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE)) }
    }

    @Test
    fun `exception test, invalid bonus number input, not a number`() {
        assertThrows<IllegalArgumentException> {
            bonusNumber("abcdf", WINNING_NUMBERS)
        } .also { e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE)) }
    }

    @Test
    fun `exception test, invalid bonus number input, negative number`() {
        assertThrows<IllegalArgumentException> {
            bonusNumber("-2", WINNING_NUMBERS)
        } .also { e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE)) }
    }

    @Test
    fun `exception test, invalid bonus number input, zero`() {
        assertThrows<IllegalArgumentException> {
            bonusNumber("0", WINNING_NUMBERS)
        } .also { e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE)) }
    }

    @Test
    fun `valid bonus number input, number in range 1 to 45`() {
        assertTrue(bonusNumber("21", WINNING_NUMBERS) == 21)
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
        private val WINNING_NUMBERS: List<Int> = listOf(1, 2, 3, 4, 5, 6)
    }
}