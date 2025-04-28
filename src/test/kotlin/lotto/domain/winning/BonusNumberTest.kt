package lotto.domain.winning

import lotto.Lotto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BonusNumberTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,6", "1,10,11,15,30,33", "1,21,29,40,44,45"])
    @DisplayName("[Exception] when winning numbers and bonus number both have 1, throws")
    fun `throws an exception when winning numbers and bonus number are duplicated`(numbers: String) {
        val winningNumbers = WinningNumbers.from(numbers)
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            BonusNumber.from(1, winningNumbers)
        }
    }

    @Test
    fun `when lotto numbers contain bonus number, return true`() {
        val winningNumbers = WinningNumbers.from("1,2,7,10,20,30")
        val bonus = BonusNumber.from(3, winningNumbers)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        org.junit.jupiter.api.Assertions.assertTrue(bonus.isMatched(lotto))
    }
}