package lotto.support

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class ValidatorTest {

    @Test
    fun `passes when purchase amount is valid`() {
        Validator.validatePurchaseAmount(5000)
    }

    @Test
    fun `throws exception when purchase amount is less than ticket price`() {
        assertThatThrownBy { Validator.validatePurchaseAmount(500) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `throws exception when purchase amount is not divisible by ticket price`() {
        assertThatThrownBy { Validator.validatePurchaseAmount(1500) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `passes when winning ticket is valid`() {
        Validator.validateWinningTicket(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `throws exception when winning ticket size is not six`() {
        assertThatThrownBy { Validator.validateWinningTicket(listOf(1, 2, 3, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `throws exception when winning ticket has duplicates`() {
        assertThatThrownBy { Validator.validateWinningTicket(listOf(1, 1, 2, 3, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `throws exception when winning ticket has number out of range`() {
        assertThatThrownBy { Validator.validateWinningTicket(listOf(0, 2, 3, 4, 5, 6)) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `passes when bonus number is valid`() {
        Validator.validateBonusNumber(7, listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `throws exception when bonus number is out of range`() {
        assertThatThrownBy { Validator.validateBonusNumber(46, listOf(1, 2, 3, 4, 5, 6)) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `throws exception when bonus number is duplicate of winning ticket`() {
        assertThatThrownBy { Validator.validateBonusNumber(6, listOf(1, 2, 3, 4, 5, 6)) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
