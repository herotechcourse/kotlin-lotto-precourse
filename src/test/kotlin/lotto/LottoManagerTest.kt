package lotto

import lotto.domain.Bonus
import lotto.domain.LottoManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoManagerTest {

    @DisplayName("Calculate total winnings from all lotto tickets.")
    @Test
    fun `should calculate total winning amount`() {
        // given
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(2, 3, 4, 5, 6, 7)),
            Lotto(listOf(3, 4, 5, 6, 7, 8))
        )

        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val bonus = Bonus(7)
        val lottoManager = LottoManager(lottos, winningLotto, bonus)

        // when
        val winningAmount = lottoManager.calculateWinningAmount()

        // then
        assertThat(winningAmount).isEqualTo(31550000)
    }
}