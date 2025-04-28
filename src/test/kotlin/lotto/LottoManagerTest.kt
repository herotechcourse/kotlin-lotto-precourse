package lotto

import lotto.LottoManager.getTotalPrize
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoManagerTest {

    @BeforeEach
    fun reset() {
        LottoManager.clear()
    }

    @Test
    fun `addTicket adds tickets and getTickets returns them in order`() {
        val t1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val t2 = Lotto(listOf(11, 12, 13, 14, 15, 16))

        LottoManager.addTicket(t1)
        LottoManager.addTicket(t2)

        val tickets = LottoManager.getTickets()
        assertEquals(listOf(t1, t2), tickets)
    }

    @Test
    fun `makeRankTable populates rank counts and getRankTable returns correct counts`() {
        val winning = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val rankZero = Lotto(listOf(11, 12, 13, 14, 15, 16))
        val rankThree = Lotto(listOf(1, 2, 3, 11, 12, 13))
        val rankFour = Lotto(listOf(1, 2, 3, 4, 11, 12))
        val rankFive = Lotto(listOf(1, 2, 3, 4, 5, 10))
        val rankFiveBonus = Lotto(listOf(1, 2, 3, 4, 5, 11))
        val rankSix = Lotto(listOf(1, 2, 3, 4, 5, 6))

        LottoManager.addTicket(rankZero)
        LottoManager.addTicket(rankThree)
        LottoManager.addTicket(rankFour)
        LottoManager.addTicket(rankFive)
        LottoManager.addTicket(rankFiveBonus)
        LottoManager.addTicket(rankSix)

        LottoManager.makeRankTable(winning, bonusNumber = 11)

        val counts = LottoManager.getRankTable()

        assertEquals(1, counts[Rank.ZERO.ordinal])
        assertEquals(1, counts[Rank.THREE.ordinal])
        assertEquals(1, counts[Rank.FOUR.ordinal])
        assertEquals(1, counts[Rank.FIVE.ordinal])
        assertEquals(1, counts[Rank.FIVE_BONUS.ordinal])
        assertEquals(1, counts[Rank.SIX.ordinal])
    }

    @Test
    fun `totalPrize calculates the sum of the prize amounts of each rank`() {
        val winning = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val rankZero = Lotto(listOf(11, 12, 13, 14, 15, 16))
        val rankThree = Lotto(listOf(1, 2, 3, 11, 12, 13))
        val rankFive = Lotto(listOf(1, 2, 3, 4, 5, 11))

        LottoManager.addTicket(rankZero)
        LottoManager.addTicket(rankThree)
        LottoManager.addTicket(rankFive)
        LottoManager.makeRankTable(winning, bonusNumber = 45)

        /**
         * Total Prize is
         * 1,505,000 = 5,000(RankThree) + 1,500,000(RankFive)
         */
        assertEquals(1_505_000, getTotalPrize())
    }

    @Test
    fun `returnRate computes profit rate rounded to nearest tenth`() {
        val winning = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val rankZero = Lotto(listOf(11, 12, 13, 14, 15, 16))
        val rankThree = Lotto(listOf(1, 2, 3, 11, 12, 13))
        val rankFive = Lotto(listOf(1, 2, 3, 4, 5, 11))

        LottoManager.addTicket(rankZero)
        LottoManager.addTicket(rankThree)
        LottoManager.addTicket(rankFive)
        LottoManager.makeRankTable(winning, bonusNumber = 45)

        /**
         * Total Prize is
         * 1,505,000 = 5,000(RankThree) + 1,500,000(RankFive)
         * So the return rate is about 1,505,000 / 3,000 * 100 = 50166.7
         */
        val rate = LottoManager.returnRate(purchaseAmount = 3_000)
        assertEquals(50_166.7, rate)
    }
}