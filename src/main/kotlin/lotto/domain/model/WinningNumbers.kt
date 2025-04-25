package lotto.domain.model

data class WinningNumbers(
  val mainNumbers: List<Int>,
  val bonusNumber: Int
) {
  fun match(ticket: LottoTicket): MatchResult {
    val matchCount = ticket.countMatching(mainNumbers)
    val bonusMatch = ticket.contains(bonusNumber)
    return MatchResult(matchCount, bonusMatch)
  }
}


