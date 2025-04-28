package lotto.domain

import lotto.Lotto

object LottoEvaluator {
	fun evaluate(
		lottoList: List<Lotto>,
		winningNumbers: List<Int>,
		bonusNumber: Int,
	): Map<Rank, Int> {
		val evaluatedRanks = lottoList.map { lotto ->
			evaluateEach(lotto, winningNumbers, bonusNumber)
		}
		val groupedRanks = evaluatedRanks.groupingBy { rank ->
			rank
		}.eachCount()
		return groupedRanks
	}

	private fun evaluateEach(
		lotto: Lotto,
		winningNumbers: List<Int>,
		bonusNumber: Int,
	): Rank {
		val matchedCount = lotto.countMatched(winningNumbers)
		val bonusMatched = lotto.contains(bonusNumber)
		return Rank.from(matchedCount, bonusMatched)
	}
}