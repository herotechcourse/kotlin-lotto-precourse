package lotto

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class InputViewTest {
    @ParameterizedTest(name = "{index}. purchase amount of \"{0}\"")
    @ValueSource(strings = ["0", "999", "1200", "abc", " ", "2147483647"])
    @EmptySource // for empty input; use @NullSource for null input
    fun `test parseAmount`(input: String) {
        assertThatIllegalArgumentException()
            .isThrownBy{ InputView().parseAmount(input) }
            .withMessageStartingWith("[ERROR]")
    }
}