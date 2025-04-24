package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LottoResultTest {

    @Test
    fun `should return FIRST for 6 matches`() {
        val result = LottoResult.from(6, false)
        assertEquals(LottoResult.FIRST, result)
        assertEquals(6, result.matchCount)
        assertEquals(false, result.hasBonus)
        assertEquals(2_000_000_000, result.prize)
    }

    @Test
    fun `should return FIRST for 6 matches even with bonus`() {
        val result = LottoResult.from(6, true)
        assertEquals(LottoResult.FIRST, result)
    }

    @Test
    fun `should return SECOND for 5 matches with bonus`() {
        val result = LottoResult.from(5, true)
        assertEquals(LottoResult.SECOND, result)
        assertEquals(5, result.matchCount)
        assertEquals(true, result.hasBonus)
        assertEquals(30_000_000, result.prize)
    }

    @Test
    fun `should return THIRD for 5 matches without bonus`() {
        val result = LottoResult.from(5, false)
        assertEquals(LottoResult.THIRD, result)
        assertEquals(5, result.matchCount)
        assertEquals(false, result.hasBonus)
        assertEquals(1_500_000, result.prize)
    }

    @Test
    fun `should return FOURTH for 4 matches`() {
        val result = LottoResult.from(4, false)
        assertEquals(LottoResult.FOURTH, result)
        assertEquals(4, result.matchCount)
        assertEquals(false, result.hasBonus)
        assertEquals(50_000, result.prize)
    }

    @Test
    fun `should return FOURTH for 4 matches with bonus`() {
        val result = LottoResult.from(4, true)
        assertEquals(LottoResult.FOURTH, result)
    }

    @Test
    fun `should return FIFTH for 3 matches`() {
        val result = LottoResult.from(3, false)
        assertEquals(LottoResult.FIFTH, result)
        assertEquals(3, result.matchCount)
        assertEquals(false, result.hasBonus)
        assertEquals(5_000, result.prize)
    }

    @Test
    fun `should return FIFTH for 3 matches with bonus`() {
        val result = LottoResult.from(3, true)
        assertEquals(LottoResult.FIFTH, result)
    }

    @Test
    fun `should return NONE for 2 matches`() {
        val result = LottoResult.from(2, false)
        assertEquals(LottoResult.NONE, result)
        assertEquals(0, result.matchCount)
        assertEquals(false, result.hasBonus)
        assertEquals(0, result.prize)
    }

    @Test
    fun `should return NONE for 1 match`() {
        val result = LottoResult.from(1, false)
        assertEquals(LottoResult.NONE, result)
    }

    @Test
    fun `should return NONE for 0 matches`() {
        val result = LottoResult.from(0, false)
        assertEquals(LottoResult.NONE, result)
    }

    @Test
    fun `should return NONE for 2 matches with bonus`() {
        val result = LottoResult.from(2, true)
        assertEquals(LottoResult.NONE, result)
    }
}
