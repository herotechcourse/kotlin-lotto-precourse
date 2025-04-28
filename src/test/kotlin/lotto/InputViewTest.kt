package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.junit.jupiter.api.assertThrows
import java.lang.reflect.Method

class InputViewTest {
    private val inputView = InputView()
    private fun getPrivateMethod(methodName: String, vararg paramTypes: Class<*>): Method {
        val method = InputView::class.java.getDeclaredMethod(methodName, *paramTypes)
        method.isAccessible = true
        return method
    }

    @Test
    fun `validatePurchaseAmount should accept valid amounts`() {
        val validateMethod = getPrivateMethod("validatePurchaseAmount", Int::class.java)
        assertDoesNotThrow { validateMethod.invoke(inputView, 1000) }
        assertDoesNotThrow { validateMethod.invoke(inputView, 5000) }
        assertDoesNotThrow { validateMethod.invoke(inputView, 10000) }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1000, 0])
    fun `validateAmountIsPositive should throw for non-positive amounts`(amount: Int) {
        val validateMethod = getPrivateMethod("validateAmountIsPositive", Int::class.java)
        assertThrows(Exception::class.java) { validateMethod.invoke(inputView, amount) }
    }

    @ParameterizedTest
    @ValueSource(ints = [500, 1500, 2001])
    fun `validateAmountIsMultipleOfThousand should throw for non-multiples of 1000`(amount: Int) {
        val validateMethod = getPrivateMethod("validateAmountIsMultipleOfThousand", Int::class.java)
        assertThrows(Exception::class.java) { validateMethod.invoke(inputView, amount) }
    }

    @Test
    fun `validateWinningNumbers should accept valid numbers`() {
        val validateMethod = getPrivateMethod("validateWinningNumbers", List::class.java)
        val validNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertDoesNotThrow { validateMethod.invoke(inputView, validNumbers) }
    }

    @Test
    fun `validateNumberCount should throw if not exactly 6 numbers`() {
        val validateMethod = getPrivateMethod("validateNumberCount", List::class.java)
        val tooFewNumbers = listOf(1, 2, 3, 4, 5)
        val tooManyNumbers = listOf(1, 2, 3, 4, 5, 6, 7)
        assertThrows(Exception::class.java) { validateMethod.invoke(inputView, tooFewNumbers) }
        assertThrows(Exception::class.java) { validateMethod.invoke(inputView, tooManyNumbers) }
    }

    @Test
    fun `validateNumberRange should throw if numbers outside range`() {
        val validateMethod = getPrivateMethod("validateNumberRange", List::class.java)
        val tooLowNumber = listOf(0, 2, 3, 4, 5, 6)
        val tooHighNumber = listOf(1, 2, 3, 4, 5, 46)
        assertThrows(Exception::class.java) { validateMethod.invoke(inputView, tooLowNumber) }
        assertThrows(Exception::class.java) { validateMethod.invoke(inputView, tooHighNumber) }
    }

    @Test
    fun `validateNoDuplicates should throw if there are duplicates`() {
        val validateMethod = getPrivateMethod("validateNoDuplicates", List::class.java)
        val duplicateNumbers = listOf(1, 2, 3, 4, 5, 5)
        assertThrows(Exception::class.java) { validateMethod.invoke(inputView, duplicateNumbers) }
    }

    @Test
    fun `validateNoDuplicates should work with any list size`() {
        val validateMethod = getPrivateMethod("validateNoDuplicates", List::class.java)
        assertDoesNotThrow { validateMethod.invoke(inputView, listOf(1, 2, 3)) }
        assertThrows(Exception::class.java) { validateMethod.invoke(inputView, listOf(1, 2, 1)) }
        assertDoesNotThrow { validateMethod.invoke(inputView, listOf(7)) }
    }

    @Test
    fun `validateBonusNumber should accept valid bonus number`() {
        val validateMethod = getPrivateMethod("validateBonusNumber", Int::class.java, List::class.java)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val validBonus = 7
        assertDoesNotThrow { validateMethod.invoke(inputView, validBonus, winningNumbers) }
    }

    @Test
    fun `validateNumberRange should throw if bonus number outside range`() {
        val validateMethod = getPrivateMethod("validateNumberRange", List::class.java)
        assertThrows(Exception::class.java) { validateMethod.invoke(inputView, listOf(0)) }
        assertThrows(Exception::class.java) { validateMethod.invoke(inputView, listOf(46)) }
    }

    @Test
    fun `validateBonusIsNotWinningNumber should throw if bonus is one of winning numbers`() {
        val validateMethod = getPrivateMethod("validateBonusIsNotWinningNumber", Int::class.java, List::class.java)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertThrows(Exception::class.java) { validateMethod.invoke(inputView, 1, winningNumbers) }
        assertDoesNotThrow { validateMethod.invoke(inputView, 7, winningNumbers) }
    }

    @Test
    fun `parseCommaDelimitedNumbers should correctly parse valid input`() {
        val parseMethod = getPrivateMethod("parseCommaDelimitedNumbers", String::class.java)
        val result = parseMethod.invoke(inputView, "1,2,3,4,5,6") as List<*>
        assertEquals(listOf(1, 2, 3, 4, 5, 6), result)
    }

    @Test
    fun `parseCommaDelimitedNumbers should handle spaces in input`() {
        val parseMethod = getPrivateMethod("parseCommaDelimitedNumbers", String::class.java)
        val result = parseMethod.invoke(inputView, "1, 2, 3, 4, 5, 6") as List<*>
        assertEquals(listOf(1, 2, 3, 4, 5, 6), result)
    }

    @Test
    fun `parseCommaDelimitedNumbers should throw for invalid input`() {
        val parseMethod = getPrivateMethod("parseCommaDelimitedNumbers", String::class.java)
        assertThrows(Exception::class.java) { parseMethod.invoke(inputView, "1,2,a,4,5,6") }
    }
} 