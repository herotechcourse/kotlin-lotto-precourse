package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrizeTest {

    @Test
    fun `should return FIRST prize for 6 matches`() {
        val prize = Prize.prizeFinder(6, false)
        assertEquals(Prize.FIRST, prize)
    }

    @Test
    fun `should return SECOND prize for 5 matches with bonus ball`() {
        val prize = Prize.prizeFinder(5, true)
        assertEquals(Prize.SECOND, prize)
    }

    @Test
    fun `should return THIRD prize for 5 matches without bonus ball`() {
        val prize = Prize.prizeFinder(5, false)
        assertEquals(Prize.THIRD, prize)
    }

    @Test
    fun `should return FOURTH prize for 4 matches`() {
        val prize = Prize.prizeFinder(4, false)
        assertEquals(Prize.FOURTH, prize)
    }

    @Test
    fun `should return FIFTH prize for 3 matches`() {
        val prize = Prize.prizeFinder(3, false)
        assertEquals(Prize.FIFTH, prize)
    }

    @Test
    fun `should return NONE prize for less than 3 matches`() {
        val prize = Prize.prizeFinder(2, false)
        assertEquals(Prize.NONE, prize)
    }

    @Test
    fun `should return NONE prize for 0 matches`() {
        val prize = Prize.prizeFinder(0, false)
        assertEquals(Prize.NONE, prize)
    }
}
