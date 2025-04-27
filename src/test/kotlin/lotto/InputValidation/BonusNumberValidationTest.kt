package lotto.InputValidation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberValidationTest {
    private val validator = BonusNumberValidation()
    private val amtValidator = AmountValidation()

    @Test
    fun `exception bonus number is null exception test`() {
        val exception = assertThrows<IllegalArgumentException> {
            amtValidator.NullCheckNumber("")
        }
        assertEquals("[ERROR] Input needs to be an integer", exception.message)
    }

    @Test
    fun `exception bonus number should be in range of 1-45 test`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.ValidateBonusNumberInRange1to45(100)

        }
        assertEquals("Bonus number needs to be in range of 1 to 45", exception.message)
    }

    @Test
    fun `exception bonus number is in the list of winning numbers test`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.ValidateBonusNumberUniqueness(3, listOf(1, 2, 3, 5, 6, 4))

        }
        assertEquals("Bonus number must be different from winning numbers", exception.message)
    }
}