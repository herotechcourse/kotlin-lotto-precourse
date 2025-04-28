package lotto.model

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MatchCalculatorTest {
    @BeforeEach
    fun resetMatch() {
        Match.threeCount = 0
        Match.fourCount = 0
        Match.fiveCount = 0
        Match.fiveAndBonusCount = 0
        Match.sixCount = 0
    }

    @Test
    fun `should calculate Match counts correctly`() {
        val totalLottoTicket = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(3, 5, 6, 16, 32, 38)),
            Lotto(listOf(7, 11, 16, 35, 36, 44)),
        )
        val winningNumbers = listOf("1", "2", "3", "4", "5", "6")
        val bonusNumber = "7"

        MatchCalculator.calculate(totalLottoTicket, winningNumbers, bonusNumber)

        assertThat(Match.threeCount).isEqualTo(1)
        assertThat(Match.fourCount).isEqualTo(0)
        assertThat(Match.fiveCount).isEqualTo(0)
        assertThat(Match.fiveAndBonusCount).isEqualTo(0)
        assertThat(Match.sixCount).isEqualTo(1)
    }

    @Test
    fun `should calculate five and bonus Match counts correctly`() {
        val lottoNumber = listOf(Lotto(listOf(1, 2, 3, 4, 5, 40)))
        val winningNumbers = listOf("1", "2", "3", "4", "5", "7")
        val bonusNumber = "40"

        MatchCalculator.calculate(lottoNumber, winningNumbers, bonusNumber)

        assertThat(Match.threeCount).isEqualTo(0)
        assertThat(Match.fourCount).isEqualTo(0)
        assertThat(Match.fiveCount).isEqualTo(0)
        assertThat(Match.fiveAndBonusCount).isEqualTo(1)
        assertThat(Match.sixCount).isEqualTo(0)
    }
}
