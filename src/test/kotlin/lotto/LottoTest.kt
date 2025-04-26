package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class LottoTest {
    /**
     * Tests for Lotto constructor validation
     * - Must contain exactly 6 numbers
     * - Must not contain duplicates
     * - All numbers must be between 1 and 45
     */
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `throws exception when any number is not between 1 and 45`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
            Lotto(listOf(0, 1, 2, 3, 4, 5))
        }
    }

    /**
     * Tests for Lotto.create()
     * - Should not throw any exception even when created multiple times
     */
    @Test
    fun `does not throw exception when lotto is created 1000 times`() {
        repeat(1000) {
            assertDoesNotThrow { Lotto.create() }
        }
    }

    /**
     * Tests for Lotto.toRank(winningNumbers, bonusNumber)
     * - Calculates prize rank based on match count and bonus number
     */
    @Test
    fun `returns FIRST rank when all numbers match`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winnersNumber = listOf(1, 2, 3, 4, 5, 6)

        assertThat(lotto.toRank(winnersNumber, 7)).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `returns SECOND rank when 5 numbers match and bonus matches`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 7)

        assertThat(lotto.toRank(winningNumbers, 6)).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `returns THIRD rank when 5 numbers match but bonus does not match`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 7)

        assertThat(lotto.toRank(winningNumbers, 8)).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `returns FOURTH rank when 4 numbers match`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 4, 7, 8)

        assertThat(lotto.toRank(winningNumbers, 9)).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `returns FIFTH rank when 3 numbers match`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 7, 8, 9)

        assertThat(lotto.toRank(winningNumbers, 10)).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `returns null when fewer than 3 numbers match`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(7, 8, 9, 10, 11, 12)

        assertThat(lotto.toRank(winningNumbers, 13)).isEqualTo(null)
    }
}
