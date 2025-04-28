package lotto

import lotto.domain.BonusNumber
import lotto.domain.LottoGenerator
import lotto.domain.LottoRank
import lotto.domain.WinningNumbers
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

    @Test
    fun `throws an exception when lotto numbers are not in valid range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 50))
        }

        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
    }

    @ParameterizedTest
    @MethodSource("provideLottoAndExpectedRank")
    fun `match with winning numbers and bonus number`(lottoNumbersAndExpectedRank: Pair<List<Int>, LottoRank>) {
        val (lottoNumbers, expectedRank) = lottoNumbersAndExpectedRank
        val lotto = Lotto(lottoNumbers)

        assertThat(lotto.match(winningNumbers, bonusNumber)).isEqualTo(expectedRank)
    }

    companion object {
        @JvmStatic
        fun provideLottoAndExpectedRank() = listOf(
            listOf(1, 2, 3, 4, 5, 6) to LottoRank.FIRST,
            listOf(1, 2, 3, 4, 5, 7) to LottoRank.SECOND,
            listOf(1, 2, 3, 4, 5, 9) to LottoRank.THIRD,
            listOf(1, 2, 3, 4, 8, 9) to LottoRank.FOURTH,
            listOf(1, 2, 3, 4, 7, 9) to LottoRank.FOURTH,
            listOf(1, 2, 3, 8, 9, 10) to LottoRank.FIFTH,
            listOf(1, 2, 3, 7, 9, 10) to LottoRank.FIFTH,
            listOf(1, 2, 7, 8, 9, 10) to LottoRank.NONE
        )

        private val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        private val bonusNumber = BonusNumber(7)
    }
}
