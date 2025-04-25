package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PurchaseTest {
    @ParameterizedTest
    @ValueSource(strings = ["1200", "999", "1001"])
    fun `throws exception when budget is not divisible by 1000`() {
        assertThrows<IllegalArgumentException> {
            Purchase(1200)
        }
    }

    @Test
    fun `throws exception when budget exceeds max amount`() {
        assertThrows<IllegalArgumentException> {
            Purchase(16000)
        }
    }

    @Test
    fun `throws exception when budget does not reach min amount`() {
        assertThrows<IllegalArgumentException> {
            Purchase(0)
        }
    }

    @Test
    fun `issues correct amount of tickets`() {
        assertThat(Purchase(8000).tickets.size).isEqualTo(8)
    }
}