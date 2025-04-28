package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals

class LottoTest {

    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val expected = listOf(1, 2, 3, 4, 5, 6).sorted()

        assertEquals(expected, lotto.getNumbers())
    }

    @Test
    fun `lotto numbers must be between 1 and 45`() {

        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 50))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 3, 5, 6))
        }
    }
}
