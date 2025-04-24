package lotto

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.assertj.core.api.Assertions.assertThatNoException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class InputViewTest {
    @ParameterizedTest(name = "{index}. invalid purchase amount of \"{0}\"")
    @ValueSource(strings = ["0", "999", "1200", "abc", " ", "2147483647", "16000", "-1000"])
    @EmptySource // for empty input; use @NullSource for null input
    fun `test invalid purchase amount`(input: String) {
        assertThatIllegalArgumentException()
            .isThrownBy{ InputView().parseAmount(input) }
            .withMessageStartingWith("[ERROR]")
    }

    @ParameterizedTest(name = "{index}. valid purchase amount of \"{0}\"")
    @ValueSource(strings = ["1000", "12000", "15000"])
    fun `test valid purchase amount`(input: String) {
        assertThatNoException().isThrownBy{ InputView().parseAmount(input) }
        val value = InputView().parseAmount(input)
        assertThat(value).isEqualTo(input.toInt())
    }

    @ParameterizedTest(name = "{index}. invalid bonus number of \"{0}\"")
    @ValueSource(strings = ["0", "111", "a", " ", "-1"])
    @EmptySource
    fun `test invalid bonus number`(input: String) {
        assertThatIllegalArgumentException()
            .isThrownBy{ InputView().parseBonusNumber(input) }
            .withMessageStartingWith("[ERROR]")
    }

    @ParameterizedTest(name = "{index}. valid bonus number of \"{0}\"")
    @ValueSource(strings = ["1", "45", "12"])
    fun `test valid bonus number`(input: String) {
        assertThatNoException().isThrownBy{ InputView().parseBonusNumber(input) }
        val value = InputView().parseBonusNumber(input)
        assertThat(value).isEqualTo(input.toInt())
    }

    @ParameterizedTest(name = "{index}. invalid list of \"{0}\"")
    @ValueSource(strings = ["a,b,c,1,2,3", "1,,2,3,4,5,6", "1,2,3,4,5,6,", " "])
    @EmptySource
    fun `test invalid winning numbers list`(input: String) {
        assertThatIllegalArgumentException()
            .isThrownBy{ InputView().parseWinningNumbers(input) }
            .withMessageStartingWith("[ERROR]")
    }

    @ParameterizedTest(name = "{index}. valid list of \"{0}\"")
    @ValueSource(strings = ["1,2,3,4,5,6", "121,456,3"])
    fun `test valid winning numbers list`(input: String) {
        assertThatNoException().isThrownBy{ InputView().parseWinningNumbers(input) }
    }
}