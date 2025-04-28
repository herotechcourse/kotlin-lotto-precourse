package lotto

import lotto.domain.LottoNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class LottoNumberTest {

    @Test
    fun `throws exception when number is less than 1`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(0)
        }
    }

    @Test
    fun `throws exception when number is greater than 45`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(46)
        }
    }

    @Test
    fun `creates valid LottoNumber between 1 and 45`() {
        val number = LottoNumber(10)
        assertThat(number.number).isEqualTo(10)
    }

    @Test
    fun `supports equality based on number value`() {
        assertThat(LottoNumber(5)).isEqualTo(LottoNumber(5))
    }

    @Test
    fun `supports sorting by number value`() {
        val sorted = listOf(LottoNumber(8), LottoNumber(1), LottoNumber(3)).sorted()
        assertThat(sorted.map { it.number }).isEqualTo(listOf(1, 3, 8))
    }
}