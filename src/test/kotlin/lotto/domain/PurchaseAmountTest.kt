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
    fun `givenAmountNotDivisibleByThousand_whenCreatePurchaseAmount_thenThrowException`() {
        val amount = 2500
        assertThrows<IllegalArgumentException> {
            PurchaseAmount(amount)
        }
    }

    @Test
    fun `givenPurchaseAmount_whenCallValueFunction_thenReturnAmount`() {
        val amount = 15000
        val purchaseAmount = PurchaseAmount(amount)
        val result = purchaseAmount.value()
        val expected = purchaseAmount.countPurchasableLottos()
        assertEquals(15000, result)
        assertEquals(15, expected)
    }

    @ParameterizedTest
    @CsvSource(
        "1000, 1",
        "2000, 2",
        "3000, 3",
        "5000, 5",
        "10000, 10",
        "100000, 100"
    )
    fun `givenVariousAmounts_whenCountPurchasableLottos_thenReturnCorrectCount`(amount: Int, expectedCount: Int) {
        val purchaseAmount = PurchaseAmount(amount)
        val result = purchaseAmount.countPurchasableLottos()
        assertEquals(expectedCount, result)
    }
}