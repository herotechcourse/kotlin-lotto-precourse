package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `throws an exception when lotto number is not between 1 and 45`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 60))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are less then 6`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4))
        }
    }

    @Test
    fun `no exception when lotto number is between 1 and 45 and no duplicates and exactly 6 size`() {
        assertDoesNotThrow {
            Lotto(listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `throws an exception when bonus number is not between 1 and 45`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = -1

        assertThrows<IllegalArgumentException> {
            lotto.validateNumber(bonusNumber)
        }
    }

    @Test
    fun `throws an exception when bonus number duplicate with winning numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 4

        assertThrows<IllegalArgumentException> {
            lotto.validateNumber(bonusNumber)
        }
    }

    @Test
    fun `no exception when bonus number is between 1 and 45 and not duplicate with winning numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 10

        assertDoesNotThrow {
            lotto.validateNumber(bonusNumber)
        }
    }

    @Test
    fun `increases the ticket count of matches when winning the lottery`() {
        val lotto = Lotto(listOf(1, 3, 4, 5, 22, 11))
        val issuedTickets = FixedIssuedTicketsGenerator.of()
        val bonusNumber = 30
        val lottoStatistics = LottoStatistics.of()

        lotto.simulate(issuedTickets, bonusNumber, lottoStatistics)

        assertEquals(2, lottoStatistics.statistics[0].ticketCount)
        assertEquals(1, lottoStatistics.statistics[1].ticketCount)
        assertEquals(1, lottoStatistics.statistics[3].ticketCount)
    }
}
