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
    fun `throws an exception when calculatePrize argument - bonusNumber is wrong`() {
        assertThrows<IllegalArgumentException> {
            var lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

            lotto.calculatePrize(listOf(1, 2, 3, 4, 5, 6), 0)
        }
    }
}
