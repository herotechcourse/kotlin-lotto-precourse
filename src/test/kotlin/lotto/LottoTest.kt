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

    @Test
    fun `throw an exception when lotto numbers greater than 45`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 4, 6, 8, 50))
        }
    }

    @Test
    fun `throw an exception when lotto numbers less than 1`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 3, 5, -1, 7, 10))
        }
    }

    // TODO: Implement tests based on the added features
}
