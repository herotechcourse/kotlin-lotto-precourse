package lotto.common

import lotto.Lotto
import lotto.model.Prize
import lotto.model.Rank
import lotto.model.Winner
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class LottoUtilTest {

    @Nested
    @DisplayName("isValidLottoNumber tests")
    inner class IsValidLottoNumberTests {

        @ParameterizedTest
        @ValueSource(ints = [1, 23, 45])
        @DisplayName("Should return true for valid lotto numbers")
        fun isValidLottoNumber_validNumbers_returnsTrue(number: Int) {
            assertThat(LottoUtil.isValidLottoNumber(number)).isTrue()
        }

        @ParameterizedTest
        @ValueSource(ints = [0, -5, 46, 100])
        @DisplayName("Should return false for invalid lotto numbers")
        fun isValidLottoNumber_invalidNumbers_returnsFalse(number: Int) {
            assertThat(LottoUtil.isValidLottoNumber(number)).isFalse()
        }

        @Test
        @DisplayName("Should return false for null input")
        fun isValidLottoNumber_nullInput_returnsFalse() {
            assertThat(LottoUtil.isValidLottoNumber(null)).isFalse()
        }
    }

    @Nested
    @DisplayName("isValidLottoSize tests")
    inner class IsValidLottoSizeTests {

        @Test
        @DisplayName("Should return true for list with exactly 6 elements")
        fun isValidLottoSize_sixElements_returnsTrue() {
            val list = listOf(1, 2, 3, 4, 5, 6)
            assertThat(LottoUtil.isValidLottoSize(list)).isTrue()
        }

        @Test
        @DisplayName("Should return false for list with fewer than 6 elements")
        fun isValidLottoSize_fewerThanSixElements_returnsFalse() {
            val list = listOf(1, 2, 3, 4, 5)
            assertThat(LottoUtil.isValidLottoSize(list)).isFalse()
        }

        @Test
        @DisplayName("Should return false for list with more than 6 elements")
        fun isValidLottoSize_moreThanSixElements_returnsFalse() {
            val list = listOf(1, 2, 3, 4, 5, 6, 7)
            assertThat(LottoUtil.isValidLottoSize(list)).isFalse()
        }

        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("Should return false for empty list")
        fun isValidLottoSize_emptyList_returnsFalse(list: List<Int>?) {
            assertThat(LottoUtil.isValidLottoSize(list ?: emptyList())).isFalse()
        }
    }

    @Test
    @DisplayName("generateNumbers should return 6 unique numbers between 1 and 45")
    fun generateNumbers_returnsValidLottoNumbers() {
        val numbers = LottoUtil.generateNumbers()

        assertThat(numbers).hasSize(6)
        assertThat(numbers).isSubsetOf((1..45).toList())
        assertThat(numbers).doesNotHaveDuplicates()
    }

    @Nested
    @DisplayName("getMatchCount tests")
    inner class GetMatchCountTests {

        @Test
        @DisplayName("Should correctly count matching numbers")
        fun getMatchCount_countsMatches() {
            val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
            val winner = Winner(listOf(1, 2, 3, 7, 8, 9), 10)

            assertThat(LottoUtil.getMatchCount(lotto, winner)).isEqualTo(3)
        }

        @Test
        @DisplayName("Should return 0 when no matches")
        fun getMatchCount_noMatches_returnsZero() {
            val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
            val winner = Winner(listOf(7, 8, 9, 10, 11, 12), 13)

            assertThat(LottoUtil.getMatchCount(lotto, winner)).isEqualTo(0)
        }

        @Test
        @DisplayName("Should return 6 when all numbers match")
        fun getMatchCount_allMatches_returnsSix() {
            val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
            val winner = Winner(listOf(1, 2, 3, 4, 5, 6), 7)

            assertThat(LottoUtil.getMatchCount(lotto, winner)).isEqualTo(6)
        }
    }

    @Nested
    @DisplayName("isMatchBonus tests")
    inner class IsMatchBonusTests {

        @Test
        @DisplayName("Should return true when lotto contains bonus number")
        fun isMatchBonus_containsBonus_returnsTrue() {
            val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))

            assertThat(LottoUtil.isMatchBonus(lotto, 7)).isTrue()
        }

        @Test
        @DisplayName("Should return false when lotto does not contain bonus number")
        fun isMatchBonus_doesNotContainBonus_returnsFalse() {
            val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

            assertThat(LottoUtil.isMatchBonus(lotto, 7)).isFalse()
        }
    }

    @Nested
    @DisplayName("calculateProfit tests")
    inner class CalculateProfitTests {

        @Test
        @DisplayName("Should calculate total profit correctly")
        fun calculateProfit_sumsPrizeRewards() {
            val prizes = listOf(
                Prize(3, false),
                Prize(4, false),
                Prize(5, false)
            )

            val expectedProfit = 5_000 + 50_000 + 1_500_000
            assertThat(LottoUtil.calculateProfit(prizes)).isEqualTo(expectedProfit)
        }

        @Test
        @DisplayName("Should return 0 for empty prize list")
        fun calculateProfit_emptyList_returnsZero() {
            assertThat(LottoUtil.calculateProfit(emptyList())).isEqualTo(0)
        }
    }

    @Nested
    @DisplayName("calculateProfitRate tests")
    inner class CalculateProfitRateTests {

        @ParameterizedTest
        @CsvSource(
            "5000, 1000, 500.0",
            "0, 1000, 0.0",
            "1500, 1000, 150.0"
        )
        @DisplayName("Should calculate profit rate correctly")
        fun calculateProfitRate_calculatesCorrectRate(profit: Int, spent: Int, expected: Double) {
            assertThat(LottoUtil.calculateProfitRate(profit, spent)).isEqualTo(expected)
        }

        @Test
        @DisplayName("Should round profit rate to one decimal place")
        fun calculateProfitRate_roundsToOneDecimal() {
            val profit = 1234
            val spent = 1000

            // 1234/1000 * 100 = 123.4, rounded to 123.4
            assertThat(LottoUtil.calculateProfitRate(profit, spent)).isEqualTo(123.4)
        }
    }
}