package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class PurchasedLottoTest {

    @ParameterizedTest
    @MethodSource("lottoNumbersAndExpectedMatchCount")
    fun `return correct count matched numbers with winning numbers`(lottoNumbers: List<Int>, expectedCount: Int) {
        //given
        val purchasedLotto = PurchasedLotto(lottoNumbers)
        val winningNumbers = Lotto(listOf(1,2,3,4,40,45))

        //when
        val matchCount = purchasedLotto.countMatchedNumbersWithWinningNumbers(winningNumbers)

        //then
        assertThat(matchCount).isEqualTo(expectedCount)
    }

    @ParameterizedTest
    @MethodSource("lottoNumbersAndMatchBonusNumber")
    fun `return bonus number is contain in lotto numbers`(lottoNumbers: List<Int>, expectedBoolean: Boolean) {
        //given
        val purchasedLotto = PurchasedLotto(lottoNumbers)
        val bonusNumber = 45

        //when
        val isMatchBonusNumber = purchasedLotto.isMatchedWithBonusNumber(bonusNumber)
        //then
        assertThat(isMatchBonusNumber).isEqualTo(expectedBoolean)
    }

    companion object {
        @JvmStatic
        fun lottoNumbersAndExpectedMatchCount(): List<Arguments> = listOf (
            Arguments.arguments(listOf(1, 2, 3, 4, 5, 6), 4),
            Arguments.arguments(listOf(40, 41, 42, 43, 44, 45), 2)
        )

        @JvmStatic
        fun lottoNumbersAndMatchBonusNumber(): List<Arguments> = listOf (
            Arguments.arguments(listOf(1, 2, 3, 4, 5, 6), false),
            Arguments.arguments(listOf(40, 41, 42, 43, 44, 45), true)
        )
    }
}