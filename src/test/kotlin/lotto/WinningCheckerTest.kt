package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinningCheckerTest {
    
    @Test
    fun `WinningChecker constructor should validate winning numbers size`() {
        assertThatThrownBy { WinningChecker(listOf(1, 2, 3, 4, 5), 10) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Winning numbers must be exactly 6.")
    }
    
    @Test
    fun `WinningChecker constructor should validate winning numbers range`() {
        assertThatThrownBy { WinningChecker(listOf(1, 2, 3, 4, 5, 46), 10) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Winning numbers must be between 1 and 45.")
    }
    
    @Test
    fun `WinningChecker constructor should validate winning numbers uniqueness`() {
        assertThatThrownBy { WinningChecker(listOf(1, 2, 3, 4, 5, 5), 10) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Winning numbers must be unique.")
    }
    
    @Test
    fun `WinningChecker constructor should validate bonus number range`() {
        assertThatThrownBy { WinningChecker(listOf(1, 2, 3, 4, 5, 6), 46) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Bonus number must be between 1 and 45.")
    }
    
    @Test
    fun `WinningChecker constructor should validate bonus number is not in winning numbers`() {
        assertThatThrownBy { WinningChecker(listOf(1, 2, 3, 4, 5, 6), 6) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Bonus number must not be in winning numbers.")
    }

    @Test
    fun `checkLotto should return FIRST for all 6 matches`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningChecker = WinningChecker(winningNumbers, bonusNumber)
        
        assertThat(winningChecker.checkLotto(lotto)).isEqualTo(LottoResult.FIRST)
    }
    
    @Test
    fun `checkLotto should return SECOND for 5 matches plus bonus`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val winningChecker = WinningChecker(winningNumbers, bonusNumber)
        
        assertThat(winningChecker.checkLotto(lotto)).isEqualTo(LottoResult.SECOND)
    }
    
    @Test
    fun `checkLotto should return THIRD for 5 matches without bonus`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 8))
        val winningChecker = WinningChecker(winningNumbers, bonusNumber)
        
        assertThat(winningChecker.checkLotto(lotto)).isEqualTo(LottoResult.THIRD)
    }
    
    @Test
    fun `checkLotto should return FOURTH for 4 matches`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val lotto = Lotto(listOf(1, 2, 3, 4, 8, 9))
        val winningChecker = WinningChecker(winningNumbers, bonusNumber)
        
        assertThat(winningChecker.checkLotto(lotto)).isEqualTo(LottoResult.FOURTH)
    }
    
    @Test
    fun `checkLotto should return FIFTH for 3 matches`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val lotto = Lotto(listOf(1, 2, 3, 8, 9, 10))
        val winningChecker = WinningChecker(winningNumbers, bonusNumber)
        
        assertThat(winningChecker.checkLotto(lotto)).isEqualTo(LottoResult.FIFTH)
    }
    
    @Test
    fun `checkLotto should return NONE for less than 3 matches`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val lotto = Lotto(listOf(1, 2, 8, 9, 10, 11))
        val winningChecker = WinningChecker(winningNumbers, bonusNumber)
        
        assertThat(winningChecker.checkLotto(lotto)).isEqualTo(LottoResult.NONE)
    }
}