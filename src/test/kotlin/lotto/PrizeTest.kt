package lotto

import lotto.domain.Prize
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class PrizeTest {
    @Test
    fun `returns correct prize for 6 matches`() {
        val prize = Prize.determinePrize(6, false)
        assertEquals(Prize.FIRST, prize)
    }

    @Test
    fun `returns correct prize for 5 matches with bonus`() {
        val prize = Prize.determinePrize(5, true)
        assertEquals(Prize.SECOND, prize)
    }

    @Test
    fun `returns correct prize for 5 matches without bonus`() {
        val prize = Prize.determinePrize(5, false)
        assertEquals(Prize.THIRD, prize)
    }

    @Test
    fun `returns correct prize for 4 matches`() {
        val prize = Prize.determinePrize(4, false)
        assertEquals(Prize.FOURTH, prize)
    }

    @Test
    fun `returns correct prize for 3 matches`() {
        val prize = Prize.determinePrize(3, false)
        assertEquals(Prize.FIFTH, prize)
    }

    @Test
    fun `returns null for less than 3 matches`() {
        val prize = Prize.determinePrize(2, false)
        assertNull(prize)
    }

    @Test
    fun `returns null for invalid match count`() {
        val prize = Prize.determinePrize(7, false)
        assertNull(prize)
    }
}