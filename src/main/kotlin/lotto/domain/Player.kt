package lotto.domain

import lotto.Lotto

data class Player(
    var moneySpent: Int = 0,
    var lottoTickets: List<Lotto> = emptyList(),
    var prizeSum: Int = 0,
    var returnRate: Double = 0.0
)