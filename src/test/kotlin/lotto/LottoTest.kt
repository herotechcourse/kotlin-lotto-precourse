package lotto

import lotto.constants.LottoRank
import org.assertj.core.api.Assertions.assertThat
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

    // TODO: Implement tests based on the added features
    @Test
    fun `returns SIX_MATCH when all 6 numbers match`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val result = lotto.match(winningNumbers, bonusNumber)

        assertThat(result).isEqualTo(LottoRank.SIX_MATCH)
    }

    @Test
    fun `returns FIVE_MATCH_WITH_BONUS when 5 numbers and bonus match`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 7, 8))
        val winningNumbers = setOf(1, 2, 3, 4, 6, 7)
        val bonusNumber = 8

        val result = lotto.match(winningNumbers, bonusNumber)

        assertThat(result).isEqualTo(LottoRank.FIVE_MATCH_WITH_BONUS)
    }

    @Test
    fun `returns FIVE_MATCH when 5 numbers match without bonus`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 8))
        val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val result = lotto.match(winningNumbers, bonusNumber)

        assertThat(result).isEqualTo(LottoRank.FIVE_MATCH)
    }

    @Test
    fun `returns FOUR_MATCH when 4 numbers match`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 7, 8))
        val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val result = lotto.match(winningNumbers, bonusNumber)

        assertThat(result).isEqualTo(LottoRank.FOUR_MATCH)
    }

    @Test
    fun `returns THREE_MATCH when 3 numbers match`() {
        val lotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val result = lotto.match(winningNumbers, bonusNumber)

        assertThat(result).isEqualTo(LottoRank.THREE_MATCH)
    }

    @Test
    fun `returns NONE when less than 3 numbers match`() {
        val lotto = Lotto(listOf(1, 2, 7, 8, 9, 10))
        val winningNumbers = setOf(3, 4, 5, 6, 11, 12)
        val bonusNumber = 13

        val result = lotto.match(winningNumbers, bonusNumber)

        assertThat(result).isEqualTo(LottoRank.NONE)
    }

    @Test
    fun `returns string representation with numbers in brackets`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val result = lotto.toString()

        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]")
    }
}
