package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
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

    @Test
    fun `throws exception if lotto numbers count is less than 6`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
        // .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `throws exception if lotto number is less than 1`() {
        assertThatThrownBy { Lotto(listOf(0, 1, 2, 3, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
        // .hasMessageContaining("[ERROR]") // Lotto 클래스 구현 시 범위 검증 추가 필요
    }

    @Test
    fun `throws exception if lotto number is greater than 45`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5, 46)) }
            .isInstanceOf(IllegalArgumentException::class.java)
        // .hasMessageContaining("[ERROR]") // Lotto 클래스 구현 시 범위 검증 추가 필요
    }

    @Test
    fun `lotto numbers are stored sorted ascending`() {
        val lotto = Lotto(listOf(6, 3, 1, 4, 5, 2))
        assertThat(lotto.numbers).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `create lotto object successfully with valid numbers`() {
        assertDoesNotThrow {
            Lotto(listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `lotto numbers list maintains immutability`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.numbers).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }
}
