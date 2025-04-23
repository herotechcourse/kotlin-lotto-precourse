package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: Implement production code to pass the test
    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // TODO: Implement tests based on the added features
    @Test
    fun `creates valid lotto and checks numbers and contains method`() {

        val validNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(validNumbers)

        lotto.getNumbers()
        lotto.contains(3)
        lotto.contains(7)
    }

    @Test
    fun `generates valid lotto ticket and validates constraints`() {
        val lotto = GeneratorTickets.generate()

        lotto.getNumbers()
        lotto.contains(1)

        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5,46))
        }
    }

    @Test
    fun `creates valid winner ticket and validates constraints`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val winner = WinnerTickets(winningNumbers, bonusNumber)

        val ticket = Lotto(listOf(1, 2, 3, 10, 11, 12))

        winner.matchCount(ticket)
        winner.hasBonus(ticket)
        winner.getRank(ticket)

        assertThrows<IllegalArgumentException> {
            WinnerTickets(listOf(1, 2, 3, 4, 5, 5), 7)
        }
        assertThrows<IllegalArgumentException> {
            WinnerTickets(listOf(0, 2, 3, 4, 5, 6), 7)
        }
        assertThrows<IllegalArgumentException> {
            WinnerTickets(listOf(1, 2, 3, 4, 5, 6), 46)
        }
    }

    @Test
    fun `adds ranks and displays results without errors`() {
        val result = Result()
        result.add(Rank.FIFTH)
        result.add(Rank.FOURTH)
        result.add(Rank.FOURTH)
        result.add(Rank.THIRD)
        result.add(Rank.WITHOUT)
        result.display()
    }

    @Test
    fun `calculates profit rate without errors`() {
        val result = Result()
        result.add(Rank.FIFTH)
        result.add(Rank.FOURTH)
        result.add(Rank.WITHOUT)
        result.getProfitRate()
    }

    @Test
    fun `returns win counts map without errors`() {
        val result = Result()
        result.add(Rank.FIRST)
        result.add(Rank.SECOND)
        result.add(Rank.WITHOUT)
        result.calculate()
    }
}
