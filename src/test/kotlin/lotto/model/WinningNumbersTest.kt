package lotto.model

import lotto.Lotto
import lotto.domain.model.WinningNumbers
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinningNumbersTest {

    private val winningNumbers = WinningNumbers(
        mainNumbers = listOf(1, 2, 3, 4, 5, 6),
        bonusNumber = 7
    )

    @Test
    fun `returns correct match count without bonus`() {
        val ticket = Lotto(listOf(1, 2, 3, 10, 11, 12))

        val result = winningNumbers.match(ticket)

        assertEquals(3, result.matchCount)
        assertEquals(false, result.bonusMatch)
    }

    @Test
    fun `returns correct match count with bonus`() {
        val ticket = Lotto(listOf(1, 2, 3, 7, 8, 9))

        val result = winningNumbers.match(ticket)

        assertEquals(3, result.matchCount)
        assertEquals(true, result.bonusMatch)
    }

    @Test
    fun `returns full match without bonus`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val result = winningNumbers.match(ticket)

        assertEquals(6, result.matchCount)
        assertEquals(false, result.bonusMatch)
    }

    @Test
    fun `returns zero match but with bonus`() {
        val ticket = Lotto(listOf(7, 8, 9, 10, 11, 12))

        val result = winningNumbers.match(ticket)

        assertEquals(0, result.matchCount)
        assertEquals(true, result.bonusMatch)
    }

    @Test
    fun `returns zero match without bonus`() {
        val ticket = Lotto(listOf(8, 9, 10, 11, 12, 13))

        val result = winningNumbers.match(ticket)

        assertEquals(0, result.matchCount)
        assertEquals(false, result.bonusMatch)
    }
}
