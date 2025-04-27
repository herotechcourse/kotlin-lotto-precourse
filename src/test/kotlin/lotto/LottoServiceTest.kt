package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class LottoServiceTest {
    private val lottoService = LottoService()

    @Test
    fun `throws an exception when purchase amount is not divisible by 1000`() {
        assertThrows<IllegalArgumentException> {
            lottoService.purchaseLottos(1500)
        }
    }

    @Test
    fun `throws an exception when purchase amount is zero or negative`() {
        assertThrows<IllegalArgumentException> {
            lottoService.purchaseLottos(0)
        }
        
        assertThrows<IllegalArgumentException> {
            lottoService.purchaseLottos(-1000)
        }
    }

    @Test
    fun `purchases correct number of lottos`() {
        val lottos = lottoService.purchaseLottos(5000)
        
        assertThat(lottos).hasSize(5)
        lottos.forEach {
            assertThat(it).isInstanceOf(Lotto::class.java)
        }
    }

    @Test
    fun `calculates results correctly`() {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6)) // 6 matches - 1st prize
        val lotto2 = Lotto(listOf(1, 2, 3, 4, 5, 7)) // 5 matches + bonus - 2nd prize
        val lotto3 = Lotto(listOf(1, 2, 3, 4, 5, 8)) // 5 matches - 3rd prize
        val lottos = listOf(lotto1, lotto2, lotto3)
        
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        
        val results = lottoService.calculateResults(lottos, winningNumbers, bonusNumber)
        
        assertThat(results[LottoRank.FIRST]).isEqualTo(1)
        assertThat(results[LottoRank.SECOND]).isEqualTo(1)
        assertThat(results[LottoRank.THIRD]).isEqualTo(1)
        assertThat(results[LottoRank.FOURTH]).isEqualTo(0)
        assertThat(results[LottoRank.FIFTH]).isEqualTo(0)
        assertThat(results[LottoRank.NONE]).isEqualTo(0)
    }

    @Test
    fun `calculates total prize correctly`() {
        val results = mapOf(
            LottoRank.FIRST to 1,
            LottoRank.SECOND to 2,
            LottoRank.THIRD to 3,
            LottoRank.FOURTH to 4,
            LottoRank.FIFTH to 5,
            LottoRank.NONE to 0
        )
        
        val expectedTotal = LottoRank.FIRST.prize + 
                           (2 * LottoRank.SECOND.prize) + 
                           (3 * LottoRank.THIRD.prize) +
                           (4 * LottoRank.FOURTH.prize) +
                           (5 * LottoRank.FIFTH.prize)
        
        val totalPrize = lottoService.calculateTotalPrize(results)
        
        assertThat(totalPrize).isEqualTo(expectedTotal)
    }

    @Test
    fun `calculates profit rate correctly`() {
        val prize = 5000L
        val purchaseAmount = 10000
        
        val profitRate = lottoService.calculateProfitRate(prize, purchaseAmount)
        
        assertThat(profitRate).isEqualTo(50.0)
    }
}