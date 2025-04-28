package lotto
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PrintingFunctionalityClassTest : NsTest() {

    override fun runMain() {
    }

    @Test
    fun `test printLottoTickets with multiple tickets`() {
        val lottoTickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12)),
            Lotto(listOf(13, 14, 15, 16, 17, 18))
        )
        val printingFunctionality = PrintingFunctionalityClass()
        run {
            printingFunctionality.printLottoTickets(lottoTickets)
            assertThat(output()).contains(
                "You have purchased 3 tickets.",
                "[1, 2, 3, 4, 5, 6]",
                "[7, 8, 9, 10, 11, 12]",
                "[13, 14, 15, 16, 17, 18]"
            )
        }
    }

    @Test
    fun `test printLottoTickets with a single ticket`() {
        val lottoTickets = listOf(Lotto(listOf(19, 20, 21, 22, 23, 24)))
        val printingFunctionality = PrintingFunctionalityClass()
        run {
            printingFunctionality.printLottoTickets(lottoTickets)
            assertThat(output()).contains(
                "You have purchased 1 tickets.",
                "[19, 20, 21, 22, 23, 24]"
            )
        }
    }

    @Test
    fun `test printFinalResults with various statistics`() {
        val statistics = mutableListOf(1.0, 2.0, 3.0, 4.0, 5.0, 123.456000000900090909090909)
        val printingFunctionality = PrintingFunctionalityClass()
        run {
            printingFunctionality.printFinalResults(statistics)
            assertThat(output()).contains(
                "Winning Statistics\n---",
                "3 Matches (5,000 KRW) – 1 tickets",
                "4 Matches (50,000 KRW) – 2 tickets",
                "5 Matches (1,500,000 KRW) – 3 tickets",
                "5 Matches + Bonus Ball (30,000,000 KRW) – 4 tickets",
                "6 Matches (2,000,000,000 KRW) – 5 tickets",
                "Total return rate is 123.5%."
            )
        }
    }

    @Test
    fun `test printFinalResults with zero matches`() {
        val statistics = mutableListOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.00000000)
        val printingFunctionality = PrintingFunctionalityClass()
        run {
            printingFunctionality.printFinalResults(statistics)
            assertThat(output()).contains(
                "Winning Statistics\n---",
                "3 Matches (5,000 KRW) – 0 tickets",
                "4 Matches (50,000 KRW) – 0 tickets",
                "5 Matches (1,500,000 KRW) – 0 tickets",
                "5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets",
                "6 Matches (2,000,000,000 KRW) – 0 tickets",
                "Total return rate is 0.0%."
            )
        }
    }

    @Test
    fun `test printFinalResults with a different return rate`() {
        val statistics = mutableListOf(10.0, 5.0, 2.0, 1.0, 0.0, 99.9)
        val printingFunctionality = PrintingFunctionalityClass()
        run {
            printingFunctionality.printFinalResults(statistics)
            assertThat(output()).contains(
                "Winning Statistics\n---",
                "3 Matches (5,000 KRW) – 10 tickets",
                "4 Matches (50,000 KRW) – 5 tickets",
                "5 Matches (1,500,000 KRW) – 2 tickets",
                "5 Matches + Bonus Ball (30,000,000 KRW) – 1 tickets",
                "6 Matches (2,000,000,000 KRW) – 0 tickets",
                "Total return rate is 99.9%."
            )
        }
    }
}
