import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.domain.LottoMachine
import lotto.view.messages.PromptMessages
import lotto.view.OutputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OutputViewTest : NsTest() {

    @Test
    fun `prints formatted ticket count message`() {
        assertSimpleTest {
            OutputView(LottoMachine(5000)).printTicketCount()

            val output = output()

            assertThat(output).contains(PromptMessages.TICKET_COUNT.with(5))
        }
    }

    @Test
    fun `prints lotto numbers correctly`() {
        assertSimpleTest {
            OutputView(LottoMachine(5000)).printLottoNumbers()

            val output = output()

            assertThat(output).contains("[")
            assertThat(output).contains("]")
            assertThat(output.lines().size).isEqualTo(5)
        }
    }

    @Test
    fun `prints winning statistics correctly`() {
        assertSimpleTest {

            val guess = setOf(1, 2, 3, 4, 5, 6)
            val bonus = 7

            OutputView(LottoMachine(5000)).printWinningStatistics(guess, bonus)

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
            OutputView(LottoMachine(5000)).printReturnRate()

            val out = output()

            assertThat(out).contains("%").contains(".")

        }
    }

    override fun runMain() {

    }
}
