package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoConfigurationTest {

    @Test
    fun `get prize sum for tickets with the same match `() {
        prizes.forEach {
            val ticketsWonForCurrentCaseWithBonusFlag = listOf(0, 1)
            val exceptionSum = prizes[it.key]!! + prizesWithBonus[it.key]!!
            assertThat(
                LottoConfiguration
                    .getSumForEachMatch(it.key, ticketsWonForCurrentCaseWithBonusFlag)
            )
                .isEqualTo(exceptionSum)
        }
        val sumForMatch = LottoConfiguration.getSumForEachMatch(3, listOf(1, 0))
    }

    @Test
    fun `get ticket info format test`() {
        val ticket = listOf(1, 2, 3, 4, 5, 6)
        val expectedTicketFormat = "[${ticket.joinToString(", ")}]"
        assertThat(
            LottoConfiguration.getTicketInfoFormat(ticket)
        ).isEqualTo(expectedTicketFormat)
    }

    companion object {
        private val prizes: Map<Int, Int> = mapOf(
            3 to 5000,
            4 to 50000,
            5 to 1500000,
            6 to 2000000000
        )
        private val prizesWithBonus: Map<Int, Int> = mapOf(
            3 to 5000,
            4 to 50000,
            5 to 30000000,
            6 to 2000000000
        )
    }
}
