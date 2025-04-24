package lotto

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThatThrownBy

class LottoTest {
    // 로또 번호가 6개 초과일 경우 예외 발생
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        // given :  input value that causes an exception
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7)

        // when
        assertThatThrownBy {
            Lotto(numbers)
        }
        //then
        .isInstanceOf(IllegalArgumentException::class.java)
        .hasMessageContaining("exactly 6 numbers")
    }

    // 중복된 숫자가 포함될 경우 예외 발생
    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 5)

        // when
        assertThatThrownBy {
            Lotto(numbers)
        }
        //then
        .isInstanceOf(IllegalArgumentException::class.java)
        .hasMessageContaining("must contain 6 unique numbers")
    }

    @Test
    fun `throw exception when number is out of range`() {
        // given
        val numbers = listOf(0, 2, 3, 4, 5, 6)

        // when
        assertThatThrownBy {
            Lotto(numbers)
        }
        //then
        .isInstanceOf(IllegalArgumentException::class.java)
        .hasMessageContaining("must be between 1 and 45")
    }
}
