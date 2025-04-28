package lotto.utils

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class ValidatorTest {

    @Test
    fun `금액 입력이 1000원 단위가 아니면 예외를 던진다`() {
        assertThatThrownBy { Validator.validateAmount("1500") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `금액 입력이 숫자가 아니면 예외를 던진다`() {
        assertThatThrownBy { Validator.validateAmount("abcd") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `로또 번호 입력이 중복되면 예외를 던진다`() {
        assertThatThrownBy { Validator.validateWinningNumbers("1,2,3,4,5,5") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `로또 번호 입력이 1부터 45 범위를 벗어나면 예외를 던진다`() {
        assertThatThrownBy { Validator.validateWinningNumbers("0,2,3,4,5,6") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")

        assertThatThrownBy { Validator.validateWinningNumbers("1,2,3,4,5,46") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `보너스 번호 입력이 숫자가 아니면 예외를 던진다`() {
        assertThatThrownBy { Validator.validateBonusNumber("bonus") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `보너스 번호 입력이 1부터 45 범위를 벗어나면 예외를 던진다`() {
        assertThatThrownBy { Validator.validateBonusNumber("0") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")

        assertThatThrownBy { Validator.validateBonusNumber("46") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }
}
