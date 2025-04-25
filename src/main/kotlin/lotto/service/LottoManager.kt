package lotto.service

import lotto.models.Lotto
import lotto.models.MatchPrize
import lotto.models.WinningLotto
import camp.nextstep.edu.missionutils.Randoms

object LottoManager {
    fun generateLottoTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        return Lotto(numbers)
    }

    fun generateMultipleTickets(amount: Int): List<Lotto> {
        return List(amount) { generateLottoTicket() }
    }

    fun compareTicket(userTicket: Lotto, winningTicket: WinningLotto): MatchPrize {
        val matchCount = userTicket.getNumbers().count { it in winningTicket.ticket.getNumbers() }
        val matchBonus = userTicket.getNumbers().contains(winningTicket.bonusNumber)
        
        return MatchPrize.from(matchCount, matchBonus)
    }   

    fun compareTickets(userTickets: List<Lotto>, winningTicket: WinningLotto): Map<MatchPrize, Int> {
        return userTickets.groupingBy { compareTicket(it, winningTicket) }
            .eachCount()
    }

    fun calculateReturnRate(rankCount: Map<MatchPrize, Int>, purchasedAmount: Int): Double {
        val totalPrize = rankCount.entries.sumOf { it.key.prize * it.value }
        return (totalPrize.toDouble() / purchasedAmount) * 100
    }

    fun calculateTicketAmount(purchasedAmount: Int): Int {
        return purchasedAmount / 1000
    }
    
    fun createWinningLotto(winningNumbers: List<Int>, bonusNumber: Int): WinningLotto {
        val lotto = Lotto(winningNumbers)
        return WinningLotto(lotto, bonusNumber)
    }
}