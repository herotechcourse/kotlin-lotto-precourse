package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class BonusNumberTest {

    @Test
    fun `should create valid bonus number when not duplicated with winning numbers`() {
        val winningNumbers = WinningNumbers.from(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(LottoNumber(7), winningNumbers)
        assertThat(bonusNumber.number.number).isEqualTo(7)
    }

    @Test
    fun `should throw exception when bonus number is included in winning numbers`() {
        // given
        val winningNumbers = WinningNumbers.from(listOf(1, 2, 3, 4, 5, 6))

        // when & then
        assertThrows<IllegalArgumentException> {
            BonusNumber(LottoNumber(6), winningNumbers)
        }
    }
}