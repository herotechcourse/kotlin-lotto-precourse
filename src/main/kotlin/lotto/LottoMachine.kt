package lotto

class LottoMachine {
    private val lottoGenerator = LottoGenerator()
    private val ticketPrice = 1000

    fun generateTickets(money: Int): List<Lotto> {
        require(money >= ticketPrice) { "[ERROR] Purchase amount must be at least $ticketPrice KRW." }
        require(money % ticketPrice == 0) { "[ERROR] Purchase amount must be a multiple of $ticketPrice KRW." }

        val ticketCount = money / ticketPrice
        return List(ticketCount) { lottoGenerator.generate() }
    }

    fun calculateResult(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): LottoResult{
        val winningLotto = Lotto(winningNumbers)
        val rankCounts = tickets.map { calculateGrade(it, winningLotto, bonusNumber) }
            .groupingBy { it }
            .eachCount()
        return LottoResult(rankCounts)
    }

    private fun calculateGrade(ticket: Lotto, winningLotto: Lotto, bonusNumber: Int): LottoGrade {
        val matchCount = ticket.countMatches(winningLotto.getNumbers())
        val hasBonus = ticket.contains(bonusNumber)

        return LottoGrade.valueOfMatch(matchCount, hasBonus)
    }

}