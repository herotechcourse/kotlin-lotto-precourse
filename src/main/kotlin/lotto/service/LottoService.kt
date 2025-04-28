package lotto.service

import lotto.model.LottoTickets
import lotto.model.Rank

interface LottoService {

    fun purchaseTickets(amount: Int): LottoTickets
    fun calculateResult(tickets: LottoTickets, winningNumbers: List<Int>, bonusNumber: Int): Map<Rank, Int>
}
