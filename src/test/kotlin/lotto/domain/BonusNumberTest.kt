package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {

    @Test
    fun `throws an exception with message when bonus number is less than minimum`() {
        val exception = assertThrows<IllegalArgumentException> {
            BonusNumber(BonusNumber.MIN_NUMBER - 1)
        }
        assertThat(exception.message).isEqualTo(BonusNumber.BONUS_NUMBER_OUT_OF_RANGE)
    }

    @Test
    fun `throws an exception with message when bonus number is greater than maximum`() {
        val exception = assertThrows<IllegalArgumentException> {
            BonusNumber(BonusNumber.MAX_NUMBER + 1)
        }
        assertThat(exception.message).isEqualTo(BonusNumber.BONUS_NUMBER_OUT_OF_RANGE)
    }

    @Test
    fun `throws an exception with message when bonus number duplicates winning numbers`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(winningNumbers)
        val bonusNumber = BonusNumber(6)

        val exception = assertThrows<IllegalArgumentException> {
            bonusNumber.validateNotDuplicateWith(lotto)
        }
        assertThat(exception.message).isEqualTo(BonusNumber.BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBER)
    }

    @Test
    fun `creates bonus number successfully when value is valid`() {
        val bonusNumber = BonusNumber(BonusNumber.MIN_NUMBER + 1)

        assertThat(bonusNumber.number()).isEqualTo(BonusNumber.MIN_NUMBER + 1)
    }

    @Test
    fun `passes duplicate validation when bonus number does not duplicate with winning numbers`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(winningNumbers)
        val bonusNumber = BonusNumber(7)

        bonusNumber.validateNotDuplicateWith(lotto)
    }
}
