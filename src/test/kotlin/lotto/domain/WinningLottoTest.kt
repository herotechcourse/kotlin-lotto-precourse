package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningLottoTest {
    private val winningNumbers = listOf(1,2,3,4,5,6)
    private val bonusNumber = 7

    private val winningLotto = WinningLotto(winningNumbers, bonusNumber)

    @Test
    fun `should return valid match result`() {
        val purchasedLotto = Lotto(listOf(1,2,3,4,5,7))

        val result = winningLotto.match(purchasedLotto)

        assertThat(result.matchCnt).isEqualTo(5)
        assertThat(result.hasBonus).isTrue()
    }
}