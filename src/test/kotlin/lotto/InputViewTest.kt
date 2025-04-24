package lotto

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.assertj.core.api.Assertions.assertThatNoException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class InputViewTest {
    @ParameterizedTest(name = "{index}. purchase amount of \"{0}\"")
    @ValueSource(strings = ["0", "999", "1200", "abc", " ", "2147483647", "16000"])
    @EmptySource // for empty input; use @NullSource for null input
    fun `test invalid purchase amount`(input: String) {
        assertThatIllegalArgumentException()
            .isThrownBy{ InputView().parseAmount(input) }
            .withMessageStartingWith("[ERROR]")
    }

    @ParameterizedTest(name = "{index}. purchase amount of \"{0}\"")
    @ValueSource(strings = ["1000", "12000", "15000"])
    fun `test valid purchase amount`(input: String) {
        assertThatNoException().isThrownBy{ InputView().parseAmount(input) }
        val value = InputView().parseAmount(input)
        assertThat(value).isEqualTo(input.toInt())
    }
}