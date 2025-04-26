package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {
    @Test
    fun `throws an exception when winning lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6, 7), 8)
        }
    }

    // TODO: Implement production code to pass the test
    @Test
    fun `throws an exception when winning lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 5), 8)
        }
    }

    // TODO: Implement tests based on the added features

    @Test
    fun `throws an exception when winning lotto numbers out of range (1 ~ 45)`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 65), 8)
        }
    }

    @Test
    fun `throws an exception when winning lotto bonus number out of range (1 ~ 45)`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 8), 68)
        }
    }

    @Test
    fun `throws an exception when winning lotto bonus number contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 8), 8)
        }
    }

    @Test
    fun `throws an exception when winning lotto numbers have null (null is not integer)`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, null), 8)
        }
    }

    @Test
    fun `throws an exception when winning lotto bonus number have null (null is not integer)`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 7), null)
        }
    }
}
