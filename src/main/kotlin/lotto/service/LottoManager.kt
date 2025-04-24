package lotto.service

import lotto.models.Lotto
import lotto.models.RankEnum
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

    fun compareTicket(userTicket: Lotto, winningTicket: WinningLotto): RankEnum {
        val matchCount = userTicket.getNumbers().count { it in winningTicket.ticket.getNumbers() }
        val matchBonus = userTicket.getNumbers().contains(winningTicket.bonusNumber)
        
        return RankEnum.from(matchCount, matchBonus)
    }   

    fun compareTickets(userTickets: List<Lotto>, winningTicket: WinningLotto): Map<RankEnum, Int> {
        return userTickets.groupingBy { compareTicket(it, winningTicket) }
            .eachCount()
    }
}