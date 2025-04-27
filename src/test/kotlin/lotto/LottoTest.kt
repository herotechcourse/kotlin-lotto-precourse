package lotto


import org.assertj.core.api.Assertions.assertThatThrownBy
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
    fun `throws an exception when lotto numbers are less than 6`() {
        val numbers = listOf(1, 2, 3, 4, 5)
        assertThatThrownBy { Lotto(numbers) }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Lotto must contain exactly 6 numbers.")
    }

    @Test
    fun `throws an exception when lotto numbers are not between 1 and 45`() {
        val numbers = listOf(0, 2, 3, 4, 5, 6)
        assertThatThrownBy { Lotto(numbers) }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Lotto numbers must be between 1 and 45.")
    }

    @Test
    fun `should throw exception if lotto numbers are not all numbers`() {
        val invalidInput = "1,2,three,4,5,6"
        assertThatThrownBy {
            InputValidator.parseAndValidateLottoNumbers(invalidInput)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessage("[ERROR] Lotto numbers must be numbers.")
    }

    @Test
    fun `does not throw an exception for valid lotto numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        Lotto(numbers) // No exception expected
    }
}
