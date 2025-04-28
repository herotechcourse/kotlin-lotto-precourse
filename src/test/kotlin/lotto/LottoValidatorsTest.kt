package lotto

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoValidatorsTest {
    val winning = listOf(1, 2, 3, 4, 5, 6)

    @Test
    fun `valid amounts do not throw`() {
        assertDoesNotThrow { LottoValidators.validatePurchase(1_000) }
        assertDoesNotThrow { LottoValidators.validatePurchase(5_000) }
        assertDoesNotThrow { LottoValidators.validatePurchase(10_000) }
    }

    @ParameterizedTest(name = "invalid purchase amount {0} should throw")
    @ValueSource(ints = [-1_000, 0, 500, 1_500])
    fun `negative, zero, or non-multiple amounts throw`(amount: Int) {
        val ex = assertThrows<IllegalArgumentException> {
            LottoValidators.validatePurchase(amount)
        }
        // Optional: verify message prefix only (don’t pin to full text)
        assert(ex.message!!.startsWith("[ERROR]"))
    }

    @Test
    fun `valid winning numbers pass`() {
        assertDoesNotThrow {
            LottoValidators.validateWinningNumber(listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `wrong size throws`() {
        assertThrows<IllegalArgumentException> {
            LottoValidators.validateWinningNumber(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }


    @Test
    fun `duplicate numbers throw`() {
        assertThrows<IllegalArgumentException> {
            LottoValidators.validateWinningNumber(listOf(1, 2, 3, 3, 4, 5))
        }
    }

    @Test
    fun `out of range numbers throw`() {
        assertThrows<IllegalArgumentException> {
            LottoValidators.validateWinningNumber(listOf(0, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `valid bonus passes`() {
        assertDoesNotThrow {
            LottoValidators.validateBonusNumber(10, winning)
        }
    }

    @Test
    fun `duplicate bonus throws`() {
        assertThrows<IllegalArgumentException> {
            LottoValidators.validateBonusNumber(3, winning)
        }
    }


    @ParameterizedTest(name = "out-of-range bonus {0}")
    @ValueSource(ints = [0, 46])
    fun `bonus outside 1 to 45 throws`(bonus: Int) {
        assertThrows<IllegalArgumentException> {
            LottoValidators.validateBonusNumber(bonus, winning)
        }
    }

}