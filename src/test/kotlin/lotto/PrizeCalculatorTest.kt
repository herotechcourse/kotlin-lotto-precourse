package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class PrizeCalculatorTest {
    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7
    private lateinit var calculator: PrizeCalculator

    @BeforeEach
    fun setUp() {
        calculator = PrizeCalculator(winningNumbers, bonusNumber)
    }

    @Test
    fun `calculateResults should count 6 matches as FIRST`() {
        val tickets = listOf(Lotto(winningNumbers))
        val statistics = calculator.calculateResults(tickets)
        assertEquals(1, statistics.getCount(Rank.FIRST))
    }

    @Test
    fun `calculateResults should count 5 matches with bonus as SECOND`() {
        val tickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, bonusNumber)))
        val statistics = calculator.calculateResults(tickets)
        assertEquals(1, statistics.getCount(Rank.SECOND))
    }

    @Test
    fun `calculateResults should count 5 matches without bonus as THIRD`() {
        val tickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 10)))
        val statistics = calculator.calculateResults(tickets)
        assertEquals(1, statistics.getCount(Rank.THIRD))
    }

    @Test
    fun `calculateResults should count 4 matches as FOURTH`() {
        val tickets = listOf(Lotto(listOf(1, 2, 3, 4, 10, 11)))
        val statistics = calculator.calculateResults(tickets)
        assertEquals(1, statistics.getCount(Rank.FOURTH))
    }

    @Test
    fun `calculateResults should count 3 matches as FIFTH`() {
        val tickets = listOf(Lotto(listOf(1, 2, 3, 10, 11, 12)))
        val statistics = calculator.calculateResults(tickets)
        assertEquals(1, statistics.getCount(Rank.FIFTH))
    }

    @Test
    fun `calculateResults should count no matches as no rank`() {
        val tickets = listOf(Lotto(listOf(10, 11, 12, 13, 14, 15)))
        val statistics = calculator.calculateResults(tickets)
        assertEquals(0, statistics.getCount(Rank.FIRST))
        assertEquals(0, statistics.getCount(Rank.SECOND))
        assertEquals(0, statistics.getCount(Rank.THIRD))
        assertEquals(0, statistics.getCount(Rank.FOURTH))
        assertEquals(0, statistics.getCount(Rank.FIFTH))
    }

    @Test
    fun `calculateResults should handle multiple tickets correctly`() {
        val tickets = listOf(
            Lotto(winningNumbers), // FIRST
            Lotto(listOf(1, 2, 3, 4, 5, bonusNumber)), // SECOND
            Lotto(listOf(1, 2, 3, 4, 5, 10)), // THIRD
            Lotto(listOf(1, 2, 3, 4, 10, 11)), // FOURTH
            Lotto(listOf(1, 2, 3, 10, 11, 12)), // FIFTH
            Lotto(listOf(10, 11, 12, 13, 14, 15)) // No match
        )

        val statistics = calculator.calculateResults(tickets)

        assertEquals(1, statistics.getCount(Rank.FIRST))
        assertEquals(1, statistics.getCount(Rank.SECOND))
        assertEquals(1, statistics.getCount(Rank.THIRD))
        assertEquals(1, statistics.getCount(Rank.FOURTH))
        assertEquals(1, statistics.getCount(Rank.FIFTH))
    }

    @Test
    fun `calculateResults should handle empty ticket list`() {
        val tickets = emptyList<Lotto>()
        val statistics = calculator.calculateResults(tickets)

        assertEquals(0, statistics.getCount(Rank.FIRST))
        assertEquals(0, statistics.getCount(Rank.SECOND))
        assertEquals(0, statistics.getCount(Rank.THIRD))
        assertEquals(0, statistics.getCount(Rank.FOURTH))
        assertEquals(0, statistics.getCount(Rank.FIFTH))
    }
}

