package lotto.validator

import WinningNumberValidator
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningNumberValidatorTest {

    private val validator = WinningNumberValidator()

    @Test
    fun `Pass 6 numbers without duplicates as normal`() {
        val inputs = listOf(1, 2, 3, 4, 5, 6)
        val result = validator.run(inputs)
        assertThat(result).isEqualTo(inputs)
    }

    @Test
    fun `Throw an exception if the number is less than 1`() {
        assertThatThrownBy {
            validator.run(listOf(0, 2, 3, 4, 5, 6))
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Winning number")
    }

    @Test
    fun `Throw an exception if the number is greater than 45`() {
        assertThatThrownBy {
            validator.run(listOf(1, 2, 3, 4, 5, 46))
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Winning number")
    }

    @Test
    fun `Throw an exception if there is a duplicate number`() {
        assertThatThrownBy {
            validator.run(listOf(1, 2, 3, 3, 5, 6))
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Winning number 3 is duplicated")
    }

    @Test
    fun `Return as is if the bonus number is within the normal range`() {
        val result = validator.getBonus(7)
        assertThat(result).isEqualTo(7)
    }

    @Test
    fun `Throw an exception if the bonus number is out of range`() {
        assertThatThrownBy {
            validator.getBonus(50)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Winning number 50 must be between 1 and 45")
    }

    @Test
    fun `Throw an exception if the bonus number is a duplicate of an existing winning number`() {
        validator.run(listOf(1, 2, 3, 4, 5, 6)) // 기존 당첨 숫자 등록
        assertThatThrownBy {
            validator.getBonus(3)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Winning number 3 is duplicated")
    }
}
