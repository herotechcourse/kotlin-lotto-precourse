package lotto

import lotto.domain.Prize
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrizeTest {

    @Test
    fun `returns correct prize for 6 matches`() {
        val prize = Prize.findPrize(6, false)
        assertEquals(Prize.FIRST, prize)
    }

    @Test
    fun `returns correct prize for 5 matches with bonus`() {
        val prize = Prize.findPrize(5, true)
        assertEquals(Prize.SECOND, prize)
    }

    @Test
    fun `returns correct prize for 5 matches without bonus`() {
        val prize = Prize.findPrize(5, false)
        assertEquals(Prize.THIRD, prize)
    }

    @Test
    fun `returns none for less than 3 matches`() {
        val prize = Prize.findPrize(2, false)
        assertEquals(Prize.NONE, prize)
    }
}
