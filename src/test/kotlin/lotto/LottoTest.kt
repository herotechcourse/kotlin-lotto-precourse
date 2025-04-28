package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

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
    fun `throws an exception when lotto numbers are less than six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `validates bonus number range - above maximum`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThrows<IllegalArgumentException> {
            lotto.validateBonusNumber(46)
        }
    }

    @Test
    fun `validates bonus number not in winning numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThrows<IllegalArgumentException> {
            lotto.validateBonusWinningUnique(3)
        }
    }

    @Test
    fun `accepts bonus number not in winning numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        lotto.validateBonusWinningUnique(7)
    }

    @Test
    fun `calculates matches correctly`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val tickets = listOf(
            listOf(1, 2, 3, 7, 8, 9),  // 3 matches
            listOf(10, 11, 12, 13, 14, 15)  // 0 matches
        )

        val results = lotto.checkMatchingNumbers(tickets, 7)

        assertThat(results[Lotto.PrizeTier.FIFTH]).isEqualTo(1)  // 3 matches
        assertThat(results[Lotto.PrizeTier.FOURTH]).isEqualTo(0)  // No 4 matches
    }

    @Test
    fun `calculates total prize correctly`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val matchResults = mapOf(
            Lotto.PrizeTier.FIFTH to 2,  // 2 tickets with 3 matches (5,000 each)
            Lotto.PrizeTier.FOURTH to 1,  // 1 ticket with 4 matches (50,000)
            Lotto.PrizeTier.THIRD to 0,
            Lotto.PrizeTier.SECOND to 0,
            Lotto.PrizeTier.FIRST to 0
        )

        val totalPrize = lotto.calculateTotalPrize(matchResults)

        assertThat(totalPrize).isEqualTo(60_000)
    }

    @Test
    fun `calculates return rate correctly`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val returnRate = lotto.calculateReturnRate(8000, 5000)

        assertThat(returnRate).isEqualTo(62.5)
    }

    @Test
    fun `handles zero purchase amount for return rate`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val returnRate = lotto.calculateReturnRate(0, 5000)

        assertThat(returnRate).isEqualTo(0.0)
    }
}
