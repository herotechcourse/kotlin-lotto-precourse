package lotto

import lotto.domain.BonusNumber
import lotto.domain.ResultCalculator
import lotto.domain.WinningNumbers
import lotto.domain.Rank
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class ResultCalculatorTest{
    private val calculator = ResultCalculator()
    private val winningNumbers = WinningNumbers("1,2,3,4,5,6")
    private val bonus = BonusNumber("7", winningNumbers)

    @Test
    fun `calculate rank 1`() {
        val ticket = Lotto(listOf(1,2,3,4,5,6))
        val results = calculator.calculateResults(
            listOf(ticket), winningNumbers, bonus
        )
        assertThat(results[Rank.FIRST]).isEqualTo(1)
    }

    @Test
    fun `calculate rank 2`() {
        val ticket = Lotto(listOf(1,2,3,4,5,7))
        val results = calculator.calculateResults(
            listOf(ticket), winningNumbers, bonus
        )
        assertThat(results[Rank.SECOND]).isEqualTo(1)
    }

    @Test
    fun `calculate rank 3`() {
        val ticket = Lotto(listOf(1,2,3,4,5,45))
        val results = calculator.calculateResults(
            listOf(ticket), winningNumbers, bonus
        )
        assertThat(results[Rank.THIRD]).isEqualTo(1)
    }

    @Test
    fun `calculate rank 4`() {
        val ticket = Lotto(listOf(1,2,3,4,44,45))
        val results = calculator.calculateResults(
            listOf(ticket), winningNumbers, bonus
        )
        assertThat(results[Rank.FOURTH]).isEqualTo(1)
    }

    @Test
    fun `calculate rank 5`() {
        val ticket = Lotto(listOf(1,2,3,43,44,45))
        val results = calculator.calculateResults(
            listOf(ticket), winningNumbers, bonus
        )
        assertThat(results[Rank.FIFTH]).isEqualTo(1)
    }

    @Test
    fun `calculate rank zero`() {
        val ticket = Lotto(listOf(40,41,42,43,44,45))
        val results = calculator.calculateResults(
            listOf(ticket), winningNumbers, bonus
        )
        assertThat(results[Rank.NON]).isEqualTo(1)
    }

    @Test
    fun `calculate profit rate for zero matches`() {
        val results = mapOf<Rank, Int>()
        val profitRate = calculator.calculateProfitRate(results, 1000)
        assertThat(profitRate).isEqualTo(0.0) // (0 / 8000) * 100 = 0.0
    }

    @Test
    fun `calculate profit rate for single win`() {
        val results = mapOf(Rank.FIFTH to 1)
        val purchaseAmount = 10000
        val profitRate = calculator.calculateProfitRate(results, purchaseAmount)
        assertThat(profitRate).isEqualTo(50.0) // (5000 / 10000) * 100
    }

    @Test
    fun `calculate profit rate for multiple win`() {
        val results = mapOf(
            Rank.FOURTH to 1,
            Rank.FIFTH to 2
        )
        val purchaseAmount = 10000
        val totalPrize = Rank.FOURTH.prize * 1 + Rank.FIFTH.prize * 2
        val profitRate = calculator.calculateProfitRate(results, purchaseAmount)
        assertThat(profitRate).isEqualTo(600.0) // (60000 / 10000) * 100
    }

}