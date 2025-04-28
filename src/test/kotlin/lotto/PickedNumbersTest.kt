package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PickedNumbersTest {
    @Test
    fun `throws an exception when winning numbers are not six`() {
        assertThrows<IllegalArgumentException> {
            PickedNumbers(listOf(1, 2, 3, 4, 5), 7)
        }
    }

    @Test
    fun `throws an exception when winning numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            PickedNumbers(listOf(1, 2, 2, 4, 5, 6), 7)
        }
    }

    @Test
    fun `throws an exception when winning numbers are out of range`() {
        assertThrows<IllegalArgumentException> {
            PickedNumbers(listOf(0, 2, 3, 4, 5, 6), 7)
        }
        assertThrows<IllegalArgumentException> {
            PickedNumbers(listOf(1, 2, 3, 4, 5, 46), 7)
        }
    }

    @Test
    fun `throws an exception when bonus number is out of range`() {
        assertThrows<IllegalArgumentException> {
            PickedNumbers(listOf(1, 2, 3, 4, 5, 6), 0)
        }
        assertThrows<IllegalArgumentException> {
            PickedNumbers(listOf(1, 2, 3, 4, 5, 6), 46)
        }
    }

    @Test
    fun `throws an exception when bonus number overlaps with winning numbers`() {
        assertThrows<IllegalArgumentException> {
            PickedNumbers(listOf(1, 2, 3, 4, 5, 6), 6)
        }
    }

    @Test
    fun `returns correct match count`() {
        val pickedNumbers = PickedNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(listOf(1, 2, 7, 8, 9, 10))

        val matchCount = pickedNumbers.matchCountOf(lotto)

        assertThat(matchCount).isEqualTo(2) // 1, 2 매칭
    }

    @Test
    fun `returns true if lotto contains bonus number`() {
        val pickedNumbers = PickedNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(listOf(7, 8, 9, 10, 11, 12))

        val hasBonus = pickedNumbers.hasBonusNumber(lotto)

        assertThat(hasBonus).isTrue()
    }

    @Test
    fun `returns false if lotto does not contain bonus number`() {
        val pickedNumbers = PickedNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(listOf(8, 9, 10, 11, 12, 13))

        val hasBonus = pickedNumbers.hasBonusNumber(lotto)

        assertThat(hasBonus).isFalse()
    }
}