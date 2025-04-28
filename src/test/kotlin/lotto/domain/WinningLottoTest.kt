package lotto.domain

import lotto.Lotto
import lotto.LottoRank
import lotto.WinningLotto
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinningLottoTest {

    @Test
    fun `WinningLotto creation should succeed with valid winning numbers and bonus number`() {
        // given
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        // when & then
        assertThatCode { WinningLotto(winningNumbers, bonusNumber) }
            .doesNotThrowAnyException()
    }

    @Test
    fun `WinningLotto creation should throw exception for invalid winning numbers`() {
        // given
        val invalidWinningNumbers = listOf(1, 2, 3, 4, 5, 46) // 46 is invalid
        val bonusNumber = 7

        // when & then
        assertThatThrownBy { WinningLotto(invalidWinningNumbers, bonusNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("between 1 and 45") // Check range validation message
    }

    @Test
    fun `WinningLotto creation should throw exception for duplicated winning numbers`() {
        // given
        val invalidWinningNumbers = listOf(1, 2, 3, 4, 5, 5) // duplicate 5
        val bonusNumber = 7

        // when & then
        assertThatThrownBy { WinningLotto(invalidWinningNumbers, bonusNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("cannot contain duplicates") // Check duplicate validation message
    }

    @Test
    fun `WinningLotto creation should throw exception for invalid bonus number`() {
        // given
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val invalidBonusNumber = 46 // 46 is invalid

        // when & then
        assertThatThrownBy { WinningLotto(winningNumbers, invalidBonusNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("between 1 and 45") // Check range validation message
    }

    @Test
    fun `WinningLotto creation should throw exception if bonus number duplicates a winning number`() {
        // given
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val duplicateBonusNumber = 6 // 6 is in winningNumbers

        // when & then
        assertThatThrownBy { WinningLotto(winningNumbers, duplicateBonusNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Bonus number cannot be the same as a winning number.")
    }

    @ParameterizedTest(name = "Winning: {0}, Bonus: {1}, Lotto: {2} => Rank: {3}")
    @CsvSource(
        "'1,2,3,4,5,6', 7, '1,2,3,4,5,6', FIRST",      // 1st prize
        "'1,2,3,4,5,7', 6, '1,2,3,4,5,6', SECOND",     // 2nd prize (5 match + bonus)
        "'1,2,3,4,5,8', 7, '1,2,3,4,5,9', THIRD",      // 3rd prize (5 match, no bonus)
        "'1,2,3,4,8,9', 7, '1,2,3,4,7,10', FOURTH",    // 4th prize
        "'1,2,3,8,9,10', 7, '1,2,3,7,11,12', FIFTH",   // 5th prize
        "'1,2,8,9,10,11', 7, '1,2,7,12,13,14', MISS"   // No prize
    )
    fun `match() should return the correct LottoRank based on matches`(
        winningNumsStr: String,
        bonus: Int,
        lottoNumsStr: String,
        expectedRank: LottoRank
    ) {
        // given
        val winningNumbers = winningNumsStr.split(',').map { it.trim().toInt() }
        val lottoNumbers = lottoNumsStr.split(',').map { it.trim().toInt() }
        val winningLotto = WinningLotto(winningNumbers, bonus)
        val lotto = Lotto(lottoNumbers)

        // when & then
        assertThat(winningLotto.match(lotto)).isEqualTo(expectedRank)
    }
} 