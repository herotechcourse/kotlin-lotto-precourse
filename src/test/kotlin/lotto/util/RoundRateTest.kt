package lotto.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RoundRateTest {

    @Test
    fun `rounds down correctly`() {
        val result = roundRateToString(62.523)
        assertThat(result).isEqualTo("62.5")
    }

    @Test
    fun `rounds up correctly`() {
        val result = roundRateToString(99.999)
        assertThat(result).isEqualTo("100.0")
    }

    @Test
    fun `rounds zero correctly`() {
        val result = roundRateToString(0.0)
        assertThat(result).isEqualTo("0.0")
    }
}
