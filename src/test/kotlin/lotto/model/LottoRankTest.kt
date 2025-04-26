package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoRankTest {
    @Test
    fun `returns correct LottoRank based on match count and bonus`() {
        assertEquals(LottoRank.FIRST, LottoRank.fromMatchResult(6, false))
        assertEquals(LottoRank.SECOND, LottoRank.fromMatchResult(5, true))
        assertEquals(LottoRank.THIRD, LottoRank.fromMatchResult(5, false))

        assertEquals(LottoRank.FOURTH, LottoRank.fromMatchResult(4, false))
        assertEquals(LottoRank.FOURTH, LottoRank.fromMatchResult(4, true))

        assertEquals(LottoRank.FIFTH, LottoRank.fromMatchResult(3, false))
        assertEquals(LottoRank.FIFTH, LottoRank.fromMatchResult(3, true))

        assertEquals(LottoRank.NOTHING, LottoRank.fromMatchResult(2, true))
        assertEquals(LottoRank.NOTHING, LottoRank.fromMatchResult(2, false))
        assertEquals(LottoRank.NOTHING, LottoRank.fromMatchResult(1, false))
        assertEquals(LottoRank.NOTHING, LottoRank.fromMatchResult(1, true))
    }
}