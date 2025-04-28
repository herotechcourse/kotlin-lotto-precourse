package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `creates LottoResult correctly based on winning numbers and bonus number`() {
        val lottoList = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 8)),
            Lotto(listOf(1, 2, 3, 4, 7, 8)),
            Lotto(listOf(1, 2, 3, 7, 8, 9))
        )
        val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7)

        val lottoResult = LottoResult.from(lottoList, winningNumber, bonusNumber)
        val result = lottoResult.getResult()

        assertEquals(1, result[LottoResult.LottoPrize.PRIZE_1ST])
        assertEquals(1, result[LottoResult.LottoPrize.PRIZE_2ND])
        assertEquals(1, result[LottoResult.LottoPrize.PRIZE_3RD])
        assertEquals(1, result[LottoResult.LottoPrize.PRIZE_4TH])
        assertEquals(1, result[LottoResult.LottoPrize.PRIZE_5TH])
    }
}
