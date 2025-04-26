package lotto.controller

import lotto.constants.Constants
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoProgramTest {
    @Test
    fun `issueLottery - returns correct number of Lotto instances`() {
        val purchaseAmount = 42000
        val expectedLottoCount = purchaseAmount / Constants.LOTTO_PURCHASE_UNIT

        val lottoStorage = issueLottery(purchaseAmount)
        val lottery = lottoStorage.getAll()

        assertEquals(expectedLottoCount, lottery.size)
        lottery.forEach { lotto ->
            assertEquals(Constants.LOTTO_NUMBERS_COUNT, lotto.getNumbers().size)
        }
    }
}