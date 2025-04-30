package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoNumberTest {
    @Test
    fun `LottoNumber must be between 1 and 45`() {
        // given
        val invalidNumber = 0

        // when & then
        assertThatThrownBy { LottoNumber(invalidNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Lotto numbers must be between 1 and 45.")
    }

    @Test
    fun `throw an exception when LottoNumber not between 1 and 45`() {
        // given
        val invalidNumber = 46

        // when & then
        assertThatThrownBy { LottoNumber(invalidNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Lotto numbers must be between 1 and 45.")
    }
}
