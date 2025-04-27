package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningLottoTest {

    @Test
    fun `WinningLotto is created correctly with given numbers & bonus number`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        assertThat(winningLotto.numbers).isEqualTo(winningNumbers)
        assertThat(winningLotto.bonusNumber).isEqualTo(bonusNumber)
    }
}