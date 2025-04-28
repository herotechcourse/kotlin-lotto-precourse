package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoPromptTest : NsTest() {
    @Test
    fun `get unlisted user messages message`() {
        assertSimpleTest {
            run()
            LottoPrompt.printMessageToUser("none", "")
            assertThat(output()).isBlank()
        }
    }

    @Test
    fun `print listed user messages test`() = userMessages.forEach {
        val expectedMessage = it.value
        assertSimpleTest {
            run()
            LottoPrompt.printMessageToUser(it.key, "[PLACEHOLDER1]")
            assertThat(output()).contains(expectedMessage)
        }
    }

    override fun runMain() {
    }

    companion object {
        private val userMessages: Map<String, String> = mapOf(
            "purchaseAmount" to "Please enter the purchase amount.",
            "winningNumbers" to "Please enter last week's winning numbers.",
            "bonusNumber" to "Please enter the bonus number.",
            "PRINT_PURCHASED_TICKETS" to "You have purchased [PLACEHOLDER1] tickets.",
            "PRINT_WINNING_STATISTICS_HEADER" to "Winning Statistics\n---",
            "PRINT_RETURN_RATE" to "Total return rate is [PLACEHOLDER1]%."
        )
    }
}