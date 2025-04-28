package lotto.view

import lotto.Lotto
import lotto.domain.Rank
import lotto.policy.GamePolicy
import lotto.util.requireOrUnexpected

object OutputView {

	fun displayPurchasedTickets(lottoList: List<Lotto>) {
		requireOrUnexpected(lottoList.size >= GamePolicy.MIN_TICKET_SIZE) {
			"The registered lotto must be ${GamePolicy.MIN_TICKET_SIZE} or more"
		}
		println("You have purchased ${lottoList.size} tickets.")
		lottoList.forEach { it.display() }
		println()
	}

	fun displayMatches(matchResults: Map<Rank, Int>) {
		showLottoMap(matchResults)
	}

	fun displayProfitRate(profitRate: Double) {
		println("Total return rate is ${profitRate}%.")
	}

	fun displayErrorMessage(message: String, exception: Exception) {
		val eMessage = exception.message.toString()
		val cleanedDetail = eMessage.replace("[ERROR]", "").trim()
		println("${GamePolicy.ERROR_PREFIX} ${message}: $cleanedDetail")
	}

	private fun showLottoMap(lottoMap: Map<Rank, Int>) {
		println("Winning Statistics")
		println("---")
		listOf(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST)
			.forEach { rank ->
				println(formatMatchResult(rank, lottoMap))
			}
	}

	private fun formatMatchResult(rank: Rank, lottoMap: Map<Rank, Int>): String {
		return "${rank.matchCount} Matches${if (rank == Rank.SECOND) " + Bonus Ball" else ""}" +
				" (${formatRankPrize(rank.prize)} ${GamePolicy.GAME_CURRENCY}) – ${lottoMap[rank] ?: 0} tickets"
	}

	private fun formatRankPrize(prize: Int): String {
		return "%,d".format(prize)
	}
}