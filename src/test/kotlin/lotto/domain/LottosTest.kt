package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {

    @Test
    fun `matchAgainst returns correct LottoResults for multiple lottos`() {
        // given
        val lottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(1, 2, 3, 4, 5, 7)),
                Lotto(listOf(1, 2, 3, 4, 8, 9)),
                Lotto(listOf(1, 2, 3, 10, 11, 12)),
                Lotto(listOf(1, 2, 13, 14, 15, 16))
            )
        )

        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7)

        // when
        val results = lottos.matchAgainst(winningNumbers, bonusNumber)

        // then
        assertThat(results.countOf(Prize.FIRST)).isEqualTo(1)
        assertThat(results.countOf(Prize.SECOND)).isEqualTo(1)
        assertThat(results.countOf(Prize.FOURTH)).isEqualTo(1)
        assertThat(results.countOf(Prize.FIFTH)).isEqualTo(1)
        assertThat(results.countOf(Prize.NONE)).isEqualTo(1)
    }
}
