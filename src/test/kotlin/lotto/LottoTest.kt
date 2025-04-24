package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    // Test for exception when Lotto numbers exceed six
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // Test for exception when Lotto numbers contains duplicates
    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // Test for exception when Lotto numbers are out of the range (1 to 45)
    @Test
    fun `throws an exception when lotto numbers are out of the valid range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))  // Number 46 is out of range (should be 1–45)
        }
    }

    // Test for successful creation of a Lotto object with valid numbers
    @Test
    fun `creates a valid Lotto object with 6 unique numbers in range 1–45`() {
        val validLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))  // Valid Lotto ticket
        assert(validLotto.getNumbers().size == 6)  // Ensure it contains 6 numbers
        assert(validLotto.getNumbers().all { it in 1..45 })  // Ensure all numbers are within the range
    }

    // Test for Lotto ticket where numbers are not sorted
    @Test
    fun `throws an exception when lotto numbers are not sorted`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(6, 5, 4, 3, 2, 1))  // Lotto ticket with unsorted numbers
        }
    }

    // Test for Lotto ticket where numbers are sorted in ascending order
    @Test
    fun `creates a valid Lotto object with sorted numbers`() {
        val validLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))  // Lotto ticket with sorted numbers
        assert(validLotto.getNumbers() == listOf(1, 2, 3, 4, 5, 6))  // Ensure numbers are sorted
    }

}
