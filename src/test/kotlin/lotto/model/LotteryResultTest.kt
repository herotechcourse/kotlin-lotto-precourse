package lotto.model

import lotto.Lotto
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class LotteryResultTest {
    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7
    private val winningLotto = WinningLotto(winningNumbers, bonusNumber)

    @Test
    fun `getPrizeTierCount returns correct count of tickets for each prize tier`() {
        val firstPrize = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val secondPrize = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val thirdPrize = Lotto(listOf(1, 2, 3, 4, 5, 8))
        val fourthPrize = Lotto(listOf(1, 2, 3, 4, 9, 10))
        val fifthPrize = Lotto(listOf(1, 2, 3, 8, 9, 10))
        val noPrize = Lotto(listOf(7, 8, 9, 10, 11, 12))

        val tickets = listOf(firstPrize, secondPrize, thirdPrize, fourthPrize, fifthPrize, noPrize)

        val result = LotteryResult(tickets, winningLotto)

        assertThat(result.getPrizeTierCount(PrizeTier.FIRST)).isEqualTo(1)
        assertThat(result.getPrizeTierCount(PrizeTier.SECOND)).isEqualTo(1)
        assertThat(result.getPrizeTierCount(PrizeTier.THIRD)).isEqualTo(1)
        assertThat(result.getPrizeTierCount(PrizeTier.FOURTH)).isEqualTo(1)
        assertThat(result.getPrizeTierCount(PrizeTier.FIFTH)).isEqualTo(1)
        assertThat(result.getPrizeTierCount(PrizeTier.NONE)).isEqualTo(0)
    }

    @Test
    fun `getReturnRate calculates correct return percentage`() {
        // 5000 KRW + 0 KRW
        val fifthPrizeTicket = Lotto(listOf(1, 2, 3, 8, 9, 10))
        val noPrizeTicket = Lotto(listOf(8, 9, 10, 11, 12, 13))

        // 2000 KRW
        val tickets = listOf(fifthPrizeTicket, noPrizeTicket)

        val result = LotteryResult(tickets, winningLotto)

        //return rate: 5000/2000 * 100 = 250
        assertThat(result.getReturnRate()).isEqualTo(250.0)
    }
}