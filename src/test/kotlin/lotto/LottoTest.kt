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

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `numbers can be accessed via getter`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val numbers = lotto.getNumbers()

        assert(numbers.containsAll(listOf(1, 2, 3, 4, 5, 6)))
    }
}