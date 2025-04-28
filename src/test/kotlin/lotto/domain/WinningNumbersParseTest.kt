package lotto.domain

import org.assertj.core.api.Java6Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class WinningNumbersParseTest {
    @Test
    fun `parse throws when winning numbers are non-numeric`() {
        assertThatThrownBy { WinningNumbers.parse("1,2,a,4,5,6", "7") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `parse throws when winning numbers count is not 6`() {
        assertThatThrownBy { WinningNumbers.parse("1,2,3,4,5", "7") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `parse throws when bonus is non-numeric`() {
        assertThatThrownBy { WinningNumbers.parse("1,2,3,4,5,6", "x") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `parse throws when bonus duplicates winning numbers`() {
        assertThatThrownBy { WinningNumbers.parse("1,2,3,4,5,6", "6") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }
}