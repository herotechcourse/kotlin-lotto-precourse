package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class WinningLottoTest {
    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 45
    private val winningLotto = WinningLotto(Lotto(winningNumbers), bonusNumber)

    @Test
    fun `throws an exception when an invalid winning lotto numbers are provided`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6, 7)), 1)
        }
    }

    @Test
    fun `throws an exception when an invalid bonus number is provided`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 100)
        }
    }

    @Test
    fun `FIRST prize when all the 6 numbers match`() {
        assertThat(winningLotto.getRank(Lotto(winningNumbers))).isEqualTo(LottoRank.FIRST)
    }

    @Test
    fun `SECOND prize when 5 numbers and bonus number match`() {
        val numbers = listOf(1, 2, 3, 4, 5, bonusNumber)
        assertThat(winningLotto.getRank(Lotto(numbers))).isEqualTo(LottoRank.SECOND)
    }

    @Test
    fun `THIRD prize when 5 numbers match but bonus number not match`() {
        val numbers = listOf(1, 2, 3, 4, 5, 10)
        assertThat(winningLotto.getRank(Lotto(numbers))).isEqualTo(LottoRank.THIRD)
    }

    @Test
    fun `FOURTH prize when 4 numbers match regardless bonus number match`() {
        val withBonusNumbers = listOf(1, 2, 3, 4, 10, bonusNumber)
        val withoutBonusNumbers = listOf(1, 2, 3, 4, 10, 11)
        assertThat(winningLotto.getRank(Lotto(withBonusNumbers))).isEqualTo(LottoRank.FOURTH)
        assertThat(winningLotto.getRank(Lotto(withoutBonusNumbers))).isEqualTo(LottoRank.FOURTH)
    }

    @Test
    fun `FIFTH prize when 3 numbers match regardless bonus number match`() {
        val withBonusNumbers = listOf(1, 2, 3, 10, 11, bonusNumber)
        val withoutBonusNumbers = listOf(1, 2, 3, 10, 11, 12)
        assertThat(winningLotto.getRank(Lotto(withBonusNumbers))).isEqualTo(LottoRank.FIFTH)
        assertThat(winningLotto.getRank(Lotto(withoutBonusNumbers))).isEqualTo(LottoRank.FIFTH)
    }

    @Test
    fun `NONE prize when less than 3 numbers match regardless bonus number match`() {
        val twoMatchingwithBonusNumbers = listOf(1, 2, 10, 11, 12, bonusNumber)
        val twoMatchingwithoutBonusNumbers = listOf(1, 2, 10, 11, 12, 13)
        assertThat(winningLotto.getRank(Lotto(twoMatchingwithBonusNumbers))).isEqualTo(LottoRank.NONE)
        assertThat(winningLotto.getRank(Lotto(twoMatchingwithoutBonusNumbers))).isEqualTo(LottoRank.NONE)

        val oneMatchingwithBonusNumbers = listOf(1, 9, 10, 11, 12, bonusNumber)
        val oneMatchingwithoutBonusNumbers = listOf(1, 9, 10, 11, 12, 13)
        assertThat(winningLotto.getRank(Lotto(oneMatchingwithBonusNumbers))).isEqualTo(LottoRank.NONE)
        assertThat(winningLotto.getRank(Lotto(oneMatchingwithoutBonusNumbers))).isEqualTo(LottoRank.NONE)

        val noMatchingwithBonusNumbers = listOf(8, 9, 10, 11, 12, bonusNumber)
        val noMatchingwithoutBonusNumbers = listOf(8, 9, 10, 11, 12, 13)
        assertThat(winningLotto.getRank(Lotto(noMatchingwithBonusNumbers))).isEqualTo(LottoRank.NONE)
        assertThat(winningLotto.getRank(Lotto(noMatchingwithoutBonusNumbers))).isEqualTo(LottoRank.NONE)
    }
}
