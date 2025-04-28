package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.mutableListOf
import lotto.Lotto

class Service() {

    val userBudget = InputView.getPurchaseAmount()
    val ticketsAmount = calculateAmountOfTickets()
    val usersLottos = mutableListOf<Lotto>()
    val matchesMap = mutableMapOf<Int, Int>()
    val ticketPrice = 1000 // Assuming each ticket costs 1000 KRW
    val rankPrizes = mapOf(
            3 to 5000, // 3 matches -> 5,000 KRW
            4 to 50000, // 4 matches -> 50,000 KRW
            5 to 1500000, // 5 matches -> 1,500,000 KRW
            6 to 2000000000, // 6 matches -> 2,000,000,000 KRW
            7 to 30000000 // 5 matches + Bonus -> 30,000,000 KRW
        )

    lateinit var winningTicket: WinningLotto

    fun calculateAmountOfTickets(): Int {
        require(userBudget >= 1000) { "[ERROR] Insuficient funds, purchase failed"}
        return (userBudget / 1000)
    }

    fun generateTickets() {
        repeat(ticketsAmount) {
            val newTicketNum = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            usersLottos.add(Lotto(newTicketNum))
        }
    }

    fun fillMatchesMap() {
        for (lotto in usersLottos) {
            val rank = winningTicket.compareLists(lotto.getNumbers())
            matchesMap[rank] = matchesMap.getOrDefault(rank, 0) + 1
        }
    }

    fun calculateTotalEarnings(): Long {
        var totalEarnings = 0L
        for ((rank, count) in matchesMap) {
            val prize = rankPrizes[rank] ?: 0
            totalEarnings += prize * count
        }
        return totalEarnings
    }
    fun calculateReturnRate(): Double {
        val totalEarnings = calculateTotalEarnings()
        val totalSpent = ticketPrice * usersLottos.size
        return if (totalSpent > 0) {
            (totalEarnings.toDouble() / totalSpent) * 100
        } else {
            0.0
        }
    }


    fun setWinningTicket(ticket: List<Int>, bonusNum: Int) {
        winningTicket = WinningLotto(ticket, bonusNum)
    }

    fun start() {
        generateTickets()
        OutputView.printPurchasedTickets(usersLottos)
        val winningNumbers = InputView.getWinningNumbers()
        val bonusNum = InputView.getBonusNumber()
        setWinningTicket(winningNumbers, bonusNum)
        fillMatchesMap()
        val returnRate = calculateReturnRate()
        OutputView.printStatistics(matchesMap, returnRate)
    }
}