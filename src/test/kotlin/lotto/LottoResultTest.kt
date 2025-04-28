package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `should return 1st prize when matching all 6 numbers`() {
        val lottoList = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7)

        val result = LottoResult.from(lottoList, winningNumber, bonusNumber)

        assertThat(result.getResult()[LottoResult.LottoPrize.PRIZE_1ST]).isEqualTo(1)
    }

    @Test
    fun `creates LottoResult correctly based on winning numbers and bonus number`() {
    fun `should return 2nd prize when matching 5 numbers and bonus`() {
        val lottoList = listOf(Lotto(listOf(1, 2, 3, 4, 5, 7)))
        val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7)

        val result = LottoResult.from(lottoList, winningNumber, bonusNumber)

        assertThat(result.getResult()[LottoResult.LottoPrize.PRIZE_2ND]).isEqualTo(1)
    }

    @Test
    fun `should return 3rd prize when matching 5 numbers without bonus`() {
        val lottoList = listOf(Lotto(listOf(1, 2, 3, 4, 5, 8)))
        val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7)

        val result = LottoResult.from(lottoList, winningNumber, bonusNumber)

        assertThat(result.getResult()[LottoResult.LottoPrize.PRIZE_3RD]).isEqualTo(1)
    }

    @Test
    fun `should return 5th prize when matching 3 numbers`() {
        val lottoList = listOf(Lotto(listOf(1, 2, 3, 7, 8, 9)))
        val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(10)

        val result = LottoResult.from(lottoList, winningNumber, bonusNumber)

        assertThat(result.getResult()[LottoResult.LottoPrize.PRIZE_5TH]).isEqualTo(1)
    }

    @Test
    fun `should return all 0 when no numbers match`() {
        val lottoList = listOf(Lotto(listOf(11, 12, 13, 14, 15, 16)))
        val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7)

        val result = LottoResult.from(lottoList, winningNumber, bonusNumber)

        LottoResult.LottoPrize.entries.forEach {
            assertThat(result.getResult()[it]).isEqualTo(0)
        }
    }

    @Test
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
