package lotto

import lotto.util.Constants
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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
    fun `throws an exception when lotto numbers are less than 1`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are greater than 45`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `getNumbers should return a new list instance on each call`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val number1 = lotto.getNumbers()
        val number2 = lotto.getNumbers()
        assertThat(number1).isEqualTo(number2)
    }

    @Test
    fun `countMatch should return 0 when there are no matches`() {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(7, 8, 9, 10, 11, 12))
        assertThat(0).isEqualTo(lotto1.countMatch(lotto2))
    }

    @Test
    fun `countMatch should return the correct number of matches when there are some matches`() {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(5, 6, 7, 8, 9, 10))
        assertThat(2).isEqualTo(lotto1.countMatch(lotto2))
    }

    @Test
    fun `countMatch should return 6 when all numbers match`() {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(Constants.LOTTO_NUMBER_COUNT).isEqualTo(lotto1.countMatch(lotto2))
    }

    @Test
    fun `countMatch should correctly count matches regardless of the order`() {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(6, 5, 4, 3, 2, 1))
        assertThat(Constants.LOTTO_NUMBER_COUNT).isEqualTo(lotto1.countMatch(lotto2))
    }

    @Test
    fun `lotto objects with the same numbers should be equal`() {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertThat(lotto1).isEqualTo(lotto2)
    }

    @Test
    fun `toString should return the numbers in the expected format`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat("[1, 2, 3, 4, 5, 6]").isEqualTo(lotto.toString())
    }
}
