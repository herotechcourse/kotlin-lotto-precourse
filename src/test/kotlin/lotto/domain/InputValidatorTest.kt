package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {

    @Test
    fun `exception test purchase money not number`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateMoneyAmount("Hundred")
        }
    }

    @Test
    fun `exception test purchase money not integer`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateMoneyAmount("249.56")
        }
    }

    @Test
    fun `exception test purchase money non positive`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateMoneyAmount("0")
        }
    }

    @Test
    fun `exception test purchase money not divisible by 1000`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateMoneyAmount("2500")
        }
    }

    @Test
    fun `feature test purchase money valid at 8000`() {
        assertThat(InputValidator.validateMoneyAmount("8000")).isEqualTo(8000)
    }

    @Test
    fun `exception test main numbers exceed 6 numbers`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateMainNumbers("1,2,3,4,5,6,7")
        }
    }

    @Test
    fun `exception test main numbers less than 6 numbers`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateMainNumbers("1,2,3,4,5")
        }
    }

    @Test
    fun `exception test main numbers not an integer`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateMainNumbers("1,2j,3,4,5,6")
        }
    }

    @Test
    fun `exception test main numbers out of range`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateMainNumbers("1,2,3,4,5,60")
        }
    }

    @Test
    fun `exception test bonus number not an integer`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumber("1.5",listOf(1,2,3,4,5,6))
        }
    }

    @Test
    fun `exception test bonus number out of range`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumber("0",listOf(1,2,3,4,5,6))
        }
    }

    @Test
    fun `exception test bonus number in the main numbers`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumber("1",listOf(1,2,3,4,5,6))
        }
    }
}