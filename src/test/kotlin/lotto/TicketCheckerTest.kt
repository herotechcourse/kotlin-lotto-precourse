package lotto

import lotto.TicketChecker.resetStatistics
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TicketCheckerTest {

    @BeforeEach
    fun setup() {
        resetStatistics()
    }

    @Test
    fun `adds 3 matching numbers to statistics correctly`() {
        val myLotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val winningLotto = Lotto(listOf(1, 2, 3, 10, 11, 12))
        val bonusNumber = 13

        TicketChecker.addStatistics(myLotto, winningLotto, bonusNumber)

        val statistics = TicketChecker.getStatistics()
        assertThat(statistics[Rank.THREE]).isEqualTo(1)
        assertThat(statistics[Rank.FOUR]).isEqualTo(0)
        assertThat(statistics[Rank.FIVE]).isEqualTo(0)
        assertThat(statistics[Rank.FIVE_BONUS]).isEqualTo(0)
        assertThat(statistics[Rank.SIX]).isEqualTo(0)
    }

    @Test
    fun `adds 4 matching numbers to statistics correctly`() {
        val myLotto = Lotto(listOf(1, 2, 3, 4, 8, 9))
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 11, 12))
        val bonusNumber = 13

        TicketChecker.addStatistics(myLotto, winningLotto, bonusNumber)

        val statistics = TicketChecker.getStatistics()
        assertThat(statistics[Rank.THREE]).isEqualTo(0)
        assertThat(statistics[Rank.FOUR]).isEqualTo(1)
        assertThat(statistics[Rank.FIVE]).isEqualTo(0)
        assertThat(statistics[Rank.FIVE_BONUS]).isEqualTo(0)
        assertThat(statistics[Rank.SIX]).isEqualTo(0)
    }

    @Test
    fun `adds 5 matching numbers to statistics correctly`() {
        val myLotto = Lotto(listOf(1, 2, 3, 4, 5, 9))
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 12))
        val bonusNumber = 13

        TicketChecker.addStatistics(myLotto, winningLotto, bonusNumber)

        val statistics = TicketChecker.getStatistics()
        assertThat(statistics[Rank.THREE]).isEqualTo(0)
        assertThat(statistics[Rank.FOUR]).isEqualTo(0)
        assertThat(statistics[Rank.FIVE]).isEqualTo(1)
        assertThat(statistics[Rank.FIVE_BONUS]).isEqualTo(0)
        assertThat(statistics[Rank.SIX]).isEqualTo(0)
    }

    @Test
    fun `adds 5 matching numbers with bonus number to statistics correctly`() {
        val myLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 12))
        val bonusNumber = 6

        TicketChecker.addStatistics(myLotto, winningLotto, bonusNumber)

        val statistics = TicketChecker.getStatistics()
        assertThat(statistics[Rank.THREE]).isEqualTo(0)
        assertThat(statistics[Rank.FOUR]).isEqualTo(0)
        assertThat(statistics[Rank.FIVE]).isEqualTo(0)
        assertThat(statistics[Rank.FIVE_BONUS]).isEqualTo(1)
        assertThat(statistics[Rank.SIX]).isEqualTo(0)
    }

    @Test
    fun `adds 6 matching numbers to statistics correctly`() {
        val myLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7

        TicketChecker.addStatistics(myLotto, winningLotto, bonusNumber)

        val statistics = TicketChecker.getStatistics()
        assertThat(statistics[Rank.THREE]).isEqualTo(0)
        assertThat(statistics[Rank.FOUR]).isEqualTo(0)
        assertThat(statistics[Rank.FIVE]).isEqualTo(0)
        assertThat(statistics[Rank.FIVE_BONUS]).isEqualTo(0)
        assertThat(statistics[Rank.SIX]).isEqualTo(1)
    }

    @Test
    fun `does not add statistics when matching less than 3 numbers`() {
        val myLotto = Lotto(listOf(1, 2, 30, 40, 41, 42))
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7

        TicketChecker.addStatistics(myLotto, winningLotto, bonusNumber)

        val statistics = TicketChecker.getStatistics()
        assertThat(statistics.values.sum()).isEqualTo(0)
    }
}