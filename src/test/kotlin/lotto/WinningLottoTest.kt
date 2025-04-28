package lotto

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class WinningLottoTest {

    @Test
    fun `register winning numbers correctly`() {
        val winningLotto = WinningLotto()
        val inputNumbers = listOf(1, 2, 3, 4, 5, 6)

        winningLotto.registerWinningNumbers(inputNumbers)

        assertThat(winningLotto.getWinningNumbers()).containsExactlyElementsOf(inputNumbers)
    }

    @Test
    fun `register bonus number correctly`() {
        val winningLotto = WinningLotto()
        val bonusNumber = 7

        winningLotto.registerBonusNumber(bonusNumber)

        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber)
    }
}