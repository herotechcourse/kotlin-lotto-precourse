package lotto

import org.assertj.core.api.Assertions.assertThat
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
}
