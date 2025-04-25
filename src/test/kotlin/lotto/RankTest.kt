package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `match 6 numbers and get a 1st Prize`() {
        val rank = Rank.getRank(6, false)
        assertEquals(rank.rank, 1)
    }

    @Test
    fun `match 5 numbers and bonus number and get a 2nd prize`() {
        val rank = Rank.getRank(5, true)
        assertEquals(rank.rank, 2)
    }

    @Test
    fun `match 5 numbers and get a 3rd prize`() {
        val rank = Rank.getRank(5, false)
        assertEquals(rank.rank, 3)
    }

    @Test
    fun `match 4 numbers and get a 4th prize`() {
        val rank = Rank.getRank(4, false)
        assertEquals(rank.rank, 4)
    }

    @Test
    fun `match 3 numbers and get a 5th prize`() {
        val rank = Rank.getRank(3, true)
        assertEquals(rank.rank, 5)
    }

    @Test
    fun `match 2 numbers and don't get a prize`() {
        val rank = Rank.getRank(2, true)
        assertEquals(rank.rank, -1)
    }

}
