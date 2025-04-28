package lotto.output

import lotto.Lotto
import lotto.process.LottoRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.math.BigDecimal

class OutputViewTest {
    private val outputView = OutputView()

    private val outputStreamCaptor = ByteArrayOutputStream()
    private val printStream = PrintStream(outputStreamCaptor)

    init {
        System.setOut(printStream)
    }

    @Test
    fun `generateLottoResult should print correct rank statistics`() {
        val lottoRanks = listOf(
            LottoRank.FIRST, LottoRank.SECOND, LottoRank.SECOND, LottoRank.THIRD,
            LottoRank.FOURTH, LottoRank.FIFTH, LottoRank.FIFTH, LottoRank.FIFTH
        )

        outputView.generateLottoResult(lottoRanks)
        val output = outputStreamCaptor.toString()

        assertThat(output).contains("6 Matches (2,000,000,000 KRW) – 1 tickets")
        assertThat(output).contains("5 Matches + Bonus Ball (30,000,000 KRW) – 2 tickets")
        assertThat(output).contains("5 Matches (1,500,000 KRW) – 1 tickets")
        assertThat(output).contains("4 Matches (50,000 KRW) – 1 tickets")
        assertThat(output).contains("3 Matches (5,000 KRW) – 3 tickets")
    }

    @Test
    fun `generateReturnRate should print correct return rate`() {
        val returnRate = BigDecimal("120.5")

        outputView.generateReturnRate(returnRate)
        val output = outputStreamCaptor.toString()

        assertThat(output).contains("Total return rate is 120.5%.")
    }

    @Test
    fun `displayTickets should print correct number of tickets and ticket details`() {
        val purchasedTickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12))
        )

        outputView.displayTickets(purchasedTickets)
        val output = outputStreamCaptor.toString()

        assertThat(output).contains("You have purchased 2 tickets.")
        assertThat(output).contains("[1, 2, 3, 4, 5, 6]")
        assertThat(output).contains("[7, 8, 9, 10, 11, 12]")
    }
}