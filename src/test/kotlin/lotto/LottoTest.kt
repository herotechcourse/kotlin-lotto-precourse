package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: Implement production code to pass the test
    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // TODO: Implement tests based on the added features
    // 로또 번호가 6개가 아니면 예외가 발생한다
    @Test
    fun `throws an exception 04`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5)) // 5개만 입력
        }
        assert(exception.message!!.contains("[ERROR] Lotto must contain exactly 6 numbers."))
    }

    // 로또 번호에 중복된 숫자가 있으면 예외가 발생한다
    @Test
    fun `throws an exception 05`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5)) // 5가 중복
        }
        assert(exception.message!!.contains("[ERROR] Lotto numbers must be unique."))
    }

    // 로또 번호가 1부터 45 사이가 아니면 예외가 발생한다
    @Test
    fun `throws an exception 06`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6)) // 0은 범위 밖
        }
        assert(exception.message!!.contains("[ERROR] Lotto numbers must be between 1 and 45."))
    }

    // 정상적인 로또 번호는 에러 없이 생성된다
    @Test
    fun `throws an exception 07`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assert(lotto.getNumbers().containsAll(listOf(1, 2, 3, 4, 5, 6)))
    }
}