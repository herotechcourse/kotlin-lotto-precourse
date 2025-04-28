package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
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
    fun testNumberOutsideRange() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun testValidNumbers() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat("[1, 2, 3, 4, 5, 6]").isEqualTo(lotto.toString())
    }

    @Test
    fun testLessThanSixNumbers() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun testContainsNumber() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertTrue(lotto.contains(1))
        assertTrue(lotto.contains(6))
        assertFalse(lotto.contains(7))
        assertFalse(lotto.contains(45))
    }

    @Test
    fun testCountMatches() {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val lotto3 = Lotto(listOf(7, 8, 9, 10, 11, 12))

        assertEquals(3, lotto1.countMatches(lotto2))
        assertEquals(3, lotto2.countMatches(lotto1))
        assertEquals(0, lotto1.countMatches(lotto3))
        assertEquals(6, lotto1.countMatches(lotto1))
    }

}
