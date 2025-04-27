/*package lotto

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
}*/
package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals

class LottoTest {

    @Test
    fun `should create a Lotto ticket with valid numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(listOf(1, 2, 3, 4, 5, 6).sorted(), lotto.toString().trim('[', ']').split(',').map { it.trim().toInt() }.sorted())
    }

    @Test
    fun `should throw exception for Lotto ticket with less than 6 numbers`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
        assertEquals("[ERROR] Lotto must contain exactly 6 numbers.", exception.message)
    }

    @Test
    fun `should throw exception for Lotto ticket with duplicate numbers`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 1, 2, 3, 4, 5))
        }
        assertEquals("[ERROR] Lotto numbers must be unique.", exception.message)
    }

    @Test
    fun `should throw exception for Lotto ticket with invalid number range`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
        assertEquals("[ERROR] Lotto numbers must be between 1 and 45.", exception.message)
    }
}
