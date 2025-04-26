package lotto.domain

import LottoResult

class UserLottoTickets(private val tickets: List<Lotto>) {
    fun match(winningNumbers: WinningNumbers): LottoResult {
        val statistics = tickets.groupingBy { winningNumbers.match(it) }
            .eachCount()

        return LottoResult(statistics)
    }
}
