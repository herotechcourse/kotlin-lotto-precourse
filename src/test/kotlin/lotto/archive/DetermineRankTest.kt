package lotto.archive

import lotto.domain.Rank
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class DetermineRankTest {

    @Test // 1st Prize
    fun `givenMatchCount6WithAnyBonusState_whenDetermineRank_thenReturn1st`() {
        val matchCount = 6

        // bonusMatched  = true
        val rankTrue = determineRank(matchCount, true)
        assertEquals(Rank.FIRST, rankTrue)

        // bonusMatched = false
        val rankFalse = determineRank(matchCount, false)
        assertEquals(Rank.FIRST, rankFalse)
    }

    @Test // 2nd Prize
    fun `givenMatchCount5AndBonusTrue_whenDetermineRank_thenReturns2nd`() {
        val matchCount = 5

        // bonusMatched = true
        val rank = determineRank(matchCount, true)
        assertEquals(Rank.SECOND, rank)
    }

    @Test // 3rd Prize
    fun `givenMatchCount5AndBonusFalse_whenDetermineRank_thenReturns3rd`() {
        val matchCount = 5

        // bonusMatched = false
        val rank = determineRank(matchCount, false)
        assertEquals(Rank.THIRD, rank)
    }

    @Test // 4th Prize
    fun `givenMatchCount4WithAnyBonusState_whenDetermineRank_thenReturn4th`() {
        val matchCount = 4

        // bonusMatched = true
        val rankTrue = determineRank(matchCount, true)
        assertEquals(Rank.FOURTH, rankTrue)

        // bonusMatched = false
        val rankFalse = determineRank(matchCount, false)
        assertEquals(Rank.FOURTH, rankFalse)
    }

    @Test // 5th Prize
    fun `givenMatchCount3WithAnyBonusState_whenDetermineRank_thenReturn5th`() {
        val matchCount = 3

        // bonusMatched = true
        val rankTrue = determineRank(matchCount, true)
        assertEquals(Rank.FIFTH, rankTrue)

        // bonusMatched = false
        val rankFalse = determineRank(matchCount, false)
        assertEquals(Rank.FIFTH, rankFalse)
    }

    @Test // Miss(No luck)
    fun `givenMatchCountLessThan3WithAnyBonusState_whenDetermineRank_thenReturnMiss`() {
        (0..2).forEach { matchCount ->
            // bonusMatched = true
            val rankTrue = determineRank(matchCount, true)
            assertEquals(Rank.MISS, rankTrue)

            // bonusMatched = false
            val rankFalse = determineRank(matchCount, false)
            assertEquals(Rank.MISS, rankFalse)
        }
    }
}