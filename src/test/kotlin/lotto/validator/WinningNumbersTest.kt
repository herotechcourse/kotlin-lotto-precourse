package lotto.validator

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class WinningNumbersTest {

    @Test
    fun `valid numbers returns list`() {
        val list = validateWinningNumbers("1,2,3,4,5,6")
        assert(list.size == 6)
    }

    @Test
    fun `duplicate throws exception`() {
        assertThatThrownBy { validateWinningNumbers("1,2,3,3,4,5") }
            .hasMessage("[ERROR] Winning numbers must be 6 unique numbers.")
    }

    @Test
    fun `out of range throws exception`() {
        assertThatThrownBy { validateWinningNumbers("0,2,3,4,5,6") }
            .hasMessage("[ERROR] Lotto numbers must be between 1 and 45.")
    }
}
