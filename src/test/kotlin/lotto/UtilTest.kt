package lotto

import lotto.util.RandomNumbers
import lotto.util.Split
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class UtilTest {
    @Test
    fun `random numbers generator should return 6 numbers`() {
        val numbers = RandomNumbers.generate(1, 45, 6)
        assertEquals(6, numbers.size)
    }

    @Test
    fun `generated numbers should be in range from 1 to 45`() {
        val numbers = RandomNumbers.generate(1, 45, 6)
        assertTrue(numbers.all { it in 1..45 })
    }

    @Test
    fun `generated numbers should be unique`() {
        val numbers = RandomNumbers.generate(1, 45, 6)
        assertEquals(numbers.toSet().size, numbers.size)
    }

    @Test
    fun `input splitted by comma`() {
        val result = Split.byComma("1,2,3")
        assertEquals(listOf("1", "2", "3"), result)
    }
}