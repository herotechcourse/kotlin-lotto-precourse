package views

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
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
    fun `getPurchaseAmount should throw exception on invalid input - letters`() {
        assertThrows<IllegalArgumentException> {
            val inputView = TestableInputView(listOf("abc"))
            val amount = inputView.getPurchaseAmount()
        }
    }

    @Test
    fun `getPurchaseAmount should throw exception on invalid input - negative`() {
        assertThrows<IllegalArgumentException> {
            val inputView = TestableInputView(listOf("-3"))
            val amount = inputView.getPurchaseAmount()
        }
    }

    @Test
    fun `getWinningNumbers should return valid list`() {
        val inputView = TestableInputView(listOf("1, 2, 3, 4, 5, 6"))
        val winningNumbers = inputView.getWinningNumbers()
        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `getWinningNumbers should throw exception on invalid input - small set`() {
        assertThrows<IllegalArgumentException> {
            val inputView = TestableInputView(listOf("1,2,3"))
            val winningNumbers = inputView.getWinningNumbers()
        }
    }

    @Test
    fun `getWinningNumbers should throw exception on invalid input - negative number`() {
        assertThrows<IllegalArgumentException> {
            val inputView = TestableInputView(listOf("1,2,3,4,5,-1"))
            val winningNumbers = inputView.getWinningNumbers()
        }
    }

    @Test
    fun `getWinningNumbers should throw exception on invalid input - repeated numbers`() {
        assertThrows<IllegalArgumentException> {
            val inputView = TestableInputView(listOf("1,2,3,4,5,5"))
            val winningNumbers = inputView.getWinningNumbers()
        }
    }

    @Test
    fun `getWinningNumbers should throw exception on invalid input - big number`() {
        assertThrows<IllegalArgumentException> {
            val inputView = TestableInputView(listOf("1,2,3,4,5,55"))
            val winningNumbers = inputView.getWinningNumbers()
        }
    }

    @Test
    fun `getWinningNumbers should throw exception on invalid input - null`() {
        assertThrows<IllegalArgumentException> {
            val inputView = TestableInputView(listOf())
            val winningNumbers = inputView.getWinningNumbers()
        }
    }

    @Test
    fun `getWinningNumbers should throw exception on invalid input - empty number`() {
        assertThrows<IllegalArgumentException> {
            val inputView = TestableInputView(listOf("1,2,,4,5,6"))
            val winningNumbers = inputView.getWinningNumbers()
        }
    }

    @Test
    fun `getBonusNumber should return valid bonus`() {
        val inputView = TestableInputView(listOf("7"))
        val bonus = inputView.getBonusNumber()
        assertThat(bonus).isEqualTo(7)
    }

    @Test
    fun `getBonusNumber should throw exception on invalid bonus - big number`() {
        assertThrows<IllegalArgumentException> {
            val inputView = TestableInputView(listOf("50"))
            val bonus = inputView.getBonusNumber()
        }
    }

    @Test
    fun `getBonusNumber should throw exception on invalid bonus - negative number`() {
        assertThrows<IllegalArgumentException> {
            val inputView = TestableInputView(listOf("-10"))
            val bonus = inputView.getBonusNumber()
        }
    }

    @Test
    fun `getBonusNumber should throw exception on invalid bonus - null`() {
        assertThrows<IllegalArgumentException> {
            val inputView = TestableInputView(listOf())
            val bonus = inputView.getBonusNumber()
        }
    }

    @Test
    fun `getBonusNumber should throw exception on invalid bonus - letter`() {
        assertThrows<IllegalArgumentException> {
            val inputView = TestableInputView(listOf("abc"))
            val bonus = inputView.getBonusNumber()
        }
    }
}
