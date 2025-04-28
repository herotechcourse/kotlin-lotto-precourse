package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: Implement production code to pass the test
    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `should return valid winning numbers`() {
        // Act
        val winningNumbers = Lotto.getWinningNumbers("1, 2, 3, 4, 5, 6")

        // Assert
        assertEquals(listOf(1, 2, 3, 4, 5, 6), winningNumbers)
    }

    @Test
    fun `should throw exception for invalid winning numbers input`() {
        // Act & Assert
        val exception = assertThrows<IllegalArgumentException> {
            Lotto.getWinningNumbers("1, 2, invalid, 4, 5, 6")
        }
        assertEquals("You must enter exactly 6 numbers.", exception.message)
    }

    @Test
    fun `should throw exception for winning numbers out of range`() {
        // Act & Assert
        val exception = assertThrows<IllegalArgumentException> {
            Lotto.getWinningNumbers("1, 2, 3, 4, 5, 46")
        }
        assertEquals("All numbers must be between 1 and 45.", exception.message)
    }

    @Test
    fun `should throw exception for duplicate winning numbers`() {
        // Act & Assert
        val exception = assertThrows<IllegalArgumentException> {
            Lotto.getWinningNumbers("1, 2, 3, 3, 5, 6")
        }
        assertEquals("Numbers must be unique.", exception.message)
    }

    @Test
    fun `should return valid bonus number`() {
        // Arrange
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        // Act
        val bonusNumber = Lotto.getBonusNumber("7", winningNumbers)

        // Assert
        assertEquals(7, bonusNumber)
    }

    @Test
    fun `should throw exception for bonus number in winning numbers`() {
        // Arrange
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        // Act & Assert
        val exception = assertThrows<IllegalArgumentException> {
            Lotto.getBonusNumber("3", winningNumbers)
        }
        assertEquals("Bonus number must not be included in the winning numbers.", exception.message)
    }

    @Test
    fun `should throw exception for bonus number out of range`() {
        // Arrange
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        // Act & Assert
        val exception = assertThrows<IllegalArgumentException> {
            Lotto.getBonusNumber("46", winningNumbers)
        }
        assertEquals("Bonus number must be between 1 and 45.", exception.message)
    }

    @Test
    fun `should correctly evaluate ranks and total winnings`() {
        // Arrange
        val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)), // 6 Matches
            Lotto(listOf(1, 2, 3, 4, 5, 7)), // 5 Matches + Bonus
            Lotto(listOf(1, 2, 3, 4, 5, 8)), // 5 Matches
            Lotto(listOf(1, 2, 3, 4, 10, 11)), // 4 Matches
            Lotto(listOf(1, 2, 3, 12, 13, 14)), // 3 Matches
            Lotto(listOf(20, 21, 22, 23, 24, 25)) // No Matches
        )

        // Act
        val result = Lotto.evaluateResults(tickets, winningNumbers, bonusNumber)

        // Assert
        assertEquals(1, result.rankCounts[Rank.FIRST]) // 6 Matches
        assertEquals(1, result.rankCounts[Rank.SECOND]) // 5 Matches + Bonus
        assertEquals(1, result.rankCounts[Rank.THIRD]) // 5 Matches
        assertEquals(1, result.rankCounts[Rank.FOURTH]) // 4 Matches
        assertEquals(1, result.rankCounts[Rank.FIFTH]) // 3 Matches
        assertEquals(1, result.rankCounts[Rank.NONE]) // No Matches
        assertEquals(
            Rank.FIRST.prize + Rank.SECOND.prize + Rank.THIRD.prize + Rank.FOURTH.prize + Rank.FIFTH.prize,
            result.totalWinnings
        )
    }

    @Test
    fun `should calculate correct profit rate`() {
        // Arrange
        val rankCounts = mapOf(
            Rank.FIRST to 1,
            Rank.SECOND to 0,
            Rank.THIRD to 0,
            Rank.FOURTH to 0,
            Rank.FIFTH to 0
        )
        val totalWinnings = Rank.FIRST.prize
        val result = Lotto.Companion.Result(rankCounts, totalWinnings)

        // Act
        val profitRate = result.calculateProfitRate(10_000)

        // Assert
        assertEquals(20000000.0, profitRate, 0.1)
    }
}
