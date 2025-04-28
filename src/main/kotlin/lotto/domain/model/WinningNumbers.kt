package lotto.domain.model

import lotto.Lotto

data class WinningNumbers(
  val mainNumbers: List<Int>,
  val bonusNumber: Int
) {
  fun match(ticket: Lotto): MatchResult {
    val matchCount = ticket.countMatching(mainNumbers)
    val bonusMatch = ticket.contains(bonusNumber)
    return MatchResult(matchCount, bonusMatch)
  }
}


