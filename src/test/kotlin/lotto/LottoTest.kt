package lotto

import lotto.utils.Constant.DUPLICATE_NUMBER_ERROR_MESSAGE
import lotto.utils.Constant.LOTTO_SIZE_ERROR_MESSAGE
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class LottoTest {
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `throw an exception when lotto numbers are duplicated`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(DUPLICATE_NUMBER_ERROR_MESSAGE)
    }

    @ParameterizedTest
    @MethodSource("invalidLottoNumbers")
    fun `throw an exception when the number of lotto numbers is not LOTTO_SIZE`(numbers: List<Int>) {
        assertThatThrownBy { Lotto(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(LOTTO_SIZE_ERROR_MESSAGE)
    }

    companion object {
        @JvmStatic
        fun invalidLottoNumbers() = listOf(
            listOf(1, 2, 3, 4, 5),
            listOf(1, 2, 3, 4, 5, 6, 7)
        )
    }
}
