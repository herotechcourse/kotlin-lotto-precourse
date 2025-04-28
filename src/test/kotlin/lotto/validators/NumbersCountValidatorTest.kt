package lotto.validators

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NumbersCountValidatorTest {

    @Test
    fun `should return input when it contains exactly 6 numbers`() {
        val validator = NumbersCountValidator(6)
        val result = validator.validate("1,2,3,4,5,6")
        assertEquals(listOf(1, 2, 3, 4, 5, 6), result)
    }

    @Test
    fun `should throw IllegalArgumentException when input contains less than 6 numbers`() {
        val validator = NumbersCountValidator(6)
        assertThrows<IllegalArgumentException> { validator.validate("1,2,3,4,5") }
    }

    @Test
    fun `should throw IllegalArgumentException when input contains more than 6 numbers`() {
        val validator = NumbersCountValidator(6)
        assertThrows<IllegalArgumentException> { validator.validate("1,2,3,4,5,6,7") }
    }
}
