package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
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
    @DisplayName("matchCount should return the correct number of matching elements")
    fun matchCount_correctlyCountsMatches() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val otherNumbers = listOf(4, 5, 6, 7, 8, 9)

        val matchCount = lotto.matchCount(otherNumbers)

        assertEquals(3, matchCount)
    }

    @Test
    @DisplayName("containsSingleNumber should return true if number is present")
    fun containsSingleNumber_numberPresent() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertTrue(lotto.containsSingleNumber(3))
    }

    @Test
    @DisplayName("containsSingleNumber should return false if number is not present")
    fun containsSingleNumber_numberNotPresent() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertFalse(lotto.containsSingleNumber(7))
    }
}
