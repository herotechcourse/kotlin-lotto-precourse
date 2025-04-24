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
    fun `increases the ticket count of matches when winning the lottery`() {
        val lotto = Lotto(listOf(1, 3, 4, 5, 22, 11))
        val issuedTickets = getIssuedTickets()
        val bonusNumber = 30

        lotto.simulate(issuedTickets, bonusNumber)

        assertEquals(1, LottoPrize.FIVE_MATCHES_BONUS.ticketCount)
        assertEquals(1, LottoPrize.FOUR_MATCHES.ticketCount)
        assertEquals(2, LottoPrize.THREE_MATCHES.ticketCount)
    }

    @Test
    fun `profit rate is total prize amount divided by purchase amount percentage`() {
        val lotto = Lotto(listOf(1, 3, 4, 5, 22, 11))
        val issuedTickets = getIssuedTickets()
        val bonusNumber = 30
        val purchaseAmount = 8000
        lotto.simulate(issuedTickets, bonusNumber)

        val profitRate = lotto.getProfitRate(purchaseAmount)

        val expectedProfitRate = 30_060_000.0 / 8000 * 100
        assertEquals(expectedProfitRate, profitRate)
    }

    private fun getIssuedTickets(): List<List<Int>> {
        return listOf(
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 22, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(3, 4, 5, 11, 22, 30),
            listOf(1, 3, 5, 14, 22, 45),
        )
    }
}
