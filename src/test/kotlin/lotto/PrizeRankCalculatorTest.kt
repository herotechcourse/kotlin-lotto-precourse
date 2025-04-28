package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PrizeRankCalculatorTest {

    @Test
    fun `throws an exception when the winning lotto and the bonus number have a duplicate number`() {
        //given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 4
        // when & then
        assertThatThrownBy { PrizeRankCalculator(lotto, bonusNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Winning numbers and the bonus number should be unique.")
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46])
    fun `throw exception when the bonus number is out of range`(bonusNumber: Int) {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        // when & then
        assertThatThrownBy { PrizeRankCalculator(lotto, bonusNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Number must be between $MIN_RANGE and $MAX_RANGE.")
    }

    @Test
    fun `should calculate prize rank statistics for lotto tickets`() {
        // given
        val expectedFirst = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val expectedSecond = Lotto(listOf(1, 2, 3, 4, 5, 10))
        val expectedThird = Lotto(listOf(1, 2, 3, 4, 5, 9))
        val expectedNone = Lotto(listOf(10, 11, 12, 13, 14, 15))
        val lottoTickets = listOf(expectedFirst, expectedSecond, expectedThird, expectedNone)

        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 10
        val prizeRankCalculator = PrizeRankCalculator(winningLotto, bonusNumber)
        // when
        val statistics = prizeRankCalculator.calculateStatistics(lottoTickets)
        // then
        assertAll(
            { assertThat(statistics.statistics()[PrizeRank.FIRST]).isEqualTo(1) },
            { assertThat(statistics.statistics()[PrizeRank.SECOND]).isEqualTo(1) },
            { assertThat(statistics.statistics()[PrizeRank.THIRD]).isEqualTo(1) },
            { assertThat(statistics.statistics()[PrizeRank.FOURTH]).isEqualTo(0) },
            { assertThat(statistics.statistics()[PrizeRank.FIFTH]).isEqualTo(0) },
            { assertThat(statistics.statistics()[PrizeRank.NONE]).isEqualTo(1) }
        )
    }

    companion object {
        private const val MIN_RANGE: Int = 1
        private const val MAX_RANGE: Int = 45
    }
}
