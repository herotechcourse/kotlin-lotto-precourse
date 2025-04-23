package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    // 로또 번호가 6개 초과일 경우 예외 발생
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        // given :  input value that causes an exception
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7)

        //when & then
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }

        // then : Check whether the thrown exception contains the expected error message
        assert(exception.message?.contains("exactly 6 numbers") == true)
    }

    // 중복된 숫자가 포함될 경우 예외 발생
    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 5)

        // when
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }

        //then
        assert(exception.message?.contains("must contain 6 unique numbers") == true)
    }

    @Test
    fun `throw exception when number is out of range`() {
        // given
        val numbers = listOf(0, 2, 3, 4, 5, 6)

        // when
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }

        //
        assert(exception.message?.contains("must be between 1 and 45") == true)
    }
}
