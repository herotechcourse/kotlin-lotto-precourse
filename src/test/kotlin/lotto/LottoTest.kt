package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals

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
    fun `throws an exception when lotto numbers contain number out of range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 55))
        }
    }

    @Test
    fun `Lotto Match Test`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winning = Lotto(listOf(1, 2, 3, 7, 8, 9))
        assertEquals(lotto.match(winning), 3)
    }

    @Test
    fun `Lotto Bonus Number Contain Test`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val bonusNumber = 7
        assertEquals(lotto.isBonusContain(bonusNumber), true)
    }

}
