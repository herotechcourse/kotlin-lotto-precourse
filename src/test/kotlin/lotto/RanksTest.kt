package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RanksTest {

    @Test
    fun `returns FIRST when 6 matches`() {
        assertEquals(Ranks.FIRST, Ranks.of(6, false))
    }

    @Test
    fun `returns SECOND when 5 matches and bonus matched`() {
        assertEquals(Ranks.SECOND, Ranks.of(5, true))
    }

    @Test
    fun `returns THIRD when 5 matches without bonus`() {
        assertEquals(Ranks.THIRD, Ranks.of(5, false))
    }

    @Test
    fun `returns FOURTH when 4 matches`() {
        assertEquals(Ranks.FOURTH, Ranks.of(4, false))
    }

    @Test
    fun `returns FIFTH when 3 matches`() {
        assertEquals(Ranks.FIFTH, Ranks.of(3, false))
    }

    @Test
    fun `returns NONE when less than 3 matches`() {
        assertEquals(Ranks.NONE, Ranks.of(2, false))
        assertEquals(Ranks.NONE, Ranks.of(1, false))
        assertEquals(Ranks.NONE, Ranks.of(0, false))
    }
}
