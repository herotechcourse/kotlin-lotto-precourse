package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class LottoTest {

    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        // Test case: When a lotto ticket has more than 6 numbers
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        // Test case: When a lotto ticket contains duplicate numbers
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))  // Duplicate number (5)
        }
    }

    @Test
    fun `does not throw an exception when lotto numbers are valid`() {
        // Test case: When a lotto ticket is valid (6 unique numbers)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto).isNotNull
    }

    @Test
    fun `throws an exception when lotto numbers are outside valid range`() {
        // Test case: When lotto numbers are out of the valid range (1-45)
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 46))  // Invalid numbers 0 and 46
        }
    }

    @Test
    fun `throws an exception when lotto numbers are not within range 1 to 45`() {
        // Test case: When lotto numbers contain values outside the range [1, 45]
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(-1, 2, 3, 4, 5, 46))  // Invalid numbers -1 and 46
        }
    }
}
