package lotto

import lotto.constants.ErrorMessageConstants.ERROR_MESSAGE_BONUS_NUMBER_IN_LOTTO
import lotto.constants.ErrorMessageConstants.ERROR_MESSAGE_INVALID_BONUS_NUMBER_LIMIT
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class BonusNumberTest {

    @Test
    fun `should retrieve BonusNumber successfully when valid`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7, lotto)

        assertThat(bonusNumber.getBonusNumber()).isEqualTo(7)
    }

    @Test
    fun `should throw exception if bonus number is less than 1`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertThatThrownBy { BonusNumber(0, lotto) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ERROR_MESSAGE_INVALID_BONUS_NUMBER_LIMIT)
    }

    @Test
    fun `should throw exception if bonus number is greater than 45`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertThatThrownBy { BonusNumber(46, lotto) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ERROR_MESSAGE_INVALID_BONUS_NUMBER_LIMIT)
    }

    @Test
    fun `should throw exception if bonus number is in lotto numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertThatThrownBy { BonusNumber(5, lotto) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ERROR_MESSAGE_BONUS_NUMBER_IN_LOTTO)
    }
}