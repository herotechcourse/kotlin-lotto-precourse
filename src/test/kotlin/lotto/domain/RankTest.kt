package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class RankTest {

    @Test
    fun `givenMatchCountAndhasBonus_whenDetermine()_thenReturnCorrectRank`() {
        assertEquals(Rank.FIRST, Rank.determine(6, false))
        assertEquals(Rank.SECOND, Rank.determine(5, true))
        assertEquals(Rank.THIRD, Rank.determine(5, false))
        assertEquals(Rank.FOURTH, Rank.determine(4, false))
        assertEquals(Rank.FIFTH, Rank.determine(3, false))
        assertEquals(Rank.MISS, Rank.determine(2, false))
        assertEquals(Rank.MISS, Rank.determine(1, false))
        assertEquals(Rank.MISS, Rank.determine(0, false))
    }

    @Test
    fun `givenRank_whenGetPrize_thenReturnCorrectPrize`() {
        assertEquals(2000000000, Rank.FIRST.prize)
        assertEquals(30000000, Rank.SECOND.prize)
        assertEquals(1500000, Rank.THIRD.prize)
        assertEquals(50000, Rank.FOURTH.prize)
        assertEquals(5000, Rank.FIFTH.prize)
        assertEquals(0, Rank.MISS.prize)
    }
}