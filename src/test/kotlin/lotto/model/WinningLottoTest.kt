package lotto.model

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningLottoTest {

    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7
    private val winningLotto = WinningLotto(winningNumbers, bonusNumber)

    @Test
    fun `matches returns the correct prize tier`() {
        val userLottoFirst = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val userLottoSecond = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val userLottoNone = Lotto(listOf(1, 2, 12, 13, 14, 15))

        val userLottoFirstPrize = winningLotto.match(userLottoFirst)
        val userLottoSecondPrize = winningLotto.match(userLottoSecond)
        val userLottoNonePrize = winningLotto.match(userLottoNone)

        assertThat(userLottoFirstPrize).isEqualTo(PrizeTier.FIRST)
        assertThat(userLottoSecondPrize).isEqualTo(PrizeTier.SECOND)
        assertThat(userLottoNonePrize).isEqualTo(PrizeTier.NONE)
    }

    @Test
    fun `different number orders still match correctly`() {
        val userLotto = Lotto(listOf(6, 3, 4, 1, 2, 5))

        val prize = winningLotto.match(userLotto)

        assertThat(prize).isEqualTo(PrizeTier.FIRST)
    }
}