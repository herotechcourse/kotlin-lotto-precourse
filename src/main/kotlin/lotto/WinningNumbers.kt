package lotto

class WinningNumbers(private val numbers: List<Int>, private val bonus: Int) {
    fun match(ticket: Lotto): Rank {
        val matches = ticket.getNumbers().count { it in numbers }
        val hasBonus = bonus in ticket.getNumbers()
        return Rank.valueOf(matches, hasBonus)
    }
}
// 티켓 당첨 번호 및 보너스 번호 포함 확인 

class LottoResult(private val ranks: List<Rank>) {
    fun count(rank: Rank): Int = ranks.count { it == rank }

    fun calculateRate(purchaseAmount: Int): Double {
        val totalPrize = ranks.sumOf { it.prize }
        return totalPrize.toDouble() / purchaseAmount * 100
    }
    //구매금액 수익률 확인 
}
