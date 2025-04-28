package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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
    @ValueSource(ints = [-1, 0, 46])
    fun `throw exception when the number is out of range`(number: Int) {
        // when & then
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5, number)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Number must be between $MIN_RANGE and $MAX_RANGE.")
    }

    @Test
    fun `can count matching numbers between two lotto`() {
        // given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val comparisonLotto = Lotto(listOf(4, 5, 6, 7, 8, 9))
        // when
        val matchingCount = lotto.countSameNumber(comparisonLotto)
        // then
        assertThat(matchingCount).isEqualTo(3)
    }

    @ParameterizedTest
    @ValueSource(ints = [11, 20, 40])
    fun `should return true when lotto does not contain the given number`(lottoNumber: Int) {
        // given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        // when
        val isNotContained = lotto.doesNotContain(lottoNumber)
        // then
        assertThat(isNotContained).isTrue()
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6])
    fun `should return true when lotto contains a same lotto number`(lottoNumber: Int) {
        // given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        // when
        val hasSameNumber = lotto.hasSameNumber(lottoNumber)
        // then
        assertThat(hasSameNumber).isTrue()
    }

    companion object {
        private const val MIN_RANGE: Int = 1
        private const val MAX_RANGE: Int = 45
    }
}
