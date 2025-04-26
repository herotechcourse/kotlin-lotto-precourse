package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `throws an exception when lotto numbers are out of range`(number: Int) {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, number))
        }
    }

    @Test
    fun `count matching numbers correctly`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assert(lotto.countMatchingNumbers(listOf(1, 2, 7, 8, 9, 10)) == 2)
    }

    @Test
    fun `check bonus number correctly`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assert(lotto.hasBonusNumber(6))
        assert(!lotto.hasBonusNumber(7))
    }
}