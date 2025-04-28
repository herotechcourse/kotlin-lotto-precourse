package lotto.model

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningCheckerTest {
    private val winningChecker = WinningChecker()

    @Test
    fun `winning checker can count the winning lottos`() {
        // given
        val userLottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(2, 3, 4, 5, 6, 7)),
            Lotto(listOf(2, 3, 4, 5, 6, 8)),
        )
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7

        // when
        val actual = winningChecker.countMatches(userLottos, winningLotto, bonusNumber)

        // then
        val expected = mapOf(
            Rank.FIRST to 1,
            Rank.SECOND to 1,
            Rank.THIRD to 1,
            Rank.FOURTH to 0,
            Rank.FIFTH to 0,
        )
        assertThat(actual).isEqualTo(expected)
    }
}
