package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals

class LottoTest {

    @Test
    fun `givenValidSixNumbers_whenCreateLotto_thenSuccess`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        assertEquals(6, lotto.getNumbers().size)
    }

    @Test
    fun `givenLessThanSixNumbers_whenCreateLotto_thenThrowException`() {
        val numbers = listOf(1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @Test
    fun `givenMoreThanSixNumbers_whenCreateLotto_thenThrowException`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `givenDuplicatedNumbers_whenCreateLotto_thenThrowException`() {
        val numbers = listOf(1, 2, 3, 4, 5, 5)
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @Test
    fun `givenOutOfRangeNumbers_whenCreateLotto_thenThrowException`() {
        val numbers = listOf(0, 1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @Test
    fun `givenWinningNumbers_whenCountMatchedNumbers_thenReturnCorrectCount`() {
        val numbers = listOf(1, 2, 3, 43, 44, 45)
        val lotto = Lotto(numbers)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val matchCount = lotto.countMatchedNumbers(winningNumbers)
        assertEquals(3, matchCount)
    }

    @Test
    fun `givenBonusNumber_whenCheckIsBonusNumber_thenReturnTrue`() {
        val numbers = listOf(1, 2, 3, 10, 11, 12)
        val lotto = Lotto(numbers)
        val checkBonus = lotto.isBonusNumber(10)
        assertEquals(true, checkBonus)
    }
}