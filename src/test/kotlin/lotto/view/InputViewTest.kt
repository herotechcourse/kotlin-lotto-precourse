package lotto.view

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputValidationTest {

    // -------------------- Payment Tests --------------------

    @Test
    fun `payment should accept valid input`() {
        val result = InputValidation.payment("3000")
        assertThat(result).isEqualTo(3000)
    }

    @Test
    fun `payment should throw if non-numeric`() {
        assertThatThrownBy {
            InputValidation.payment("abc")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `payment should throw if negative or zero`() {
        assertThatThrownBy {
            InputValidation.payment("-1000")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")

        assertThatThrownBy {
            InputValidation.payment("0")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `payment should throw if not divisible by 1000`() {
        assertThatThrownBy {
            InputValidation.payment("1500")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `payment should throw if exceeding limit`() {
        assertThatThrownBy {
            InputValidation.payment("20000") // Assuming your limit is 10_000
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    // -------------------- Winning Numbers Tests --------------------

    @Test
    fun `winningNumbers should accept valid input`() {
        val lotto = InputValidation.winningNumbers("1,2,3,4,5,6")
        assertThat(lotto.getNumbers()).containsExactly(1,2,3,4,5,6)
    }

    @Test
    fun `winningNumbers should throw if no commas`() {
        assertThatThrownBy {
            InputValidation.winningNumbers("1 2 3 4 5 6 ")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `winningNumbers should throw if wrong format`() {
        assertThatThrownBy {
            InputValidation.winningNumbers("1, 2, 3, 4, 5, 6, ")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `winningNumbers should throw if invalid input found`() {
        assertThatThrownBy {
            InputValidation.winningNumbers("1,2,3,4,a,6")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `winningNumbers should throw if empty values`() {
        assertThatThrownBy {
            InputValidation.winningNumbers("1,2,,4,5,6")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    // -------------------- Bonus Number Tests --------------------

    @Test
    fun `bonusNumber should accept valid input`() {
        val winningLotto = Lotto(listOf(1,2,3,4,5,6))
        val bonus = InputValidation.bonusNumber("7", winningLotto)
        assertThat(bonus).isEqualTo(7)
    }

    @Test
    fun `bonusNumber should throw if non-numeric`() {
        val winningLotto = Lotto(listOf(1,2,3,4,5,6))
        assertThatThrownBy {
            InputValidation.bonusNumber("a", winningLotto)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `bonusNumber should throw if out of valid range`() {
        val winningLotto = Lotto(listOf(1,2,3,4,5,6))
        assertThatThrownBy {
            InputValidation.bonusNumber("50", winningLotto)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `bonusNumber should throw if bonus duplicates winning number`() {
        val winningLotto = Lotto(listOf(1,2,3,4,5,6))
        assertThatThrownBy {
            InputValidation.bonusNumber("5", winningLotto)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }
}
