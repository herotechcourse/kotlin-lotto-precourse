package lotto

import lotto.validation.Input
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidationTest {

    @Test
    fun `input must be not empty`() {
        assertThrows<IllegalArgumentException> {
            Input.isEmpty("")
        }
    }

    @Test
    fun `input must be integer`() {
        assertThrows<IllegalArgumentException> {
            Input.isInteger("abc")
        }
    }

    @Test
    fun `input must be positive integer`() {
        assertThrows<IllegalArgumentException> {
            Input.isPositiveInteger(-1)
        }
    }

    @Test
    fun `input must be divisible by 1000`() {
        assertThrows<IllegalArgumentException> {
            Input.isDivisible(800, 1000)
        }
    }

    @Test
    fun `numbers must be in range from 1 to 45`() {
        assertThrows<IllegalArgumentException> {
            Input.isInRange(50, 1, 45)
        }
    }

    @Test
    fun `each input must be integer`() {
        assertThrows<IllegalArgumentException> {
            Input.isEachInteger(listOf("1", "2", "a"))
        }
    }

    @Test
    fun `each winning number must be in range from 1 to 45`() {
        assertThrows<IllegalArgumentException> {
            Input.isEachInRange(listOf(1, 2, 3, 4, 5, 46), 1, 45)
        }
    }

    @Test
    fun `bonus number must not be duplicated with the winning numbers`() {
        assertThrows<IllegalArgumentException> {
            Input.bonusNumberDuplication(6, listOf(1, 2, 3, 4, 5, 6))
        }
    }
}