package lotto.service

import lotto.Lotto
import lotto.model.PrizeRank
import lotto.model.WinningLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoServiceTest {
    private val lottoService = LottoService()

    @ParameterizedTest
    @ValueSource(ints = [1, 999, 1001, 1500])
    fun `throws an exception when purchase amount is not a multiple of 1000`(amount: Int) {
        assertThrows<IllegalArgumentException> {
            lottoService.createLottoTickets(amount)
        }
    }

    @Test
    fun `creates correct number of tickets for valid purchase amount`() {
        assertThat(lottoService.createLottoTickets(1000)).hasSize(1)
        assertThat(lottoService.createLottoTickets(5000)).hasSize(5)
        assertThat(lottoService.createLottoTickets(10000)).hasSize(10)
    }

    @Test
    fun `validates winning numbers correctly`() {
        // Valid winning numbers
        lottoService.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 6))

        // Invalid size
        assertThrows<IllegalArgumentException> {
            lottoService.validateWinningNumbers(listOf(1, 2, 3, 4, 5))
        }

        // Invalid range
        assertThrows<IllegalArgumentException> {
            lottoService.validateWinningNumbers(listOf(0, 1, 2, 3, 4, 5))
        }

        // Duplicates
        assertThrows<IllegalArgumentException> {
            lottoService.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `validates bonus number correctly`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        // Valid bonus number
        lottoService.validateBonusNumber(7, winningNumbers)

        // Invalid range
        assertThrows<IllegalArgumentException> {
            lottoService.validateBonusNumber(0, winningNumbers)
        }

        // Bonus in winning numbers
        assertThrows<IllegalArgumentException> {
            lottoService.validateBonusNumber(6, winningNumbers)
        }
    }

    @Test
    fun `matches lottos correctly`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),  // 1st prize
            Lotto(listOf(1, 2, 3, 4, 5, 7)),  // 2nd prize
            Lotto(listOf(1, 2, 3, 4, 5, 8)),  // 3rd prize
            Lotto(listOf(1, 2, 3, 4, 8, 9)),  // 4th prize
            Lotto(listOf(1, 2, 3, 8, 9, 10))  // 5th prize
        )

        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val result = lottoService.matchLottos(tickets, winningLotto)

        assertThat(result.getResult()[PrizeRank.FIRST]).isEqualTo(1)
        assertThat(result.getResult()[PrizeRank.SECOND]).isEqualTo(1)
        assertThat(result.getResult()[PrizeRank.THIRD]).isEqualTo(1)
        assertThat(result.getResult()[PrizeRank.FOURTH]).isEqualTo(1)
        assertThat(result.getResult()[PrizeRank.FIFTH]).isEqualTo(1)
    }
}