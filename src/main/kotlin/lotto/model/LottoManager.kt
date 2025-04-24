package lotto.model

import lotto.Lotto

class LottoManager(val winnerLotto: Lotto, val user: User) {
    val matchedLottoTicket: MutableList<Int> = MutableList(Lotto.SIZE + 1) { 0 }
    val matchedLottoBonus: MutableList<Boolean> = MutableList(Lotto.SIZE + 1) { false }
    fun matchLotto() {
        user.lottoTickets.forEach { lotto ->
            val matches = lotto.numbers.count { it in winnerLotto.numbers }
            matchedLottoTicket[matches] += 1
            if (winnerLotto.bonusNumber in lotto.numbers) matchedLottoBonus[matches] = true
        }
    }
}