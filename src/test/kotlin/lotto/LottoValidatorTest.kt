package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoValidatorTest {

    private val validator = LottoValidator()

    @Test
    fun `purchase amount validation`() {
        assertThrows<IllegalArgumentException> { validator.validatePurchaseAmount(500L) }
        assertThrows<IllegalArgumentException> { validator.validatePurchaseAmount(1500L) }
        assertThat(validator.validatePurchaseAmount(2000L)).isEqualTo(2000L)
    }

    @Test
    fun `winning numbers validation`() {
        assertThrows<IllegalArgumentException> { validator.validateWinningNumbers(listOf(1, 2, 3, 4, 5)) }
        assertThrows<IllegalArgumentException> { validator.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 46)) }
        assertThrows<IllegalArgumentException> { validator.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 5)) }
        assertThat(validator.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 6))).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `bonus number validation`() {
        assertThrows<IllegalArgumentException> { validator.validateBonusNumber(46, listOf(1, 2, 3, 4, 5, 6)) }
        assertThrows<IllegalArgumentException> { validator.validateBonusNumber(6, listOf(1, 2, 3, 4, 5, 6)) }
        assertThat(validator.validateBonusNumber(7, listOf(1, 2, 3, 4, 5, 6))).isEqualTo(7)
    }
}
