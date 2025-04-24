package lotto

import lotto.domain.Bonus
import lotto.domain.Lotto
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
            Lotto(listOf(1, 2, 3, 4, 5, 6)), // 6 matches → 2,000,000,000 (if that's the rule)
            Lotto(listOf(2, 3, 4, 5, 6, 7)), // 5 + bonus → 30,000,000
            Lotto(listOf(3, 4, 5, 6, 7, 8))  // 5 matches → 1,500,000
        )

        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val bonus = Bonus(7)
        val lottoManager = LottoManager(lottos, winningLotto, bonus)

        // when
        val winningAmount = lottoManager.calculateWinningAmount()

        // then
        assertThat(winningAmount).isEqualTo(31550000) // example: 0 matches 6, 1 match 5+bonus, 1 match 5
    }
}