package lotto

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals

class LottoTest {
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        } .also { e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE)) }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        } .also { e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE)) }
    }

    @Test
    fun `throws an exception when lotto numbers contain numbers out of range from 1 to 45`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3333, 4, 5, 6))
        } .also { e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE)) }
    }

    @Test
    fun `lotto ticket contains number`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertTrue(ticket.containsNumber(6))
    }

    @Test
    fun `lotto ticket has 3 matches with winning numbers`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(ticket.matchCount(listOf(6, 1, 5, 8, 11, 40)), 3)
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }
}
