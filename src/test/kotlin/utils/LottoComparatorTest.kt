package utils

import lotto.Lotto
import model.Prize
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoComparatorTest {

    @Test
    fun `should classify lotto as FIRST_PRIZE when all numbers match`() {
        // Arrange
        val purchase = Purchase(
            listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        )
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val comparator = LottoComparator()

        // Act
        comparator.compare(purchase, winningLotto, bonusNumber)
        val result = comparator.getResult()

        // Assert
        assertEquals(1, result[Prize.FIRST_PRIZE])
    }

    @Test
    fun `should classify lotto as SECOND_PRIZE when 5 numbers + bonus match`() {
        // Arrange
        val purchase = Purchase(
            listOf(Lotto(listOf(1, 2, 3, 4, 5, 7))) // 5 match + bonus number
        )
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val comparator = LottoComparator()

        // Act
        comparator.compare(purchase, winningLotto, bonusNumber)
        val result = comparator.getResult()

        // Assert
        assertEquals(1, result[Prize.SECOND_PRIZE])
    }

    @Test
    fun `should classify lotto as THIRD_PRIZE when 5 numbers match`() {
        // Arrange
        val purchase = Purchase(
            listOf(Lotto(listOf(1, 2, 3, 4, 5, 10))) // 5 match, no bonus
        )
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val comparator = LottoComparator()

        // Act
        comparator.compare(purchase, winningLotto, bonusNumber)
        val result = comparator.getResult()

        // Assert
        assertEquals(1, result[Prize.THIRD_PRIZE])
    }

    @Test
    fun `should classify lotto as FORTH_PRIZE when 4 numbers match`() {
        // Arrange
        val purchase = Purchase(
            listOf(Lotto(listOf(1, 2, 3, 4, 10, 11)))
        )
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val comparator = LottoComparator()

        // Act
        comparator.compare(purchase, winningLotto, bonusNumber)
        val result = comparator.getResult()

        // Assert
        assertEquals(1, result[Prize.FORTH_PRIZE])
    }

    @Test
    fun `should classify lotto as FIFTH_PRIZE when 3 numbers match`() {
        // Arrange
        val purchase = Purchase(
            listOf(Lotto(listOf(1, 2, 3, 10, 11, 12)))
        )
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val comparator = LottoComparator()

        // Act
        comparator.compare(purchase, winningLotto, bonusNumber)
        val result = comparator.getResult()

        // Assert
        assertEquals(1, result[Prize.FIFTH_PRIZE])
    }
}
