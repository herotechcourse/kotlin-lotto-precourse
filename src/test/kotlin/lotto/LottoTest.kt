package lotto

import lotto.Application.Companion.Prize
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> { Lotto(listOf(1, 2, 3, 4, 5, 5)) }
    }

    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> { Lotto(listOf(1, 2, 3, 4, 5, 6, 7)) }
    }

    @Test
    fun `should calculate correct win results`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val tickets = listOf(
            listOf(1, 2, 3, 4, 5, 6), // 1st Prize
            listOf(1, 2, 3, 4, 5, 7), // 2nd Prize
            listOf(1, 2, 3, 4, 5, 8), // 3rd Prize
            listOf(1, 2, 3, 4, 9, 10), // 4th Prize
            listOf(1, 2, 3, 11, 12, 13), // 5th Prize
            listOf(14, 15, 16, 17, 18, 19) // No Prize
        )

        val lotto = Lotto(winningNumbers)
        val results = lotto.calculateWin(tickets, bonusNumber)

        assertEquals(1, results[Prize.MATCH_SIX])
        assertEquals(1, results[Prize.MATCH_FIVE_BONUS])
        assertEquals(1, results[Prize.MATCH_FIVE])
        assertEquals(1, results[Prize.MATCH_FOUR])
        assertEquals(1, results[Prize.MATCH_THREE])
        assertEquals(0, results.values.sum() - 5) // Ensure no extra prizes are counted
    }

    @Test
    fun `should return zero for all prizes when no tickets match`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val tickets = listOf(listOf(10, 11, 12, 13, 14, 15), listOf(20, 21, 22, 23, 24, 25))

        val lotto = Lotto(winningNumbers)
        val results = lotto.calculateWin(tickets, bonusNumber)

        Prize.values().forEach { prize -> assertEquals(0, results[prize]) }
    }
}
