import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.LottoMachine
import lotto.view.OutputView
import lotto.messages.PromptMessages
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

    override fun runMain() {

    }
}
