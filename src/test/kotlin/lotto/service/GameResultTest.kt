package lotto.service

import lotto.Lotto
import lotto.error.UnexpectedException
import lotto.policy.GamePolicy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class GameResultTest {
	@Test
	fun `should throw error when lotto list is empty`() {
		val emptyLottoList = emptyList<Lotto>()
		val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
		val bonusNumber = 7

		assertThrows<UnexpectedException> {
			GameResult(emptyLottoList, winningNumbers, bonusNumber, GamePolicy.TICKET_PRICE)
		}
	}

	@Test
	fun `should throw error when winning numbers list is empty`() {
		val lottoList = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
		val emptyWinningNumbers = emptyList<Int>()
		val bonusNumber = 7

		assertThrows<UnexpectedException> {
			GameResult(lottoList, emptyWinningNumbers, bonusNumber, GamePolicy.TICKET_PRICE)
		}
	}

	@Test
	fun `should throw error when bonus number overlaps with winning numbers`() {
		val lottoList = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
		val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
		val bonusNumber = 6

		assertThrows<UnexpectedException> {
			GameResult(lottoList, winningNumbers, bonusNumber, GamePolicy.TICKET_PRICE)
		}
	}
}