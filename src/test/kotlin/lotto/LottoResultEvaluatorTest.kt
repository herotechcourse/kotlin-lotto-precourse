package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoResultEvaluatorTest {
    private val evaluator = LottoResultEvaluator()

    @Test
    @DisplayName("Evaluates first prize correctly")
    fun firstPrizeWhenAllMatch() {
        val winning = listOf(1,2,3,4,5,6)
        val ticketNums = listOf(1,2,3,4,5,6)
        val tickets = listOf(Lotto(ticketNums))
        val result = evaluator.evaluate(tickets, winning, bonusNumber = 7)
        assertThat(result[Rank.FIRST]!!.toLong()).isEqualTo(1)
    }

    @Test
    @DisplayName("Evaluates second prize correctly")
    fun secondPrizeWhen5PlusBonus() {
        val winning = listOf(1,2,3,4,5,6)
        val ticketNums = listOf(1,2,3,4,5,7)
        val tickets = listOf(Lotto(ticketNums))
        val result = evaluator.evaluate(tickets, winning, bonusNumber = 7)
        assertThat(result[Rank.SECOND]!!.toLong()).isEqualTo(1)
    }

    @Test
    @DisplayName("Evaluates third prize correctly")
    fun thirdPrizeWhen5Matches() {
        val winning = listOf(1,2,3,4,5,6)
        val ticketNums = listOf(1,2,3,4,5,7)
        val tickets = listOf(Lotto(ticketNums))
        val result = evaluator.evaluate(tickets, winning, bonusNumber = 8)
        assertThat(result[Rank.THIRD]!!.toLong()).isEqualTo(1)
    }

    @Test
    @DisplayName("Evaluates fourth prize correctly")
    fun fourthPrizeWhen4Matches() {
        val winning = listOf(1,2,3,4,5,6)
        val ticketNums = listOf(1,2,3,4,7,8)
        val tickets = listOf(Lotto(ticketNums))
        val result = evaluator.evaluate(tickets, winning, bonusNumber = 8)
        assertThat(result[Rank.FOURTH]!!.toLong()).isEqualTo(1)
    }

    @Test
    @DisplayName("Evaluates fifth prize correctly")
    fun fifthPrizeWhen3Matches() {
        val winning = listOf(1,2,3,4,5,6)
        val ticketNums = listOf(1,2,3,7,8,9)
        val tickets = listOf(Lotto(ticketNums))
        val result = evaluator.evaluate(tickets, winning, bonusNumber = 8)
        assertThat(result[Rank.FIFTH]!!.toLong()).isEqualTo(1)
    }

    @Test
    @DisplayName("No prize when less than 3 matches")
    fun noPrizeWhenLessThan3Matches() {
        val winning = listOf(1,2,3,4,5,6)
        val tickets = listOf(Lotto(listOf(8,9,10,11,12,13))) // only 5 + bonus → second
        val result = evaluator.evaluate(tickets, winning, bonusNumber = 8)
        assertThat(result.size).isEqualTo(0)
    }

    @Test
    @DisplayName("Calculate profit rate for one ticket")
    fun singleFirstPrize() {
        val winning = listOf(1,2,3,4,5,6)
        val tickets = listOf(Lotto(winning))
        val result = evaluator.evaluate(tickets, winning, bonusNumber = 7)
        assertThat(result[Rank.FIRST]).isEqualTo(1)
        assertThat(evaluator.calculateProfitRate(tickets, result).toLong())
            .isEqualTo((Config.RankConfig.FIRST_PRIZE / Config.TICKET_PRICE * 100))
    }

    @Test
    @DisplayName("Calculate profit rate for multiple tickets")
    fun calculateProfitRateWithMultipleTickets() {
        val winning = listOf(1, 2, 3, 4, 5, 6)
        val tickets = listOf(
            Lotto(winning), // First prize
            Lotto(listOf(1, 2, 3, 4, 5, 7)), // Second prize
            Lotto(listOf(10, 11, 12, 13, 14, 15)) // No prize
        )
        val result = evaluator.evaluate(tickets, winning, bonusNumber = 7)
        val expectedProfitRate = (
                (Config.RankConfig.FIRST_PRIZE + Config.RankConfig.SECOND_PRIZE).toDouble() /
                        (tickets.size * Config.TICKET_PRICE)
                ) * 100
        assertThat(evaluator.calculateProfitRate(tickets, result).toLong()).isEqualTo(expectedProfitRate.toLong())
    }
}
