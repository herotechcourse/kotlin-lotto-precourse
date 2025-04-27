package lotto

import lotto.constants.Prizes
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*

class LottoResultTest {
    private lateinit var ticketPurchase: TicketPurchase
    private lateinit var userInput: UserInput
    private lateinit var lottoResult: LottoResult

    @BeforeEach
    fun setUp() {
        ticketPurchase = TicketPurchase()
        userInput = UserInput()
        lottoResult = LottoResult()
    }

    @Test
    fun `generateWinningStatistics should identify matches correctly`() {
        userInput.setWinningNumbers("1,2,3,4,5,6")
        userInput.setBonusNumber("7")
        ticketPurchase.setTicketsForTest(
            listOf(
                Lotto(listOf(1, 2, 3, 10, 11, 12)),
                Lotto(listOf(1, 2, 3, 4, 10, 11)),
                Lotto(listOf(1, 2, 3, 4, 5, 10)),
                Lotto(listOf(1, 2, 3, 4, 5, 7)),
                Lotto(listOf(1, 2, 3, 4, 5, 6))
            )
        )

        lottoResult.generateWinningStatistics(userInput, ticketPurchase)

        assertThat(lottoResult.winningStatistics["three"]).isEqualTo(1)
        assertThat(lottoResult.winningStatistics["four"]).isEqualTo(1)
        assertThat(lottoResult.winningStatistics["five"]).isEqualTo(1)
        assertThat(lottoResult.winningStatistics["bonus"]).isEqualTo(1)
        assertThat(lottoResult.winningStatistics["six"]).isEqualTo(1)
    }

    @Test
    fun `generateWinningStatistics should not increase when matched`() {
        userInput.setWinningNumbers("39,40,41,42,43,44")
        userInput.setBonusNumber("45")
        ticketPurchase.setTicketsForTest(
            listOf(
                Lotto(listOf(1, 2, 3, 10, 11, 12)),
                Lotto(listOf(1, 2, 3, 4, 10, 11)),
                Lotto(listOf(1, 2, 3, 4, 5, 10)),
                Lotto(listOf(1, 2, 3, 4, 5, 7)),
                Lotto(listOf(1, 2, 3, 4, 5, 6))
            )
        )

        lottoResult.generateWinningStatistics(userInput, ticketPurchase)

        assertThat(lottoResult.winningStatistics["three"]).isEqualTo(0)
        assertThat(lottoResult.winningStatistics["four"]).isEqualTo(0)
        assertThat(lottoResult.winningStatistics["five"]).isEqualTo(0)
        assertThat(lottoResult.winningStatistics["bonus"]).isEqualTo(0)
        assertThat(lottoResult.winningStatistics["six"]).isEqualTo(0)
    }

    @Test
    fun `calculateReturnRate should calculate the correct return rate`() {
        userInput.setPurchaseAmount("14000")
        val winningStatistics: MutableMap<String, Int> = mutableMapOf()
        winningStatistics["three"] = 2
        winningStatistics["four"] = 3
        winningStatistics["five"] = 0
        winningStatistics["bonus"] = 0
        winningStatistics["six"] = 0
        lottoResult.setWinningStatistics(winningStatistics)

        lottoResult.calculateReturnRate(userInput)

        val expectedTotalPrize = (Prizes.FIFTH.prizeMoney * 2) + (Prizes.FOURTH.prizeMoney * 3)
        val expectedReturnRate = (expectedTotalPrize.toDouble() / 14000) * 100

        assertThat(lottoResult.returnRate).isEqualTo(expectedReturnRate)
    }
}