package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoTest {


    @Test
    fun `should return first prize when all numbers match`() {
        // Testing FirstPrize
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val lotto = Lotto(lottoNumbers)

        val prize = lotto.findMatches(winningNumbers, bonusNumber)
        assertEquals(Prize.FirstPrize, prize)
        assertEquals(2_000_000_000, prize.prizeMoney)  // Check prize money
    }

    @Test
    fun `should return second prize when 5 numbers match and bonus number matches`() {
        // Testing SecondPrize (5 numbers + bonus match)
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 7)
        val bonusNumber = 6

        val lotto = Lotto(lottoNumbers)

        val prize = lotto.findMatches(winningNumbers, bonusNumber)
        assertEquals(Prize.SecondPrize, prize)
        assertEquals(30_000_000, prize.prizeMoney)  // Check prize money
    }

    @Test
    fun `should return third prize when 5 numbers match but bonus number does not match`() {
        // Testing ThirdPrize (5 numbers match, no bonus match)
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 7)
        val bonusNumber = 8

        val lotto = Lotto(lottoNumbers)

        val prize = lotto.findMatches(winningNumbers, bonusNumber)
        assertEquals(Prize.ThirdPrize, prize)
        assertEquals(1_500_000, prize.prizeMoney)  // Check prize money
    }

    @Test
    fun `should return fourth prize when 4 numbers match`() {
        // Testing FourthPrize (4 numbers match)
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = listOf(1, 2, 3, 4, 8, 9)
        val bonusNumber = 10

        val lotto = Lotto(lottoNumbers)

        val prize = lotto.findMatches(winningNumbers, bonusNumber)
        assertEquals(Prize.FourthPrize, prize)
        assertEquals(50_000, prize.prizeMoney)  // Check prize money
    }

    @Test
    fun `should return fifth prize when 3 numbers match`() {
        // Testing FifthPrize (3 numbers match)
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = listOf(1, 2, 3, 10, 11, 12)
        val bonusNumber = 13

        val lotto = Lotto(lottoNumbers)

        val prize = lotto.findMatches(winningNumbers, bonusNumber)
        assertEquals(Prize.FifthPrize, prize)
        assertEquals(5_000, prize.prizeMoney)  // Check prize money
    }

    @Test
    fun `should return no prize when no numbers match`() {
        // Testing None prize (no match)
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = listOf(7, 8, 9, 10, 11, 12)
        val bonusNumber = 13

        val lotto = Lotto(lottoNumbers)

        val prize = lotto.findMatches(winningNumbers, bonusNumber)
        assertEquals(Prize.None, prize)
        assertEquals(0, prize.prizeMoney)  // Check prize money
    }

}

