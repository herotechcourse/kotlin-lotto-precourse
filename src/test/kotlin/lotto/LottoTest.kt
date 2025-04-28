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
    fun `throws an exception when numbers are out of range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `creates Lotto correctly with valid numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
    }
}
