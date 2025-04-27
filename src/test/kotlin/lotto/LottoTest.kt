package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat


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
    fun `throws an exception when lotto numbers are out of range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 1, 2, 3, 4, 5))
        }
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `getNumbers returns sorted list`() {
        val numbers = listOf(42, 1, 17, 9, 30, 5)
        val lotto = Lotto(numbers)
        assertThat(lotto.getNumbers()).isEqualTo(listOf(1, 5, 9, 17, 30, 42))
    }
}

