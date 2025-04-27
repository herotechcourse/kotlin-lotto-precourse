package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    fun getRandomNumbers(): Lotto
    {
        var randomNumbers = mutableListOf<Int>()
        randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        var sortedRandomNumbers = randomNumbers.sorted()
        return Lotto(sortedRandomNumbers)
    }
    fun getTickets(number: Int): List<Lotto>
    {
        var tickets = mutableListOf<Lotto>()
        for (i in 1..number)
        {
            val ticket = getRandomNumbers()
            tickets.add(ticket)
        }
        return tickets
    }
}