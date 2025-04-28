import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.Lotto
import lotto.view.messages.PromptMessages
import lotto.view.OutputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OutputViewTest : NsTest() {

    @Test
    fun `prints formatted ticket count message`() {
        assertSimpleTest {
            OutputView().printTicketCount(5)

            val output = output()

            assertThat(output).contains(PromptMessages.TICKET_COUNT.with(5))
        }
    }

    @Test
    fun `prints lotto numbers correctly`() {
        assertSimpleTest {
            val tickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
            OutputView().printLottoNumbers(tickets)

            val output = output()

            assertThat(output).contains("[")
            assertThat(output).contains("]")
            assertThat(output.lines().size).isEqualTo(1)
        }
    }

    @Test
    fun `prints winning statistics correctly`() {
        assertSimpleTest {

            val ranks = listOf(0, 2, 0, 0, 0, 0)

            OutputView().printWinningStatistics(ranks)

            val out = output()

            assertThat(out).contains(PromptMessages.WINNING_STATISTICS.message)
            assertThat(out).contains("---")
            assertThat(out.lines().size).isEqualTo(7)
            assertThat(out).contains("tickets").contains("Matches")
        }
    }

    @Test
    fun `prints return rate in correct format`() {
        assertSimpleTest {
            OutputView().printReturnRate(50.0)

            val out = output()

            assertThat(out).contains("%").contains(".")

        }
    }

    override fun runMain() {

    }
}
