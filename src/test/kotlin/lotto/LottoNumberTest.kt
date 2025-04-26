package lotto

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46])
    fun `throw exception when the number is out of range`(number: Int) {
        // when & then
        assertThatThrownBy { LottoNumber(number) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Number must be between $MIN_RANGE and $MAX_RANGE.")
    }

    companion object {
        private const val MIN_RANGE: Int = 1
        private const val MAX_RANGE: Int = 45
    }
}
