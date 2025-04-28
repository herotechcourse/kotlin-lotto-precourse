package lotto.validator

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class BonusNumberTest {

    private val winning = listOf(1, 2, 3, 4, 5, 6)

    @Test
    fun `valid bonus returns int`() {
        val result = validateBonusNumber("7", winning)
        assert(result == 7)
    }

    @Test
    fun `duplicate with winning throws exception`() {
        assertThatThrownBy { validateBonusNumber("3", winning) }
            .hasMessage("[ERROR] Bonus number must be between 1-45 and must be other than the winning numbers")
    }
}
