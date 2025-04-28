package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StatisticsProviderTest {

    private val statisticsProvider = StatisticsProvider()

    @Test
    fun `provideStatistics calculates correct statistics for 3 winning numbers`() {
        val playedTickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
        )
        val winningNumbers = mutableListOf(1, 2, 3, 8, 9, 10)
        val bonusNumber = 7
        val spentAmount = 1000

        val resultStatistics = statisticsProvider.provideStatistics(
            playedTickets,
            winningNumbers,
            bonusNumber,
            spentAmount
        )

        assertThat(resultStatistics[0]).isEqualTo(1.0) // 3 matches
        assertThat(resultStatistics[1]).isEqualTo(0.0) // 4 matches
        assertThat(resultStatistics[2]).isEqualTo(0.0) // 5 matches
        assertThat(resultStatistics[3]).isEqualTo(0.0) // 5 matches + bonus
        assertThat(resultStatistics[4]).isEqualTo(0.0) // 6 matches
        assertThat(resultStatistics[5]).isEqualTo(5000.0 / 1000.0 * 100) // Return rate (%)
    }

    @Test
    fun `provideStatistics calculates correct statistics for 4 winning numbers`() {
        val playedTickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
        )
        val winningNumbers = mutableListOf(1, 2, 3, 4, 9, 10)
        val bonusNumber = 7
        val spentAmount = 1000

        val resultStatistics = statisticsProvider.provideStatistics(
            playedTickets,
            winningNumbers,
            bonusNumber,
            spentAmount
        )

        assertThat(resultStatistics[0]).isEqualTo(0.0) // 3 matches
        assertThat(resultStatistics[1]).isEqualTo(1.0) // 4 matches
        assertThat(resultStatistics[2]).isEqualTo(0.0) // 5 matches
        assertThat(resultStatistics[3]).isEqualTo(0.0) // 5 matches + bonus
        assertThat(resultStatistics[4]).isEqualTo(0.0) // 6 matches
        assertThat(resultStatistics[5]).isEqualTo(50_000.0 / 1000.0 * 100) // Return rate (%)
    }


    @Test
    fun `provideStatistics calculates correct statistics for 5 winning numbers`() {
        val playedTickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
        )
        val winningNumbers = mutableListOf(1, 2, 3, 4, 5, 10)
        val bonusNumber = 7
        val spentAmount = 1000

        val resultStatistics = statisticsProvider.provideStatistics(
            playedTickets,
            winningNumbers,
            bonusNumber,
            spentAmount
        )

        assertThat(resultStatistics[0]).isEqualTo(0.0) // 3 matches
        assertThat(resultStatistics[1]).isEqualTo(0.0) // 4 matches
        assertThat(resultStatistics[2]).isEqualTo(1.0) // 5 matches
        assertThat(resultStatistics[3]).isEqualTo(0.0) // 5 matches + bonus
        assertThat(resultStatistics[4]).isEqualTo(0.0) // 6 matches
        assertThat(resultStatistics[5]).isEqualTo(1_500_000.0 / 1000.0 * 100) // Return rate (%)
    }



    @Test
    fun `provideStatistics calculates correct statistics for 5 winning plus one bonus number`() {
        val playedTickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
        )
        val winningNumbers = mutableListOf(1, 2, 3, 4, 5, 10)
        val bonusNumber = 7
        val spentAmount = 1000

        val resultStatistics = statisticsProvider.provideStatistics(
            playedTickets,
            winningNumbers,
            bonusNumber,
            spentAmount
        )

        assertThat(resultStatistics[0]).isEqualTo(0.0) // 3 matches
        assertThat(resultStatistics[1]).isEqualTo(0.0) // 4 matches
        assertThat(resultStatistics[2]).isEqualTo(0.0) // 5 matches
        assertThat(resultStatistics[3]).isEqualTo(1.0) // 5 matches + bonus
        assertThat(resultStatistics[4]).isEqualTo(0.0) // 6 matches
        assertThat(resultStatistics[5]).isEqualTo(30_000_000.0 / 1000.0 * 100) // Return rate (%)
    }

    @Test
    fun `provideStatistics calculates correct statistics for 6 winning numbers`() {
        val playedTickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
        )
        val winningNumbers = mutableListOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val spentAmount = 1000

        val resultStatistics = statisticsProvider.provideStatistics(
            playedTickets,
            winningNumbers,
            bonusNumber,
            spentAmount
        )

        assertThat(resultStatistics[0]).isEqualTo(0.0) // 3 matches
        assertThat(resultStatistics[1]).isEqualTo(0.0) // 4 matches
        assertThat(resultStatistics[2]).isEqualTo(0.0) // 5 matches
        assertThat(resultStatistics[3]).isEqualTo(0.0) // 5 matches + bonus
        assertThat(resultStatistics[4]).isEqualTo(1.0) // 6 matches
        assertThat(resultStatistics[5]).isEqualTo(2_000_000_000.0 / 1000.0 * 100) // Return rate (%)
    }


}