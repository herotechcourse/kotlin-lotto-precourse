package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LottoGradeTest {

    @Test
    fun `returns correct grade for six matches`() {
        assertEquals(LottoGrade.FIRST, LottoGrade.valueOfMatch(6, false))
        assertEquals(LottoGrade.FIRST, LottoGrade.valueOfMatch(6, true))
    }

    @Test
    fun `returns correct grade for five matches with bonus`() {
        assertEquals(LottoGrade.SECOND, LottoGrade.valueOfMatch(5, true))
    }

    @Test
    fun `returns correct grade for five matches without bonus`() {
        assertEquals(LottoGrade.THIRD, LottoGrade.valueOfMatch(5, false))
    }

    @Test
    fun `returns correct grade for four matches`() {
        assertEquals(LottoGrade.FOURTH, LottoGrade.valueOfMatch(4, false))
        assertEquals(LottoGrade.FOURTH, LottoGrade.valueOfMatch(4, true))
    }

    @Test
    fun `returns correct grade for three matches`() {
        assertEquals(LottoGrade.FIFTH, LottoGrade.valueOfMatch(3, false))
        assertEquals(LottoGrade.FIFTH, LottoGrade.valueOfMatch(3, true))
    }

    @Test
    fun `returns none for less than three matches`() {
        assertEquals(LottoGrade.NONE, LottoGrade.valueOfMatch(2, false))
        assertEquals(LottoGrade.NONE, LottoGrade.valueOfMatch(1, true))
        assertEquals(LottoGrade.NONE, LottoGrade.valueOfMatch(0, false))
    }
}