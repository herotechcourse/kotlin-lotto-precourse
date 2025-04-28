package lotto

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class ResultTest {

    @Test
    fun `calculateResult updates prize counts and profit rate correctly`() {
        // given
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val winningLotto = WinningLotto()
        winningLotto.registerWinningNumbers(winningNumbers)
        winningLotto.registerBonusNumber(bonusNumber)

        val matching6 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val matching5PlusBonus = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val matching5 = Lotto(listOf(1, 2, 3, 4, 5, 8))
        val matching4 = Lotto(listOf(1, 2, 3, 4, 7, 8))
        val matching3 = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val noMatch = Lotto(listOf(10, 11, 12, 13, 14, 15))

        val lottos = Lottos(listOf(matching6, matching5PlusBonus, matching5, matching4, matching3, noMatch))
        val purchaseAmount = (6 * 1000).toString()

        val result = Result()

        // when
        result.calculateResult(winningLotto, lottos, purchaseAmount)

        // then
        val output = result.toString()

        assertThat(output).contains("3 Matches (5,000 KRW) – 1 tickets")
        assertThat(output).contains("4 Matches (50,000 KRW) – 1 tickets")
        assertThat(output).contains("5 Matches (1,500,000 KRW) – 1 tickets")
        assertThat(output).contains("5 Matches + Bonus Ball (30,000,000 KRW) – 1 tickets")
        assertThat(output).contains("6 Matches (2,000,000,000 KRW) – 1 tickets")

        val totalPrize = 2000000000 + 30000000 + 1500000 + 50000 + 5000
        val expectedRate = (totalPrize.toFloat() / 6000f) * 100

        assertThat(output).contains("Total return rate is ${"%.1f".format(expectedRate)}%")
    }
}