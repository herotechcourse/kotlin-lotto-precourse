package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PurchaseTest {
    @ParameterizedTest
    @ValueSource(strings = ["1200", "999", "1001"])
    fun `throws exception when budget is not divisible by 1000`(input: String) {
        assertThatIllegalArgumentException()
            .isThrownBy{ Purchase(input.toInt()) }
            .withMessageStartingWith("[ERROR]")
    }

    @ParameterizedTest
    @ValueSource(strings = ["16000", "30000"])
    fun `throws exception when budget exceeds max amount`(input: String) {
        assertThatIllegalArgumentException()
            .isThrownBy{ Purchase(input.toInt()) }
            .withMessageStartingWith("[ERROR]")
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1000"])
    fun `throws exception when budget does not reach min amount`(input: String) {
        assertThatIllegalArgumentException()
            .isThrownBy{ Purchase(input.toInt()) }
            .withMessageStartingWith("[ERROR]")
    }

    @ParameterizedTest(name = "{index}. valid purchase amount of \"{0}\"")
    @ValueSource(strings = ["1000", "12000", "15000"])
    fun `test valid purchase amount`(input: String) {
        assertThatNoException().isThrownBy{ Purchase(input.toInt()) }
    }

    @Test
    fun `issues correct amount of tickets`() {
        assertThat(Purchase(8000).tickets.size).isEqualTo(8)
    }
}