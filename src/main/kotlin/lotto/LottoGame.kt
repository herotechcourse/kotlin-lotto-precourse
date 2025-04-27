package lotto

class LottoGame() {
    fun checkAllTickets(purchasedTickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int){
        for (purchasedTicket in purchasedTickets) {
            val countOfMatchingNumbers = compareWinningNumbers(purchasedTicket, winningNumbers)
            val countOfMatchingBonusNumber = compareBonusNumber(purchasedTicket, bonusNumber)
            if (countOfMatchingNumbers >= 3)
            {
                determineRank(countOfMatchingNumbers, countOfMatchingBonusNumber)
            }
        }
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
    fun determineRank(countOfMatchingNumbers: Int, countOfMatchingBonusNumber: Int)
    {

    }
}