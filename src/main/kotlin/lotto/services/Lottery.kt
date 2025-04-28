package lotto.services

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.TicketPrice

class Lottery {
    fun getLotteryCount(budget: Int): Int {
        return budget / TicketPrice.TICKET.value
    }

    fun run(count: Int): List<List<Int>> {
        val result: MutableList<List<Int>> = mutableListOf()
        for (i in 1..count) {
            result.add(getRandom())
        }
        return result
    }

    internal fun getRandom(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}