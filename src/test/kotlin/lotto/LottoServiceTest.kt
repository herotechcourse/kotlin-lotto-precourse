package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoServiceTest {

    private val lottoService = LottoService()

    @Test
    fun `generate correct number of tickets based on amount`() {
        val tickets = lottoService.generateTickets(2000)
        assertThat(tickets.size).isEqualTo(2)
    }

    @Test
    fun `generate tickets with 6 unique numbers between 1 and 45`() {
        val tickets = lottoService.generateTickets(1000)
        val ticketNumbers = tickets[0].getNumbers()
        assertThat(ticketNumbers.size).isEqualTo(6)
        assertThat(ticketNumbers).allMatch { it in 1..45 }
        assertThat(ticketNumbers.distinct().size).isEqualTo(6)
    }

    @Test
    fun `determine prize based on number of matches and bonus`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonus = 7

        val firstPrizeTicket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lottoService.determinePrize(firstPrizeTicket, winningNumbers, bonus)).isEqualTo(Prize.FIRST)

        val secondPrizeTicket = Lotto(listOf(1, 2, 3, 4, 5, 7))
        assertThat(lottoService.determinePrize(secondPrizeTicket, winningNumbers, bonus)).isEqualTo(Prize.SECOND)

        val thirdPrizeTicket = Lotto(listOf(1, 2, 3, 4, 5, 8))
        assertThat(lottoService.determinePrize(thirdPrizeTicket, winningNumbers, bonus)).isEqualTo(Prize.THIRD)

        val fourthPrizeTicket = Lotto(listOf(1, 2, 3, 4, 8, 9))
        assertThat(lottoService.determinePrize(fourthPrizeTicket, winningNumbers, bonus)).isEqualTo(Prize.FOURTH)

        val fifthPrizeTicket = Lotto(listOf(1, 2, 3, 7, 8, 9))
        assertThat(lottoService.determinePrize(fifthPrizeTicket, winningNumbers, bonus)).isEqualTo(Prize.FIFTH)

        val noPrizeTicket = Lotto(listOf(1, 2, 10, 11, 12, 13))
        assertThat(lottoService.determinePrize(noPrizeTicket, winningNumbers, bonus)).isNull()
    }

    @Test
    fun `calculate profit rate correctly`() {
        val profitRate = lottoService.calculateProfitRate(10000L, 2000)
        assertThat(profitRate).isEqualTo(500.0)
    }

}