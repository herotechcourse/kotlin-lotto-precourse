package lotto.process

import lotto.BonusNumber
import lotto.Lotto
import lotto.PurchaseAmount
import java.math.BigDecimal

class StatisticsCalculator {

    fun calculateLottoRanks(purchasedTickets: List<Lotto>, winningTicket: Lotto, bonusNumber: BonusNumber): List<LottoRank> {
        return purchasedTickets.map { ticket ->  checkTicketForRank(ticket, winningTicket, bonusNumber)}
    }

    fun calculateReturnRate(lottoRanks: List<LottoRank>, purchaseAmount: PurchaseAmount): BigDecimal {
        val totalPrize = lottoRanks.sumOf { it.prizeAmount }
        return purchaseAmount.percentageOf(totalPrize)
    }

    private fun checkTicketForRank(purchasedTicket: Lotto, winningTicket: Lotto, bonusNumber: BonusNumber): LottoRank {
        return LottoRank.of(purchasedTicket.countMatchingNumbers(winningTicket), checkBonusMatch(purchasedTicket, bonusNumber))
    }

    private fun checkBonusMatch(purchasedTicket: Lotto, bonusNumber: BonusNumber): Boolean{
        return purchasedTicket.containsNumber(bonusNumber.getBonusNumber())
    }
}