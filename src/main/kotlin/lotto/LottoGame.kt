package lotto

class LottoGame() {
    fun checkAllTickets(purchasedTickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): List<Rank> {
        var rank: Rank
        val results = mutableListOf<Rank>()
        for (purchasedTicket in purchasedTickets) {
            val countOfMatchingNumbers = compareWinningNumbers(purchasedTicket, winningNumbers)
            val countOfMatchingBonusNumber = compareBonusNumber(purchasedTicket, bonusNumber)
            rank = determineRank(countOfMatchingNumbers, countOfMatchingBonusNumber)
            if (rank != Rank.NONE) {
                results.add(rank)
            }
        }
        return results
    }
    fun compareWinningNumbers(ticket: Lotto, winningNumbers: List<Int>): Int
    {
        var countOfMatchingNumbers = 0
        for (winningNumber in winningNumbers) {
            if(ticket.getNumbers().contains(winningNumber))
            {
                countOfMatchingNumbers++
            }
        }
        return countOfMatchingNumbers
    }
    fun compareBonusNumber(ticket: Lotto, bonusNumber: Int): Int
    {
        var countOfMatchingBonusNumber = 0
        if (ticket.getNumbers().contains(bonusNumber)) {
            countOfMatchingBonusNumber++
        }
        return countOfMatchingBonusNumber
    }
    fun determineRank(countOfMatchingNumbers: Int, countOfMatchingBonusNumber: Int): Rank
    {
        if (countOfMatchingNumbers == 6) {
            return Rank.FIRST
        }
        if (countOfMatchingNumbers == 5 && countOfMatchingBonusNumber == 1) {
            return Rank.SECOND
        }
        if (countOfMatchingNumbers == 5 && countOfMatchingBonusNumber == 0) {
            return Rank.THIRD
        }
        if (countOfMatchingNumbers == 4) {
            return Rank.FOURTH
        }
        if (countOfMatchingNumbers == 3) {
            return Rank.FIFTH
        }
        return Rank.NONE
    }
}