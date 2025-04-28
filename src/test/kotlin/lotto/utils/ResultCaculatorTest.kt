package lotto.utils

import lotto.Lotto
import lotto.Lottos
import lotto.WinningNumbers
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ResultCaculatorTest {
    @Test
    fun `calculates the correct number of matches`() {
        val winningNumbers = WinningNumbers(listOf("1", "2", "3", "4", "5", "6"), "11")
        val lotto = Lotto(listOf(1, 2, 3, 8, 9, 10))
        val lottos = Lottos(mutableListOf(lotto),0)
        val expectedMatches = "3"

        val result = ResultCalculator.calculateMatches(lottos, winningNumbers)

        assertEquals(1, result["3"])
    }
    @Test
    fun `calculates the correct number of matches with bonus`() {
        val winningNumbers = WinningNumbers(listOf("1", "2", "3", "4", "5", "6"), "7")
        val lotto = Lotto(listOf(1,2,3,4,5,7))
        val lottos = Lottos(mutableListOf(lotto),0)

        val result = ResultCalculator.calculateMatches(lottos, winningNumbers)

        assertEquals(1, result["5+bonus"])
    }

}