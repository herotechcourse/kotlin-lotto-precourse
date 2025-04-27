package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGameResultsTest : NsTest() {
    @Test
    fun `results should count no matches correctly`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                val game = LottoGame(3000u, listOf(1, 2, 3, 4, 5, 6), 7, 3)
                val results = game.getResults()

                assertThat(results[MatchCategory.SIX_MATCHES]).isEqualTo(0)
            },
            // random tickets with no matches
            listOf(11, 12, 13, 14, 15, 16),
            listOf(15, 16, 17, 18, 19, 20),
            listOf(16, 26, 36, 42, 43, 45),
        )
    }

    @Test
    fun `results should count three matches correctly`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                val game = LottoGame(4000u, listOf(1, 2, 3, 4, 5, 6), 7, 4)
                val results = game.getResults()

                assertThat(results[MatchCategory.THREE_MATCHES]).isEqualTo(1)
            },
            listOf(1, 2, 3, 14, 15, 16),
            // random tickets with no matches
            listOf(11, 12, 13, 14, 15, 16),
            listOf(15, 16, 17, 18, 19, 20),
            listOf(16, 26, 36, 42, 43, 45)
        )
    }

    @Test
    fun `results should count four matches correctly`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                val game = LottoGame(4000u, listOf(1, 2, 3, 4, 5, 6), 7, 4)
                val results = game.getResults()

                assertThat(results[MatchCategory.FOUR_MATCHES]).isEqualTo(1)
            },
            listOf(1, 2, 3, 4, 15, 16),
            // random tickets with no matches
            listOf(11, 12, 13, 14, 15, 16),
            listOf(15, 16, 17, 18, 19, 20),
            listOf(16, 26, 36, 42, 43, 45)
        )
    }

    @Test
    fun `results should count five matches correctly`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                val game = LottoGame(4000u, listOf(1, 2, 3, 4, 5, 6), 7, 4)
                val results = game.getResults()

                assertThat(results[MatchCategory.FIVE_MATCHES]).isEqualTo(1)
            },
            listOf(1, 2, 3, 4, 5, 16),
            // random tickets with no matches
            listOf(11, 12, 13, 14, 15, 16),
            listOf(15, 16, 17, 18, 19, 20),
            listOf(16, 26, 36, 42, 43, 45)
        )
    }

    @Test
    fun `results should count five matches and bonus correctly`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                val game = LottoGame(4000u, listOf(1, 2, 3, 4, 5, 6), 7, 4)
                val results = game.getResults()

                assertThat(results[MatchCategory.FIVE_MATCHES_AND_BONUS]).isEqualTo(1)
            },
            listOf(1, 2, 3, 4, 5, 7),
            // random tickets with no matches
            listOf(11, 12, 13, 14, 15, 16),
            listOf(15, 16, 17, 18, 19, 20),
            listOf(16, 26, 36, 42, 43, 45)
        )
    }

    @Test
    fun `results should count six matches correctly`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                val game = LottoGame(4000u, listOf(1, 2, 3, 4, 5, 6), 7, 4)
                val results = game.getResults()

                assertThat(results[MatchCategory.SIX_MATCHES]).isEqualTo(1)
            },
            listOf(1, 2, 3, 4, 5, 6),
            // random tickets with no matches
            listOf(11, 12, 13, 14, 15, 16),
            listOf(15, 16, 17, 18, 19, 20),
            listOf(16, 26, 36, 42, 43, 45)
        )
    }

    override fun runMain() {
    }
}
