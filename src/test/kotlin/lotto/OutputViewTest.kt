import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.LottoMachine
import lotto.messages.PromptMessages
import lotto.view.OutputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OutputViewTest : NsTest() {

    @Test
    fun `prints formatted ticket count message`() {
        assertSimpleTest {
            OutputView().printTicketCount(LottoMachine(5000))
            val output = output()
            assertThat(output).contains(PromptMessages.TICKET_COUNT.with(5))
        }
    }

    @Test
    fun `prints lotto numbers correctly`() {
        assertSimpleTest {
            val machine = LottoMachine(5000)
            OutputView().printLottoNumbers(machine)

            val output = output()

            assertThat(output).contains("[")
            assertThat(output).contains("]")
            assertThat(output.lines().size).isEqualTo(5)
        }
    }

    override fun runMain() {

    }
}
