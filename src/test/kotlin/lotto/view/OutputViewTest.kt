package lotto.view

import camp.nextstep.edu.missionutils.test.NsTest
import lotto.model.Lotto
import lotto.model.Prize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OutputViewTest : NsTest() {

    @Test
    fun `printTickets outputs ticket information correctly`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(7, 8, 9, 10, 11, 12))
        )

        OutputView.printTickets(tickets)

        assertThat(output()).contains(
            "You have purchased 2 tickets.", "[1, 2, 3, 4, 5, 6]", "[7, 8, 9, 10, 11, 12]"
        )
    }

    @Test
    fun `printStatistics outputs winning results correctly`() {
        val rankCount = mapOf(
            Prize.FIFTH to 1, Prize.FOURTH to 0, Prize.THIRD to 0, Prize.SECOND to 0, Prize.FIRST to 0
        )
        val returnRate = 62.5

        OutputView.printStatistics(rankCount, returnRate)

        val output = output()

        assertThat(output).contains(
            "Winning Statistics",
            "---",
            "3 Matches (5,000 KRW) – 1 tickets",
            "4 Matches (50,000 KRW) – 0 tickets",
            "5 Matches (1,500,000 KRW) – 0 tickets",
            "5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets",
            "6 Matches (2,000,000,000 KRW) – 0 tickets",
        )
        assertThat(output).containsPattern("Total return rate is \\d+[,.]\\d%\\.")
    }

    override fun runMain() {}
}
