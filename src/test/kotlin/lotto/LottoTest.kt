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
    @Test
    fun `returns the correct lotto numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        assert(numbers == lotto.getNumbers())
    }

    @Test
    fun `lotto numbers are sorted in ascending order`() {
        val numbers = listOf(6, 2, 5, 1, 4, 3)
        val lotto = Lotto(numbers)
        assert(lotto.getNumbers() == listOf(1, 2, 3, 4, 5, 6))
    }
}
