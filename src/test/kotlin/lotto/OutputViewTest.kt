package lotto

import lotto.domain.Rank
import lotto.view.OutputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {
    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    @DisplayName("printLottos should display the number of tickets and their numbers")
    fun printLottos_DisplaysTicketsCorrectly() {
        // given
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12))
        )

        // when
        OutputView.printLottos(lottos)
        val output = outputStreamCaptor.toString().trim()

        // then
        assertThat(output).contains("You have purchased 2 tickets.")
        assertThat(output).contains("[1, 2, 3, 4, 5, 6]")
        assertThat(output).contains("[7, 8, 9, 10, 11, 12]")
    }

    @Test
    @DisplayName("printWinningStatistics should display all ranks with proper formatting")
    fun printWinningStatistics_DisplaysStatisticsCorrectly() {
        // given
        val rankCounts = mapOf(
            Rank.FIFTH to 1,
            Rank.THIRD to 2,
            Rank.FIRST to 3,
            Rank.NONE to 10
        )
        val totalAmount = 14000

        // when
        OutputView.printWinningStatistics(rankCounts, totalAmount)
        val output = outputStreamCaptor.toString().trim()

        // then
        assertThat(output).contains("Winning Statistics")
        assertThat(output).contains("---")
        assertThat(output).contains("3 Matches (5,000 KRW) \u2013 3 tickets")
        assertThat(output).contains("4 Matches (50,000 KRW) \u2013 0 tickets")
        assertThat(output).contains("5 Matches (1,500,000 KRW) \u2013 2 tickets")
        assertThat(output).contains("5 Matches + Bonus Ball (30,000,000 KRW) \u2013 0 tickets")
        assertThat(output).contains("6 Matches (2,000,000,000 KRW) \u2013 1 tickets")
    }

    @Test
    @DisplayName("printWinningStatistics should calculate return rate correctly")
    fun printWinningStatistics_CalculatesReturnRateCorrectly() {
        // given
        val rankCounts = mapOf(
            Rank.FIFTH to 1,
            Rank.THIRD to 1
        )
        val totalAmount = 10000 // 10,000 KRW

        // when
        OutputView.printWinningStatistics(rankCounts, totalAmount)
        val output = outputStreamCaptor.toString().trim()

        // Total prize: 2,000,000,000 + 1,500,000 = 2,001,500,000
        // Return rate: 2,001,500,000 / 10,000 * 100 = 20,015,000%

        // then
        assertThat(output).contains("Total return rate is 20015000.0%.")
    }

    @Test
    @DisplayName("printWinningStatistics should handle empty rank counts")
    fun printWinningStatistics_WithEmptyRankCounts_ShowsZeroCounts() {
        // given
        val rankCounts = mapOf<Rank, Int>()
        val totalAmount = 8000

        // when
        OutputView.printWinningStatistics(rankCounts, totalAmount)
        val output = outputStreamCaptor.toString().trim()

        // then
        assertThat(output).contains("3 Matches (5,000 KRW) \u2013 0 tickets")
        assertThat(output).contains("4 Matches (50,000 KRW) \u2013 0 tickets")
        assertThat(output).contains("5 Matches (1,500,000 KRW) \u2013 0 tickets")
        assertThat(output).contains("5 Matches + Bonus Ball (30,000,000 KRW) \u2013 0 tickets")
        assertThat(output).contains("6 Matches (2,000,000,000 KRW) \u2013 0 tickets")
        assertThat(output).contains("Total return rate is 0.0%.")
    }

    @Test
    @DisplayName("printWinningStatistics should format return rate with one decimal place")
    fun printWinningStatistics_FormatsReturnRateWithOneDecimalPlace() {
        // given
        val rankCounts = mapOf(
            Rank.FIRST to 3 // 3 * 5,000 = 15,000 KRW
        )
        val totalAmount = 8000 // 8,000 KRW

        // when
        OutputView.printWinningStatistics(rankCounts, totalAmount)
        val output = outputStreamCaptor.toString().trim()

        // Return rate: 15,000 / 8,000 * 100 = 187.5%

        // then
        assertThat(output).contains("Total return rate is 187.5%.")
    }
}