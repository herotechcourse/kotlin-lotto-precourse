package lotto.view

import lotto.Lotto
import lotto.LottoTickets
import lotto.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class LottoViewFormatterTest {

    @Nested
    inner class LottoTickets {

        private val lottoTickets: List<Lotto> = listOf(
            Lotto(listOf(8, 21, 23, 41, 42, 43)),
            Lotto(listOf(3, 5, 11, 16, 32, 38))
        )

        @Test
        fun `formatPurchaseMessage should return ticket count message`() {
            // Act
            val result = LottoViewFormatter.formatPurchaseMessage(lottoTickets)

            // Assert
            assertThat(result).isEqualTo("You have purchased 2 tickets.")
        }


        @Test
        fun `formatLottoTickets should return sorted number lines`() {
            // Act
            val result = LottoViewFormatter.formatLottoTickets(lottoTickets)

            // Assert
            assertThat(result).isEqualTo(
                """
                [8, 21, 23, 41, 42, 43]
                [3, 5, 11, 16, 32, 38]
            """.trimIndent()
            )
        }

    }

    @Test
    fun `formatWinningStatistics should return formatted lines in prize order`() {
        // Arrange
        val rankCounts = mapOf(
            Rank.FIFTH to 1,
            Rank.THIRD to 2,
            Rank.FOURTH to 3
        )

        // Act
        val result = LottoViewFormatter.formatWinningStatistics(rankCounts)

        // Assert
        assertThat(result).contains(
            """
                3 Matches (5,000 KRW) – 1 tickets
                4 Matches (50,000 KRW) – 3 tickets
                5 Matches (1,500,000 KRW) – 2 tickets
            """.trimIndent()
        )

    }

    @Test
    fun `formatProfitRate should return formatted profit percentage`() {
        // Arrange
        val profitRate = 127.54

        // Act
        val result = LottoViewFormatter.formatProfitRate(profitRate)

        // Assert
        assertThat(result).isEqualTo("Total return rate is 127.5%.")
    }
}
