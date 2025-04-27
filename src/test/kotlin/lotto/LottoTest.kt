package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals

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

    // TODO: Implement tests based on the added features
    @Test
    fun `returns 1st prize when all 6 numbers match`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val prize = ticket.matchPrize(winningNumbers, bonusNumber)

        assertEquals(1, prize)
    }

    @Test
    fun `returns 2nd prize when 5 numbers match and bonus number matches`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 7)
        val bonusNumber = 6

        val prize = ticket.matchPrize(winningNumbers, bonusNumber)

        assertEquals(2, prize)
    }

    @Test
    fun `returns 3rd prize when 5 numbers match but bonus number does not match`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 7)
        val bonusNumber = 8

        val prize = ticket.matchPrize(winningNumbers, bonusNumber)

        assertEquals(3, prize)
    }

    @Test
    fun `returns 4th prize when 4 numbers match`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 4, 7, 8)
        val bonusNumber = 9

        val prize = ticket.matchPrize(winningNumbers, bonusNumber)

        assertEquals(4, prize)
    }

    @Test
    fun `returns 5th prize when 3 numbers match`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 7, 8, 9)
        val bonusNumber = 10

        val prize = ticket.matchPrize(winningNumbers, bonusNumber)

        assertEquals(5, prize)
    }

    @Test
    fun `returns 6th prize when no numbers match`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(7, 8, 9, 10, 11, 12)
        val bonusNumber = 13

        val prize = ticket.matchPrize(winningNumbers, bonusNumber)

        assertEquals(6, prize)
    }
}
