import lotto.view.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

import camp.nextstep.edu.missionutils.test.NsTest

class InputViewTest {
    @Nested
    @DisplayName("getPurchaseAmount() Tests")
    inner class GetPurchaseAmountTest: NsTest() {

        override fun runMain() {
        }

        @Test
        @DisplayName("Should return correct integer when valid input is given")
        fun validInput() {
            run("8000\n")
            val result = InputView.getPurchaseAmount()
            assertThat(result).isEqualTo(8000)
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException when input is not a number")
        fun invalidNonNumericInput() {
            run("abc\n")
            assertThatThrownBy {InputView.getPurchaseAmount()}
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("[ERROR] Invalid input: 'abc' is not a positive number")
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException when input is empty")
        fun emptyInput() {
            run("\n")
            assertThatThrownBy {InputView.getPurchaseAmount()}
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("[ERROR] Invalid input: '' is not a positive number")
        }
    }
}