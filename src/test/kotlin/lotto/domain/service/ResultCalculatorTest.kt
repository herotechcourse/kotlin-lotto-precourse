package lotto.domain.service

import lotto.Lotto
import lotto.domain.model.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ResultCalculatorTest {

    private val calculator = ResultCalculator()

    private fun winningNumbers(): WinningNumbers {
        return WinningNumbers(
            WinningNumber(listOf(1, 2, 3, 4, 5, 6)),
            BonusNumber(7, listOf(1, 2, 3, 4, 5, 6))
        )
    }

    @Test
    @DisplayName("Returns 1st rank when matching all 6 numbers")
    fun sixMatches_returnsFirstRank() {
        // given
        val lotties = Lotties(listOf(Lotto(listOf(1, 2, 3, 4, 5, 6))))

        // when
        val result = calculator.calculateTotalMatch(lotties, winningNumbers())

        // then
        assertEquals(1, result.getResult()[Rank.FIRST])
    }

    @Test
    @DisplayName("Returns 2nd rank when matching 5 numbers and the bonus number")
    fun fiveMatchesAndBonus_returnsSecondRank() {
        // given
        val lotties = Lotties(listOf(Lotto(listOf(1, 2, 3, 4, 5, 7))))

        // when
        val result = calculator.calculateTotalMatch(lotties, winningNumbers())

        // then
        assertEquals(1, result.getResult()[Rank.SECOND])
    }

    @Test
    @DisplayName("Returns 3rd rank when matching 5 numbers without the bonus number")
    fun fiveMatchesOnly_returnsThirdRank() {
        // given
        val lotties = Lotties(listOf(Lotto(listOf(1, 2, 3, 4, 5, 8))))

        // when
        val result = calculator.calculateTotalMatch(lotties, winningNumbers())

        // then
        assertEquals(1, result.getResult()[Rank.THIRD])
    }

    @Test
    @DisplayName("Returns 4th rank when matching 4 numbers")
    fun fourMatches_returnsFourthRank() {
        // given
        val lotties = Lotties(listOf(Lotto(listOf(1, 2, 3, 4, 7, 8))))

        // when
        val result = calculator.calculateTotalMatch(lotties, winningNumbers())

        // then
        assertEquals(1, result.getResult()[Rank.FOURTH])
    }

    @Test
    @DisplayName("Returns 5th rank when matching 3 numbers")
    fun threeMatches_returnsFifthRank() {
        // given
        val lotties = Lotties(listOf(Lotto(listOf(1, 2, 3, 7, 8, 9))))

        // when
        val result = calculator.calculateTotalMatch(lotties, winningNumbers())

        // then
        assertEquals(1, result.getResult()[Rank.FIFTH])
    }

    @Test
    @DisplayName("Returns NONE when matching less than 3 numbers")
    fun twoOrLessMatches_returnsNone() {
        // given
        val lotties = Lotties(listOf(Lotto(listOf(1, 2, 7, 8, 9, 10))))

        // when
        val result = calculator.calculateTotalMatch(lotties, winningNumbers())

        // then
        assertEquals(1, result.getResult()[Rank.NONE])
    }
}
