package lotto.service

import lotto.Lotto
import lotto.domain.LottoEvaluator
import lotto.domain.Rank
import lotto.error.UnexpectedException
import lotto.error.isStatusSuccess
import lotto.policy.doesNotOverlapWithWinningNumbers
import lotto.util.requireOrUnexpected

/**
 * Represents the result of a Lotto game.
 *
 * This class holds the purchased lotto tickets, the winning numbers,
 * the bonus number, and the purchase amount.
 *
 * Upon initialization, it validates the integrity of the provided data.
 *
 * Main responsibilities:
 * - Evaluate ticket results and group them by [Rank].
 * - Calculate the total profit rate based on winnings and purchase amount.
 *
 * @property lottoList The list of purchased [Lotto] tickets.
 * @property winningNumbers The list of winning numbers.
 * @property bonusNumber The bonus number not included in winning numbers.
 * @property amount The total purchase amount.
 *
 * @throws UnexpectedException If input validation fails.
 */
data class GameResult(
	val lottoList: List<Lotto>,
	val winningNumbers: List<Int>,
	val bonusNumber: Int,
	val amount: Long,
) {
	init {
		validateInputs(lottoList, winningNumbers, bonusNumber)
	}

	fun evaluateRanks(): Map<Rank, Int> {
		return LottoEvaluator.evaluate(lottoList, winningNumbers, bonusNumber)
	}

	fun calculateProfitRate(): Double {
		val matchResults = evaluateRanks()
		val totalPrize = matchResults
			.map { (rank, count) -> rank.prize.toLong() * count }
			.sum()

		return (totalPrize.toDouble() / amount) * 100
	}

	private fun validateInputs(
		lottoList: List<Lotto>,
		winningNumbers: List<Int>,
		bonusNumber: Int,
	) {
		requireOrUnexpected(lottoList.isNotEmpty()) {
			"Lotto list must not be empty."
		}
		requireOrUnexpected(winningNumbers.isNotEmpty()) {
			"Winning numbers must not be empty."
		}
		requireOrUnexpected(bonusNumber.doesNotOverlapWithWinningNumbers(winningNumbers).isStatusSuccess()) {
			"Bonus number must not overlap with winning numbers."
		}
	}
}