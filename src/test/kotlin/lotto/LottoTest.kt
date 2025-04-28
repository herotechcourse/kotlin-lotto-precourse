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
            Lotto(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6),
                    LottoNumber(7)
                )
            )
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(5)
                )
            )
        }
    }

    @Test
    fun `can count matching numbers between two lotto`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val comparisonNumbers = listOf(4, 5, 6, 7, 8, 9)
        val lotto = createLotto(numbers)
        val comparisonLotto = createLotto(comparisonNumbers)
        // when
        val matchingCount = lotto.countSameNumber(comparisonLotto)
        // then
        assertThat(matchingCount).isEqualTo(3)
    }

    @ParameterizedTest
    @ValueSource(ints = [11, 20, 40])
    fun `should return true when lotto does not contain the given number`(lottoNumber: Int) {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = createLotto(numbers)
        // when
        val isNotContained = lotto.doesNotContain(LottoNumber(lottoNumber))
        // then
        assertThat(isNotContained).isTrue()
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6])
    fun `should return true when lotto contains a same lotto number`(lottoNumber: Int) {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = createLotto(numbers)
        // when
        val hasSameNumber = lotto.hasSameNumber(LottoNumber(lottoNumber))
        // then
        assertThat(hasSameNumber).isTrue()
    }

    private fun createLotto(numbers: List<Int>): Lotto {
        return Lotto(
            listOf(
                LottoNumber(numbers[0]),
                LottoNumber(numbers[1]),
                LottoNumber(numbers[2]),
                LottoNumber(numbers[3]),
                LottoNumber(numbers[4]),
                LottoNumber(numbers[5])
            )
        )
    }


}
