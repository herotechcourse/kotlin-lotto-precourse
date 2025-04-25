package lotto

import camp.nextstep.edu.missionutils.Randoms

class WinningLotto(val winner: List<Int>, val bonusNum: Int) {
    init {
        require(winner.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(bonusNum in 1..45) { "[ERROR] All lotto numbers must be between 1 and 45." }

    }

    fun getNumMatches(ticketList: List<Int>): Int {
        var inter = winner.intersect(ticketList)
        return (inter.size)
    }

    fun hasBonus(ticketList: List<Int>): Boolean {
        return (bonusNum in ticketList)
    }

    fun compareLists(ticketList: List<Int>): Int {
        val numMatches = getNumMatches(ticketList)
        if (numMatches == 5 && hasBonus(ticketList)) {
            return (7)
        }
        return (numMatches)
    }
}