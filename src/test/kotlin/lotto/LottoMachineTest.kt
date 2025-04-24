package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoMachineTest {
    private val lottoMachine = LottoMachine()

    @Test
    fun `should throw exception when amount is less than ticket price`() {
        assertThatThrownBy { lottoMachine.buyLottos(500) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Purchase amount must be at least 1,000 KRW.")
    }

    @Test
    fun `should throw exception when amount is not divisible by ticket price`() {
        assertThatThrownBy { lottoMachine.buyLottos(2500) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Purchase amount must be divisible by 1,000.")
    }

    @Test
    fun `should return correct number of lotto tickets`() {
        val lottos = lottoMachine.buyLottos(5000)
        assertThat(lottos).hasSize(5)
        lottos.forEach { lotto ->
            assertThat(lotto.numbers).hasSize(6)
            assertThat(lotto.numbers).allMatch { it in 1..45 }
            assertThat(lotto.numbers).doesNotHaveDuplicates()
        }
    }

    @Test
    fun `should calculate correct results`() {
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7

        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)), // 6 matches
            Lotto(listOf(1, 2, 3, 4, 5, 7)), // 5 + bonus
            Lotto(listOf(1, 2, 3, 4, 5, 8)), // 5 matches
            Lotto(listOf(1, 2, 3, 4, 8, 9)), // 4 matches
            Lotto(listOf(1, 2, 3, 8, 9, 10)), // 3 matches
            Lotto(listOf(8, 9, 10, 11, 12, 13)) // 0 matches
        )
        val results = lottoMachine.checkResults(lottos, winningNumbers, bonusNumber)
        assertThat(results[LottoResult.FIRST]).isEqualTo(1)
        assertThat(results[LottoResult.SECOND]).isEqualTo(1)
        assertThat(results[LottoResult.THIRD]).isEqualTo(1)
        assertThat(results[LottoResult.FOURTH]).isEqualTo(1)
        assertThat(results[LottoResult.FIFTH]).isEqualTo(1)
        assertThat(results[LottoResult.NONE]).isEqualTo(1)
    }

    @Test
    fun `should calculate correct profit rate`() {
        val results = mapOf(
            LottoResult.FIRST to 1,  // 2_000_000_000
            LottoResult.SECOND to 0,
            LottoResult.THIRD to 0,
            LottoResult.FOURTH to 0,
            LottoResult.FIFTH to 0,
            LottoResult.NONE to 0
        )
        val purchasedAmount = 1_000
        val profitRate = lottoMachine.calculateProfitRate(results, purchasedAmount)
        assertThat(profitRate).isEqualTo(2_000_000_000.0 / purchasedAmount * 100)
    }
}
