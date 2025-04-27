package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `throws an exception when lotto less than 1 or more than 45`(input: Int) {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(input, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `create lotto with valid numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        assertEquals(numbers, lotto.getNumbers())
    }

    @Test
    fun `generateLottoList creates the correct number of lotto tickets`() {
        val purchaseAmount = PurchaseAmount(3000)
        val lottoList = Lotto.generateLottoList(purchaseAmount)

        assertEquals(3, lottoList.size)
        lottoList.forEach { lotto ->
            assertEquals(6, lotto.getNumbers().size)
            assertTrue(lotto.getNumbers().all { it in Lotto.LOTTO_MIN_NUMBER..Lotto.LOTTO_MAX_NUMBER })
            assertEquals(lotto.getNumbers().toSet().size, lotto.getNumbers().size)
            assertEquals(lotto.getNumbers(), lotto.getNumbers().sorted())
        }
    }
}
