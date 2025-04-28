package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PrizeRankCalculatorTest {

    @Test
    fun `throws an exception when the winning lotto and the bonus number have a duplicate number`() {
        //given
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = createLotto(numbers)
        val bonusNumber = LottoNumber(4)
        // when & then
        assertThatThrownBy { PrizeRankCalculator(lotto, bonusNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Winning numbers and the bonus number should be unique.")
    }

    @Test
    fun `should calculate prize rank statistics for lotto tickets`() {
        // given
        val expectedFirst = createLotto(listOf(1, 2, 3, 4, 5, 6))
        val expectedSecond = createLotto(listOf(1, 2, 3, 4, 5, 10))
        val expectedThird = createLotto(listOf(1, 2, 3, 4, 5, 9))
        val expectedNone = createLotto(listOf(10, 11, 12, 13, 14, 15))
        val lottoTickets = listOf(expectedFirst, expectedSecond, expectedThird, expectedNone)

        val winningLotto = createLotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber(10)
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

    private fun createLotto(numbers: List<Int>): Lotto {
        return Lotto(
            listOf(
                LottoNumber(numbers[0]),
                LottoNumber(numbers[1]),
                LottoNumber(numbers[2]),
                LottoNumber(numbers[3]),
                LottoNumber(numbers[4]),
                LottoNumber(numbers[5])
            )
        )
    }
}
