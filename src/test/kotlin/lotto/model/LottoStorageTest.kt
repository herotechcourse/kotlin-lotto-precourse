package lotto.model

import lotto.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoStorageTest {
    @Test
    fun `returns the same lottery list that was saved`() {
        val lottoList = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12)),
            Lotto(listOf(13, 14, 15, 16, 17, 18))
        )
        val lottoStorage = LottoStorage(lottoList)
        val storedLottery = lottoStorage.getAll()

        assertEquals(lottoList, storedLottery)
    }
}