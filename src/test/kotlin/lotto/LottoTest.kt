package lotto

import org.junit.jupiter.api.Assertions.assertNotNull
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
    fun `throws an exception when lotto numbers are not in range 1-45`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 10, 46, 23, 32, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are less than six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `test Lotto with valid numbers creates instance`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertNotNull(lotto)
    }
}
