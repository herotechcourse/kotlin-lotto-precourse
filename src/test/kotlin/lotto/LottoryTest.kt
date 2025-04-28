package lotto

import lotto.InputView.readWinningNumbers
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class LotteryTest {

    @Test
    fun testCalculateTotalWinnings() {
        val statistics = mapOf(
            Prize.THIRD to 1,
            Prize.FOURTH to 2,
            Prize.FIFTH to 3
        )

        val machine = LotteryMachine()
        val result = machine.calculateTotalWinnings(statistics)
        val expectedWinnings = 1_500_000L + (2 * 50_000L) + (3 * 5_000L)
        assertEquals(expectedWinnings, result)
    }

    @Test
    fun testAnalyzeResults() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7

        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),  // 6 matches (1st prize)
            Lotto(listOf(1, 2, 3, 4, 5, 7)),  // 5 matches + bonus (2nd prize)
            Lotto(listOf(1, 2, 3, 4, 5, 8)),  // 5 matches (3rd prize)
            Lotto(listOf(1, 2, 3, 4, 9, 10)), // 4 matches (4th prize)
            Lotto(listOf(1, 2, 3, 11, 12, 13)), // 3 matches (5th prize)
            Lotto(listOf(1, 2, 14, 15, 16, 17)) // 2 matches (no prize)
        )

        val machine = LotteryMachine()
        val result = machine.analyzeResults(tickets, winningLotto, bonusNumber)

        assertEquals(1, result[Prize.FIRST])
        assertEquals(1, result[Prize.SECOND])
        assertEquals(1, result[Prize.THIRD])
        assertEquals(1, result[Prize.FOURTH])
        assertEquals(1, result[Prize.FIFTH])
        assertNull(result[Prize.NONE])
    }

    @Test
    fun `should read and parse winning numbers correctly`() {
        // Given
        val input = "1, 2, 3, 4, 5, 6"
        System.setIn(input.byteInputStream()) // simulate user typing

        // When
        val result = readWinningNumbers()

        // Then
        assertEquals(listOf(1, 2, 3, 4, 5, 6), result)
    }
}