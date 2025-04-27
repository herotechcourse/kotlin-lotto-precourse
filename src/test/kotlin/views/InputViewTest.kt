package views

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputViewTest {

    class TestableInputView(private val inputs: List<String>) : InputView() {
        private var index = 0

        override fun readLineFromConsole(): String? {
            return if (index < inputs.size) inputs[index++] else null
        }
    }

    @Test
    fun `getPurchaseAmount should return valid amount`() {
        val inputView = TestableInputView(listOf("5000"))
        val amount = inputView.getPurchaseAmount()
        assertThat(amount).isEqualTo(5000)
    }

    @Test
    fun `getPurchaseAmount should return 0 on invalid input`() {
        val inputView = TestableInputView(listOf("abc"))
        val amount = inputView.getPurchaseAmount()
        assertThat(amount).isEqualTo(0)
    }

    @Test
    fun `getWinningNumbers should return valid list`() {
        val inputView = TestableInputView(listOf("1, 2, 3, 4, 5, 6"))
        val winningNumbers = inputView.getWinningNumbers()
        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `getWinningNumbers should return empty list on invalid input`() {
        val inputView = TestableInputView(listOf("1,2,3"))
        val winningNumbers = inputView.getWinningNumbers()
        assertThat(winningNumbers).isEmpty()
    }

    @Test
    fun `getBonusNumber should return valid bonus`() {
        val inputView = TestableInputView(listOf("7"))
        val bonus = inputView.getBonusNumber()
        assertThat(bonus).isEqualTo(7)
    }

    @Test
    fun `getBonusNumber should return 0 on invalid bonus`() {
        val inputView = TestableInputView(listOf("50"))
        val bonus = inputView.getBonusNumber()
        assertThat(bonus).isEqualTo(0)
    }
}
