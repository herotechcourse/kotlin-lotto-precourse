package lotto

import lotto.domain.WinningNumbers
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest{
    @Test
    fun `valid winning numbers`() {
        val winning = WinningNumbers("1,2,3,4,5,6")
        assertThat(winning.numbers).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `invalid winning numbers ends with comma`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers("1,2,3,4,5,6,")
        }
    }

    @Test
    fun `invalid winning numbers less than minimum`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers("-1,2,3,4,5,6")
        }
    }

    @Test
    fun `invalid winning numbers greater than maximum`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers("46,2,3,4,5,6")
        }
    }

    @Test
    fun `invalid winning numbers duplicated`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers("2,2,3,4,5,6")
        }
    }

    @Test
    fun `invalid winning numbers with wrong delimiter`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers("1;2;3;4;5;6")
        }
    }

}