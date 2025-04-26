package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream
import java.lang.reflect.Method

class LottoTest {
    private val winningNumbers: Lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
    
    private fun getPrivateMethod(methodName: String, vararg paramTypes: Class<*>): Method {
        val method = Lotto::class.java.getDeclaredMethod(methodName, *paramTypes)
        method.isAccessible = true
        return method
    }

    @Test
    fun `should create lotto with valid numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        assertEquals(numbers.sorted(), lotto.getNumbers())
    }

    @Test
    fun `should throw when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }
    
    @Test
    fun `should throw when lotto numbers are fewer than six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46, 100])
    fun `should throw when lotto numbers are outside valid range`(invalidNumber: Int) {
        val validNumbers = listOf(1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            Lotto(validNumbers + invalidNumber)
        }
    }

    @Test
    fun `should throw when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    companion object {
        @JvmStatic
        fun matchTestCases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(6, Lotto(listOf(1, 2, 3, 4, 5, 6))),
                Arguments.of(5, Lotto(listOf(1, 2, 3, 4, 5, 7))),
                Arguments.of(4, Lotto(listOf(1, 2, 3, 4, 7, 8))),
                Arguments.of(3, Lotto(listOf(1, 2, 3, 7, 8, 9))),
                Arguments.of(2, Lotto(listOf(1, 2, 7, 8, 9, 10))),
                Arguments.of(1, Lotto(listOf(1, 7, 8, 9, 10, 11))),
                Arguments.of(0, Lotto(listOf(7, 8, 9, 10, 11, 12)))
            )
        }
    }

    @ParameterizedTest(name = "Compare Lotto with {0} matches")
    @MethodSource("matchTestCases")
    fun `should correctly count matching numbers`(expectedMatchCount: Int, userLotto: Lotto) {
        assertEquals(expectedMatchCount, userLotto.compare(winningNumbers))
    }

    @Test
    fun `containsNumber should return true when number is in lotto`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertTrue(lotto.containsNumber(1))
        assertTrue(lotto.containsNumber(3))
        assertTrue(lotto.containsNumber(6))
    }

    @Test
    fun `containsNumber should return false when number is not in lotto`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertFalse(lotto.containsNumber(7))
        assertFalse(lotto.containsNumber(45))
        assertFalse(lotto.containsNumber(0))
    }

    @Test
    fun `getNumbers should return the correct list of numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        assertEquals(numbers, lotto.getNumbers())
    }
    
    @Test
    fun `getNumbers should return sorted numbers`() {
        val unsortedNumbers = listOf(6, 3, 1, 4, 5, 2)
        val lotto = Lotto(unsortedNumbers)
        val expected = listOf(1, 2, 3, 4, 5, 6)
        assertEquals(expected, lotto.getNumbers())
    }
}