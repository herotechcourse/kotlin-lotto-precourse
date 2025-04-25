package view

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.assertj.core.api.Assertions.assertThat
import view.ParseAndValidate.winningNumbers
import view.ParseAndValidate.purchaseAmount

class ParseAndValidateTest {
    @Test
    fun `exception test, invalid purchase amount input, negative sum`() {
        assertThrows<IllegalArgumentException> {
            purchaseAmount("-1000")
        } .also {
            e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE))
        }
    }

    @Test
    fun `exception test, invalid purchase amount input, not multiple of 1,000`() {
        assertThrows<IllegalArgumentException> {
            purchaseAmount("7777")
        } .also {
            e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE))
        }
    }

    @Test
    fun `exception test, invalid purchase amount input, empty string`() {
        assertThrows<IllegalArgumentException> {
            purchaseAmount("")
        } .also {
            e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE))
        }
    }

    @Test
    fun `exception test, invalid purchase amount input, blank string`() {
        assertThrows<IllegalArgumentException> {
            purchaseAmount("       ")
        } .also {
            e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE))
        }
    }

    @Test
    fun `exception test, invalid purchase amount input, string`() {
        assertThrows<IllegalArgumentException> {
            purchaseAmount("abcdf")
        } .also {
            e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE))
        }
    }

    @Test
    fun `parse valid purchase amount input with white spaces at the start of input and at the end`() {
        assertEquals(purchaseAmount(" 8000 "), 8000)
    }

    @Test
    fun `parse valid purchase amount input`() {
        assertEquals(purchaseAmount("8000"), 8000)
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }
}