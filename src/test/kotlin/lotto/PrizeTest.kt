package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrizeTest {

    @Test
    fun testFirstRank() {
        val rank = Prize.getRank(6, false)
        assertEquals(Prize.FIRST, rank)
    }

    @Test
    fun testSecondRank() {
        val rank = Prize.getRank(5, true)
        assertEquals(Prize.SECOND, rank)
    }

    @Test
    fun testThirdRank() {
        val rank = Prize.getRank(5, false)
        assertEquals(Prize.THIRD, rank)
    }

    @Test
    fun testFourthRank() {
        val rank = Prize.getRank(4, false)
        assertEquals(Prize.FOURTH, rank)
    }

    @Test
    fun testFifthRank() {
        val rank = Prize.getRank(3, false)
        assertEquals(Prize.FIFTH, rank)
    }

    @Test
    fun testNoRank() {
        val rank1 = Prize.getRank(2, false)
        val rank2 = Prize.getRank(1, false)
        val rank3 = Prize.getRank(0, false)

        assertEquals(Prize.NONE, rank1)
        assertEquals(Prize.NONE, rank2)
        assertEquals(Prize.NONE, rank3)
    }

}