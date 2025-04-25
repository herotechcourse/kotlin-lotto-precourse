import lotto.Lotto
import lotto.domain.Rank
import lotto.domain.WinningNumber
import lotto.domain.WinningResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningResultTest {

    @Test
    fun `Given multiple lottos When compared with winning numbers Then returns the count of each rank`() {
        // given
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)), // 6 matches - 1st rank
            Lotto(listOf(1, 2, 3, 4, 5, 7)), // 5 matches + bonus - 2nd rank
            Lotto(listOf(1, 2, 3, 4, 5, 8)), // 5 matches - 3rd rank
            Lotto(listOf(1, 2, 3, 4, 10, 11)), // 4 matches - 4th rank
            Lotto(listOf(1, 2, 3, 9, 10, 11)), // 3 matches - 5th rank
            Lotto(listOf(20, 21, 22, 23, 24, 25)) // 0 matches - no prize
        )

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val winningNumber = WinningNumber(winningNumbers, bonusNumber)

        // when
        val result = WinningResult.of(lottos, winningNumber)

        // then
        assertThat(result.getCountOf(Rank.FIRST)).isEqualTo(1)
        assertThat(result.getCountOf(Rank.SECOND)).isEqualTo(1)
        assertThat(result.getCountOf(Rank.THIRD)).isEqualTo(1)
        assertThat(result.getCountOf(Rank.FOURTH)).isEqualTo(1)
        assertThat(result.getCountOf(Rank.FIFTH)).isEqualTo(1)
        assertThat(result.getCountOf(Rank.NONE)).isEqualTo(1)
    }
}
