package lotto

import lotto.domain.Bonus
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BonusTest {

    @DisplayName("Bonus number must be between 1 and 45.")
    @Test
    fun `should throw exception when bonus number is out of range`() {
        assertThatThrownBy { Bonus(0) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}