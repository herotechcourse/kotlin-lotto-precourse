package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals

class WinningNumbersTest {

    @Test
    fun `givenValidNumbers_whenCreateWinningNumbers_thenSuccess`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = WinningNumbers(numbers)
        assertEquals(6, winningNumbers.getNumbers().size)
    }

    @Test
    fun `givenInvalidSizeNumbers1_whenCreateWinningNumbers_thenThrowException`() {
        val numbers = listOf(1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            WinningNumbers(numbers)
        }
    }

    @Test
    fun `givenInvalidSizeNumbers2_whenCreateWinningNumbers_thenThrowException`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
        assertThrows<IllegalArgumentException> {
            WinningNumbers(numbers)
        }
    }

    @Test
    fun `givenDuplicateNumbers_whenCreateWinningNumbers_thenThrowException`() {
        val numbers = listOf(1, 2, 3, 4, 5, 5)
        assertThrows<IllegalArgumentException> {
            WinningNumbers(numbers)
        }
    }

    @Test
    fun `givenOutOfRangeNumbers_whenCreateWinningNumbers_thenThrowException`() {
        val numbers = listOf(0, 1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            WinningNumbers(numbers)
        }
    }

    @Test
    fun `givenWinningNumbersAndLottoNumbers_whenCountMatches_thenReturnMatchCount`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        val lottoNumbers = listOf(1, 2, 3, 43, 44, 45)
        val matchCount = winningNumbers.countMatches(lottoNumbers)
        assertEquals(3, matchCount)
    }

    @Test
    fun `givenWinningNumbers_whenCheckBonusNumber_thenReturnCorrectResult`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        val bonusIncluded = winningNumbers.contains(6)
        val bonusNotIncluded = winningNumbers.contains(9)
        assertEquals(true, bonusIncluded)
        assertEquals(false, bonusNotIncluded)
    }
}
