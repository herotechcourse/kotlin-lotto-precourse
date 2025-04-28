package lotto

import lotto.domain.Rank
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
    fun `throws an exception when lotto numbers are not in range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 500))
        }
    }

    // TODO: Implement tests based on the added features
    @Test
    fun `calculateRank returns ZERO when zero numbers match`() {
        val winningNumbers = Lotto(listOf(11, 12, 13, 14, 15, 16))
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 45
        val rank = ticket.calculateRank(winningNumbers, bonusNumber)
        assertEquals(Rank.ZERO, rank)
    }

    @Test
    fun `calculateRank returns THREE when three numbers match`() {
        val winningNumbers = Lotto(listOf(11, 22, 33, 4, 5, 6))
        val ticket = Lotto(listOf(1, 2, 3, 11, 22, 33))
        val bonusNumber = 45
        val rank = ticket.calculateRank(winningNumbers, bonusNumber)
        assertEquals(Rank.THREE, rank)
    }

    @Test
    fun `calculateRank returns FOUR when four numbers match`() {
        val winningNumbers = Lotto(listOf(11, 22, 33, 44, 5, 6))
        val ticket = Lotto(listOf(1, 2, 11, 22, 33, 44))
        val bonusNumber = 45
        val rank = ticket.calculateRank(winningNumbers, bonusNumber)
        assertEquals(Rank.FOUR, rank)
    }

    @Test
    fun `calculateRank returns FIVE when five numbers match`() {
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 11))
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 45
        val rank = ticket.calculateRank(winningNumbers, bonusNumber)
        assertEquals(Rank.FIVE, rank)
    }

    @Test
    fun `calculateRank returns FIVE_BONUS when five numbers and bonus number match`() {
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 11))
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 6
        val rank = ticket.calculateRank(winningNumbers, bonusNumber)
        assertEquals(Rank.FIVE_BONUS, rank)
    }

    @Test
    fun `calculateRank returns SIX when six numbers match`() {
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 45
        val rank = ticket.calculateRank(winningNumbers, bonusNumber)
        assertEquals(Rank.SIX, rank)
    }

}
