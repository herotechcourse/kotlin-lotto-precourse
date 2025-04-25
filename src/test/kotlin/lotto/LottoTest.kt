package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

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

    @ParameterizedTest
    @MethodSource("numbers")

    fun `throws an exception when lotto contains numbers out of range 1-45`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    companion object {
        @JvmStatic
        fun numbers() = listOf(
            listOf(0, 2, 3, 4, 5, 6),
            listOf(46, 7, 8, 9, 10, 11),
            listOf(1, 3, 5, -8, 33, 21)
        )
    }

    @Test
    fun `returns the number of matches between two Lotto instances`() {
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val ticket = Lotto(listOf(33, 2, 3, 18, 5, 9))
        val result = ticket.matches(winningNumbers)
        assertThat(result).isEqualTo(3)
    }

}
