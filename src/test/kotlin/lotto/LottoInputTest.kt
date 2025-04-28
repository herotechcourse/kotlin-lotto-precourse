
package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoInputTest {

    @Test
    @DisplayName("Valid winning numbers parsing")
    fun validWinningNumbers() {
        val raw = "1, 2,3,4,5,6"
        val result = LottoInput.parseWinningNumbers(raw)
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    @DisplayName("Invalid winning numbers: incorrect count")
    fun invalidCount() {
        assertThatThrownBy { LottoInput.parseWinningNumbers("1,2,3,4,5") }
            .hasMessage("[ERROR] Winning numbers must contain exactly 6 numbers.")
    }

    @Test
    @DisplayName("Invalid winning numbers: out of range or duplicates")
    fun invalidRangeOrDuplicate() {
        assertThatThrownBy { LottoInput.parseWinningNumbers("0,2,3,4,5,6") }
            .hasMessage("[ERROR] Winning numbers must be between 1 and 45.")
        assertThatThrownBy { LottoInput.parseWinningNumbers("1,2,2,4,5,6") }
            .hasMessage("[ERROR] Winning numbers must not contain duplicates.")
    }

    @Test
    @DisplayName("Valid bonus number parsing")
    fun validBonus() {
        val winning = listOf(1, 2, 3, 4, 5, 6)
        val bonus = LottoInput.parseBonusNumber("7", winning)
        assertThat(bonus).isEqualTo(7)
    }

    @Test
    @DisplayName("Invalid bonus number: non-numeric, out of range, duplicate")
    fun invalidBonus() {
        val winning = listOf(1, 2, 3, 4, 5, 6)
        assertThatThrownBy { LottoInput.parseBonusNumber("a", winning) }
            .hasMessage("[ERROR] Bonus number must be numeric.")
        assertThatThrownBy { LottoInput.parseBonusNumber("0", winning) }
            .hasMessage("[ERROR] Bonus number must be between 1 and 45.")
        assertThatThrownBy { LottoInput.parseBonusNumber("3", winning) }
            .hasMessage("[ERROR] Bonus number must not duplicate winning numbers.")
    }
}
