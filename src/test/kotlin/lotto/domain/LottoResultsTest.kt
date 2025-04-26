package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultsTest {

    @Test
    fun `countOf returns correct count for each prize`() {
        // given
        val results = LottoResults(
            listOf(
                LottoMatchResult(6, false),
                LottoMatchResult(5, true),
                LottoMatchResult(5, true),
                LottoMatchResult(5, false),
                LottoMatchResult(4, false),
                LottoMatchResult(3, false),
                LottoMatchResult(3, false),
                LottoMatchResult(0, false)
            )
        )

        // when & then
        assertThat(results.countOf(Prize.FIRST)).isEqualTo(1)
        assertThat(results.countOf(Prize.SECOND)).isEqualTo(2)
        assertThat(results.countOf(Prize.THIRD)).isEqualTo(1)
        assertThat(results.countOf(Prize.FOURTH)).isEqualTo(1)
        assertThat(results.countOf(Prize.FIFTH)).isEqualTo(2)
        assertThat(results.countOf(Prize.NONE)).isEqualTo(1)
    }

    @Test
    fun `toResultLines returns correct descriptions and counts`() {
        // given
        val results = LottoResults(
            listOf(
                LottoMatchResult(6, false),
                LottoMatchResult(5, true),
                LottoMatchResult(5, false),
                LottoMatchResult(4, false),
                LottoMatchResult(3, false)
            )
        )

        // when
        val resultLines = results.toResultLines()

        // then
        assertThat(resultLines).hasSize(5)

        assertThat(resultLines[0].description).isEqualTo(Prize.FIFTH.description)
        assertThat(resultLines[0].count).isEqualTo(1)

        assertThat(resultLines[1].description).isEqualTo(Prize.FOURTH.description)
        assertThat(resultLines[1].count).isEqualTo(1)

        assertThat(resultLines[2].description).isEqualTo(Prize.THIRD.description)
        assertThat(resultLines[2].count).isEqualTo(1)

        assertThat(resultLines[3].description).isEqualTo(Prize.SECOND.description)
        assertThat(resultLines[3].count).isEqualTo(1)

        assertThat(resultLines[4].description).isEqualTo(Prize.FIRST.description)
        assertThat(resultLines[4].count).isEqualTo(1)
    }
}
