import lotto.view.InputView
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

import camp.nextstep.edu.missionutils.test.NsTest

class InputViewTest {
    @Nested
    @DisplayName("getPurchaseAmount() Tests")
    inner class GetPurchaseAmountTest : NsTest() {

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
            assertThatThrownBy { InputView.getPurchaseAmount() }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("[ERROR] Invalid input: 'abc'. Please enter a positive number without any letters or symbols.")
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException when input is empty")
        fun emptyInput() {
            run("\n")
            assertThatThrownBy { InputView.getPurchaseAmount() }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("[ERROR] Invalid input: ''. Please enter a positive number without any letters or symbols.")
        }
    }

    @Nested
    @DisplayName("getWinningNumbers() Tests")
    inner class GetWinningNumbersTest : NsTest() {

        override fun runMain() {}

        @Test
        @DisplayName("Should correctly parse valid comma separated numbers")
        fun validWinningNumbers() {
            run("1, 2, 3, 4, 5, 6")
            val numbers = InputView.getWinningNumbers()
            assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6)
        }

        @Test
        @DisplayName("Should throw exception when non-numeric values are provided")
        fun invalidNonNumericInput() {
            run("1, 2, abc, 4, 5, 6")

            assertThatThrownBy { InputView.getWinningNumbers() }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("Please enter 6 unique numbers separated by commas (e.g., 1,2,3,4,5,6)")
        }

        @Test
        @DisplayName("Should throw exception when input is empty")
        fun emptyInput() {
            run("\n")

            assertThatThrownBy { InputView.getWinningNumbers() }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("Please enter 6 unique numbers separated by commas (e.g., 1,2,3,4,5,6)")
        }

        @Test
        @DisplayName("Should trim spaces around numbers and parse correctly")
        fun inputWithExtraSpaces() {
            run(" 1 , 2 , 3 , 4 , 5 , 6 ")

            val numbers = InputView.getWinningNumbers()
            assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6)
        }
    }

    @Nested
    @DisplayName("getBonusNumber() Tests")
    inner class GetBonusNumberTest : NsTest() {

        override fun runMain() {}

        @Test
        @DisplayName("Should correctly parse a valid bonus number")
        fun validBonusNumber() {
            run("7")
            val bonus = InputView.getBonusNumber()
            assertThat(bonus).isEqualTo(7)
        }

        @Test
        @DisplayName("Should throw exception for non-numeric bonus number input")
        fun invalidNonNumericBonusNumber() {
            run("abc")
            assertThatThrownBy { InputView.getBonusNumber() }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("abc")
        }

        @Test
        @DisplayName("Should throw exception for empty bonus number input")
        fun emptyBonusNumber() {
            run("\n")
            assertThatThrownBy { InputView.getBonusNumber() }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("''")
        }
    }
}