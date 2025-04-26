package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MatchCalculatorTest {
    @BeforeEach
    fun resetMatch() {
        MATCH.THREE = 0
        MATCH.FOUR = 0
        MATCH.FIVE = 0
        MATCH.FIVE_AND_BONUS = 0
        MATCH.SIX = 0
    }

    @Test
    fun `should calculate match counts correctly`() {
        val lottoNumber =
            listOf(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(3, 5, 6, 16, 32, 38),
                listOf(7, 11, 16, 35, 36, 44),
            )
        val winningNumbers = listOf("1", "2", "3", "4", "5", "6")
        val bonusNumber = "7"

        MatchCalculator.run(lottoNumber, winningNumbers, bonusNumber)

        assertThat(MATCH.THREE).isEqualTo(1)
        assertThat(MATCH.FOUR).isEqualTo(0)
        assertThat(MATCH.FIVE).isEqualTo(0)
        assertThat(MATCH.FIVE_AND_BONUS).isEqualTo(0)
        assertThat(MATCH.SIX).isEqualTo(1)
    }

    @Test
    fun `should calculate five and bonus match counts correctly`() {
        val lottoNumber = listOf(listOf(1, 2, 3, 4, 5, 40))
        val winningNumbers = listOf("1", "2", "3", "4", "5", "7")
        val bonusNumber = "40"

        MatchCalculator.run(lottoNumber, winningNumbers, bonusNumber)

        assertThat(MATCH.THREE).isEqualTo(0)
        assertThat(MATCH.FOUR).isEqualTo(0)
        assertThat(MATCH.FIVE).isEqualTo(0)
        assertThat(MATCH.FIVE_AND_BONUS).isEqualTo(1)
        assertThat(MATCH.SIX).isEqualTo(0)
    }
}
