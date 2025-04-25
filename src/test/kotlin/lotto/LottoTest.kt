package lotto

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        val numbers = listOf(1, 2, 3, 3, 4, 5)
        assertThatThrownBy { Lotto(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Lotto numbers must be unique.")
    }

    @Test
    fun `throws an exception when lotto numbers are less than 6`() {
        val numbers = listOf(1, 2, 3, 4, 5)
        assertThatThrownBy { Lotto(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Lotto must contain exactly 6 numbers.")
    }

    @Test
    fun `throws an exception when lotto numbers are not between 1 and 45`() {
        val numbers = listOf(0, 2, 3, 4, 5, 6)
        assertThatThrownBy { Lotto(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Lotto numbers must be between 1 and 45.")
    }

    @Test
    fun `does not throw an exception for valid lotto numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        Lotto(numbers) // No exception expected
    }
}
