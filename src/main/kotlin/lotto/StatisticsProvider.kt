package lotto

class StatisticsProvider {

    private fun checkIfWon(ticket: List<Int>, winningNums: MutableList<Int>, bonusNum: Int, statistics: MutableList<Double> )
    {
        val guessedNums = ticket.intersect(winningNums)
        var numberOfGuesses = guessedNums.size - 3
        if (numberOfGuesses < 0 )
            return
        if (numberOfGuesses == 3)
            numberOfGuesses += 1
        if ((numberOfGuesses == 2) and (ticket.contains(bonusNum)))
            numberOfGuesses += 1
        statistics[numberOfGuesses] += 1.0
    }

    private fun countWinningTickets(playedTickets: List<Lotto>, winningNums: MutableList<Int>, bonusNum: Int, statistics: MutableList<Double>)
    {
        for (ticket in playedTickets)
        {
            checkIfWon(ticket.numbersGetter(), winningNums, bonusNum, statistics)
        }
    }

    private fun calculateReturnRate (statistics: MutableList<Double>, spentAmount: Int)
    {
        val totalWinnings = (statistics[0] * 5000) + (statistics[1] * 50000) + (statistics[2] * 1500000) + (statistics[3] * 30000000) + (statistics[4] * 2000000000)
        statistics[5] = totalWinnings / spentAmount * 100
    }

    fun provideStatistics(playedTickets: List<Lotto>, winningNums: MutableList<Int>, bonusNum: Int, spentAmount: Int): MutableList<Double>
    {
        val statisticsToReturn = MutableList(6) { 0.0 }
        countWinningTickets (playedTickets, winningNums, bonusNum, statisticsToReturn)
        calculateReturnRate(statisticsToReturn, spentAmount)
        return statisticsToReturn
    }
}