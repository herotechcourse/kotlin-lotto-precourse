package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.api.Assertions.assertEquals

class PurchaseAmountTest {

    @Test
    fun `givenValidAmount_whenCreatePurchaseAmount_thenSuccess`() {
        val amount = 1000
        val purchaseAmount = PurchaseAmount(amount)
        assertEquals(1000, purchaseAmount.value())
    }

    @Test
    fun `givenAmountLessThanThousand_whenCreatePurchaseAmount_thenThrowException`() {
        val amount = 999
        assertThrows<IllegalArgumentException> {
            PurchaseAmount(amount)
        }
    }

    @Test
    fun `givenAmountNotDivisibleByThousandButPurchasable_whenCreatePurchaseAmount_thenReturnCorrectCount`() {
        val amount = 2500
        val purchaseAmount = PurchaseAmount(amount)
        val result = purchaseAmount.countPurchasableLottos()
        assertEquals(2, result)
    }

    @Test
    fun `givenPurchaseAmount_whenCallValueFunction_thenReturnAmount`() {
        val amount = 9999
        val purchaseAmount = PurchaseAmount(amount)
        val result = purchaseAmount.value()
        assertEquals(9999, result)
    }

    @ParameterizedTest
    @CsvSource(
        "1000, 1",
        "1400, 1",
        "2700, 2",
        "3000, 3",
        "5999, 5",
        "99999, 99",
        "100000, 100"
    )
    fun `givenVariousAmounts_whenCountPurchasableLottos_thenReturnCorrectCount`(amount: Int, expectedCount: Int) {
        val purchaseAmount = PurchaseAmount(amount)
        val result = purchaseAmount.countPurchasableLottos()
        assertEquals(expectedCount, result)
    }
}