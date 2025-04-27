package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.*
import kotlin.math.round

class LottoTest {
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are less than six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are out of range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `correctly calculates the number of matching numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(3, 5, 7, 9, 1, 11)
        assertEquals(3, lotto.matchCount(winningNumbers))
    }

    @Test
    fun `correctly identifies if the lotto has the bonus number`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumberPresent = 6
        val bonusNumberAbsent = 7
        assertTrue(lotto.hasBonus(bonusNumberPresent))
        assertFalse(lotto.hasBonus(bonusNumberAbsent))
    }

    @Test
    fun `correctly sorts the lotto numbers`() {
        val lotto = Lotto(listOf(6, 3, 1, 5, 2, 4))
        assertEquals(listOf(1, 2, 3, 4, 5, 6), lotto.getSortedNumbers())
    }
}

class WinningLottoTest {
    @Test
    fun `throws an exception when winning numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6, 7), 7)
        }
    }

    @Test
    fun `throws an exception when winning numbers are less than six`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5), 7)
        }
    }

    @Test
    fun `throws an exception when winning numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 5), 7)
        }
    }

    @Test
    fun `throws an exception when winning numbers are out of range`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(0, 2, 3, 4, 5, 6), 7)
        }
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 46), 7)
        }
    }

    @Test
    fun `throws an exception when bonus number is out of range`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 0)
        }
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 46)
        }
    }

    @Test
    fun `throws an exception when bonus number is the same as a winning number`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 6)
        }
    }

    @Test
    fun `correctly determines the rank - FIRST`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(LottoRank.FIRST, winningLotto.determineRank(lotto))
    }

    @Test
    fun `correctly determines the rank - SECOND`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 7), 6)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(LottoRank.SECOND, winningLotto.determineRank(lotto))
    }

    @Test
    fun `correctly determines the rank - THIRD`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 7), 8)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(LottoRank.THIRD, winningLotto.determineRank(lotto))
    }

    @Test
    fun `correctly determines the rank - FOURTH`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 8, 9), 10)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(LottoRank.FOURTH, winningLotto.determineRank(lotto))
    }

    @Test
    fun `correctly determines the rank - FIFTH`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 7, 8, 9), 10)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(LottoRank.FIFTH, winningLotto.determineRank(lotto))
    }

    @Test
    fun `correctly determines the rank - MISS`() {
        val winningLotto = WinningLotto(listOf(7, 8, 9, 10, 11, 12), 13)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(LottoRank.MISS, winningLotto.determineRank(lotto))
    }
}

class LottoGameTest {
    @Test
    fun `throws an exception when purchase amount is not divisible by 1000`() {
        assertThrows<IllegalArgumentException> {
            LottoGame(1500)
        }
    }

    @Test
    fun `correctly calculates the number of tickets based on purchase amount`() {
        assertEquals(5, LottoGame(5000).getNumberOfTickets())
        assertEquals(10, LottoGame(10000).getNumberOfTickets())
        assertEquals(0, LottoGame(0).getNumberOfTickets())
    }

    @Test
    fun `generates the correct number of lotto tickets`() {
        val purchaseAmount = 3000
        val game = LottoGame(purchaseAmount)

        assertEquals(3, game.tickets.size)
        game.tickets.forEach { lotto ->
            assertEquals(6, lotto.getSortedNumbers().size)
            lotto.getSortedNumbers().forEach { num ->
                assert(num in 1..45)
            }
            assertEquals(6, lotto.getSortedNumbers().distinct().size)
        }
    }

    @Test
    fun `correctly determines the results of the lotto game`() {
        val purchaseAmount = 6000
        val game = LottoGame(purchaseAmount)

        val field = LottoGame::class.java.getDeclaredField("tickets")
        field.isAccessible = true
        field.set(
            game, listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),     // FIRST
                Lotto(listOf(1, 2, 3, 4, 5, 7)),     // SECOND
                Lotto(listOf(1, 2, 3, 4, 8, 9)),     // FOURTH
                Lotto(listOf(1, 2, 3, 10, 11, 12)),    // FIFTH
                Lotto(listOf(1, 10, 11, 12, 13, 14)),  // MISS
                Lotto(listOf(21, 22, 23, 24, 25, 26)), // MISS
            )
        )

        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val results = game.determineResults(winningLotto)

        assertEquals(1, results[LottoRank.FIRST])
        assertEquals(1, results[LottoRank.SECOND])
        assertEquals(0, results[LottoRank.THIRD])
        assertEquals(1, results[LottoRank.FOURTH])
        assertEquals(1, results[LottoRank.FIFTH])
        assertEquals(2, results[LottoRank.MISS])
    }

    @Test
    fun `correctly calculates the profit rate`() {
        val purchaseAmount = 2000
        val game = LottoGame(purchaseAmount)
        val results = mapOf(
            LottoRank.FIRST to 1,
            LottoRank.MISS to 1
        )
        val expectedProfitRate = round((2000000000.0 / purchaseAmount) * 10000) / 100.0
        assertEquals(expectedProfitRate, game.calculateProfitRate(results), 0.01)
    }

    @Test
    fun `correctly calculates the profit rate with multiple ranks`() {
        val purchaseAmount = 6000
        val game = LottoGame(purchaseAmount)
        val results = mapOf(
            LottoRank.FIRST to 1,
            LottoRank.SECOND to 1,
            LottoRank.THIRD to 1,
            LottoRank.FOURTH to 1,
            LottoRank.FIFTH to 1,
            LottoRank.MISS to 1
        )
        val expectedProfitRate = round(((2000000000L + 30000000L + 1500000L + 50000L + 5000L).toDouble() / purchaseAmount) * 10000) / 100.0
        assertEquals(expectedProfitRate, game.calculateProfitRate(results), 0.01)
    }
}

class LottoRankTest {
    @Test
    fun `determineRank correctly identifies FIRST place`() {
        assertEquals(LottoRank.FIRST, LottoRank.determineRank(6, false))
    }

    @Test
    fun `determineRank correctly identifies SECOND place`() {
        assertEquals(LottoRank.SECOND, LottoRank.determineRank(5, true))
    }

    @Test
    fun `determineRank correctly identifies THIRD place`() {
        assertEquals(LottoRank.THIRD, LottoRank.determineRank(5, false))
    }

    @Test
    fun `determineRank correctly identifies FOURTH place`() {
        assertEquals(LottoRank.FOURTH, LottoRank.determineRank(4, false))
    }

    @Test
    fun `determineRank correctly identifies FIFTH place`() {
        assertEquals(LottoRank.FIFTH, LottoRank.determineRank(3, false))
    }

    @Test
    fun `determineRank correctly identifies MISS`() {
        assertEquals(LottoRank.MISS, LottoRank.determineRank(2, false))
        assertEquals(LottoRank.MISS, LottoRank.determineRank(2, true))
        assertEquals(LottoRank.MISS, LottoRank.determineRank(1, false))
        assertEquals(LottoRank.MISS, LottoRank.determineRank(1, true))
        assertEquals(LottoRank.MISS, LottoRank.determineRank(0, false))
        assertEquals(LottoRank.MISS, LottoRank.determineRank(0, true))
    }
}

