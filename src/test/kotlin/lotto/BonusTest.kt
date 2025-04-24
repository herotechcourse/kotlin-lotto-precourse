package lotto

import lotto.domain.Bonus
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusTest {

    @DisplayName("Bonus number must be between 1 and 45.")
    @Test
    fun `should throw exception when bonus number is out of range`() {
        assertThrows<IllegalArgumentException> {
            Bonus(0)
        }
    }
}