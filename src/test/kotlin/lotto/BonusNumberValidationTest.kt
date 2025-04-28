package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberValidationTest {

    @Test
    fun `valid bonus number does not throw`() {
        validateBonus(7, listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `throws when bonus is in winning numbers`() {
        assertThrows<IllegalArgumentException> {
            validateBonus(5, listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `throws when bonus number is out of range`() {
        assertThrows<IllegalArgumentException> {
            validateBonus(46, listOf(1, 2, 3, 4, 5, 6))
        }
    }
}
