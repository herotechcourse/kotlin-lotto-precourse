package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {
    @Test
    fun `throw exception when main numbers exceed 6`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 6, 7), 10)
        }
    }

    @Test
    fun `throw exception when main number contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 5), 30)
        }
    }

    @Test
    fun `throw exception when main numbers greater than 45`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 50), 12)
        }
    }

    @Test
    fun `throw exception when main number less than 1`() {
        assertThrows<IllegalArgumentException> {
                WinningNumbers(listOf(0, 1, 3, 5, 7, 9), 10)
            }
        }

    @Test
    fun `throw exeption when bonus number greater than 45`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 50)
        }
    }

    @Test
    fun `throw exception when bonus number less than 1`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 0)
        }
    }

    @Test
    fun `throw exception when bonus number is contained in main numbers`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 2)
        }
    }

    }





