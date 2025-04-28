package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoEvaluatorTest {

    private val evaluator = LottoEvaluator()
    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7

    //enum class use for tickets
    private enum class TestScenario(
        val tickets: List<Lotto>,
        val expectedResults: Map<PrizeRanks, Int>
    ) {
        ALL_RANKS(
            tickets = listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(1, 2, 3, 4, 5, 7)),
                Lotto(listOf(1, 2, 3, 4, 5, 8)),
                Lotto(listOf(1, 2, 3, 4, 8, 9)),
                Lotto(listOf(1, 2, 3, 8, 9, 10))
            ),
            expectedResults = mapOf(
                PrizeRanks.FIRST to 1,
                PrizeRanks.SECOND to 1,
                PrizeRanks.THIRD to 1,
                PrizeRanks.FOURTH to 1,
                PrizeRanks.FIFTH to 1
            )
        ),

        MULTIPLE_SAME_RANK(
            tickets = listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(1, 2, 3, 4, 5, 7)),
                Lotto(listOf(1, 2, 3, 4, 5, 7)),
                Lotto(listOf(1, 2, 3, 4, 8, 9))
            ),
            expectedResults = mapOf(
                PrizeRanks.FIRST to 2,
                PrizeRanks.SECOND to 2,
                PrizeRanks.FOURTH to 1
            )
        ),

        BONUS_NUMBER_CONDITIONS(
            tickets = listOf(
                Lotto(listOf(1, 2, 3, 4, 7, 8)),
                Lotto(listOf(1, 2, 3, 7, 8, 9))
            ),
            expectedResults = mapOf(
                PrizeRanks.FOURTH to 1,
                PrizeRanks.FIFTH to 1
            )
        ),

        NO_WINNERS(
            tickets = listOf(
                Lotto(listOf(7, 8, 9, 10, 11, 12)),
                Lotto(listOf(13, 14, 15, 16, 17, 18))
            ),
            expectedResults = emptyMap()
        )
    }

    @Test
    fun `compareTickets should return empty map when no tickets provided`() {
        val (results, _) = evaluator.compareTickets(emptyList(), winningNumbers, bonusNumber)
        assertThat(results).isEmpty()
    }

    @Test
    fun `compareTickets should correctly evaluate all prize ranks`() {
        testScenario(TestScenario.ALL_RANKS)
    }

    @Test
    fun `compareTickets should correctly count multiple tickets with same rank`() {
        testScenario(TestScenario.MULTIPLE_SAME_RANK)
    }

    @Test
    fun `compareTickets should handle bonus number correctly`() {
        testScenario(TestScenario.BONUS_NUMBER_CONDITIONS)
    }

    @Test
    fun `compareTickets should handle no winning tickets`() {
        testScenario(TestScenario.NO_WINNERS)
    }

    private fun testScenario(scenario: TestScenario) {
        val (results, _) = evaluator.compareTickets(scenario.tickets, winningNumbers, bonusNumber)

        assertAll(
            scenario.expectedResults.map { (rank, count) ->
                { assertThat(results[rank]).isEqualTo(count) }
            }
        )
    }

    @Test
    fun `single first prize ticket should return 2000000 profit`() {
        val tickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val (_, profit) = evaluator.compareTickets(tickets, winningNumbers, bonusNumber)

        assertThat(profit).isEqualTo(200_000_000.0) // 2,000,000,000 / 1,000 * 100
    }

    @Test
    fun `single second prize ticket should return 300000 profit`() {
        val tickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 7)))
        val (_, profit) = evaluator.compareTickets(tickets, winningNumbers, bonusNumber)

        assertThat(profit).isEqualTo(3_000_000.0) // 30,000,000 / 1,000 * 100
    }

    @Test
    fun `mixed prizes should calculate correct profit`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)), // 1st prize
            Lotto(listOf(1, 2, 3, 4, 5, 7)), // 2nd prize
            Lotto(listOf(7, 8, 9, 10, 11, 12)) // losing ticket
        )

        val (_, profit) = evaluator.compareTickets(tickets, winningNumbers, bonusNumber)
        val expectedProfit = (2_000_000_000 + 30_000_000) / 3000.0 * 100

        assertThat(profit).isEqualTo(expectedProfit)
    }

    @Test
    fun `losing tickets should return 0 profit`() {
        val tickets = listOf(
            Lotto(listOf(7, 8, 9, 10, 11, 12)),
            Lotto(listOf(13, 14, 15, 16, 17, 18))
        )

        val (_, profit) = evaluator.compareTickets(tickets, winningNumbers, bonusNumber)
        assertThat(profit).isEqualTo(0.0)
    }

}