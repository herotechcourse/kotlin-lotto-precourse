package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class BonusNumberTest {
    private val winningNumber = listOf(1, 2, 4, 5, 6, 7)

    @Test
    fun `throws exception when bonus number is out of range`() {
        // given
        val invalidBonus = 99

        // when & then
        assertThatThrownBy { BonusNumber(invalidBonus, winningNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Bonus number must be between")
    }

    @Test
    fun `throws exception when bonus number duplicates winning numbers`() {
        // given
        val duplicateBonus = 1

        // when & then
        assertThatThrownBy { BonusNumber(duplicateBonus, winningNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Bonus number must not duplicate winning numbers")
    }
}